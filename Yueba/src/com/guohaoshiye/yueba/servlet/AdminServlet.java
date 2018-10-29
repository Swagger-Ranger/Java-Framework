/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminDAO;
/*     */ import com.aiwan.dao.AdminRoleDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminMenu;
/*     */ import com.aiwan.entity.AdminRole;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import com.aiwan.util.Util;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import net.sf.json.JSONObject;
/*     */ import org.apache.commons.fileupload.FileItem;
/*     */ import org.apache.commons.fileupload.FileUploadException;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItemFactory;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ 
/*     */ 
/*     */ public class AdminServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  42 */   private AdminDAO dao = new AdminDAO();
/*  43 */   private AdminRoleDAO ardao = new AdminRoleDAO();
/*  44 */   private String flag = "";
/*  45 */   private JSONObject json = null;
/*  46 */   private PrintWriter out = null;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  50 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  55 */     response.setContentType("text/html;charset=utf-8");
/*  56 */     request.setCharacterEncoding("UTF-8");
/*  57 */     response.setCharacterEncoding("UTF-8");
/*  58 */     String op = request.getParameter("op");
/*  59 */     if ("adminList".equals(op))
/*     */     {
/*  61 */       adminList(request, response);
/*  62 */     } else if ("isPwd".equals(op))
/*     */     {
/*  64 */       isPwd(request, response);
/*  65 */     } else if ("updatePwd".equals(op)) {
/*  66 */       updatePwd(request, response);
/*  67 */     } else if ("imgUpload".equals(op)) {
/*  68 */       imgUpload(request, response);
/*  69 */     } else if ("updateImg".equals(op)) {
/*  70 */       updateImg(request, response);
/*  71 */     } else if ("addAdmin".equals(op)) {
/*  72 */       addAdmin(request, response);
/*  73 */     } else if ("findByIdAdmin".equals(op)) {
/*  74 */       findByIdAdmin(request, response);
/*  75 */     } else if ("updateAdmin".equals(op)) {
/*  76 */       updateAdmin(request, response);
/*  77 */     } else if ("deleteByIdAdmin".equals(op)) {
/*  78 */       deleteByIdAdmin(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void deleteByIdAdmin(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  90 */     int id = Integer.parseInt(request.getParameter("aid"));
/*  91 */     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));
/*  92 */     this.ardao.deleteRole(Integer.valueOf(id));
/*  93 */     this.dao.delete(Integer.valueOf(id));
/*     */     try {
/*  95 */       this.out = response.getWriter();
/*  96 */       this.out.print("ok");
/*  97 */       this.out.flush();
/*  98 */       this.out.close();
/*     */     } catch (IOException e) {
/* 100 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 112 */     int id = Integer.parseInt(request.getParameter("id"));
/* 113 */     String opname = request.getParameter("opname");
/*     */     
/* 115 */     String nodes = request.getParameter("nodes");
/* 116 */     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));
/* 117 */     admin.setOpname(opname);
/* 118 */     admin.setHead("null");
/* 119 */     this.ardao.deleteRole(admin.getId());
/* 120 */     this.dao.update(admin);
/* 121 */     String[] split = nodes.split("\\@");
/* 122 */     for (String string : split) {
/* 123 */       String[] split2 = string.split("\\[");
/* 124 */       String ss = "0";
/* 125 */       if (split2[1].length() > 1) {
/* 126 */         ss = split2[1].split("\\]")[0];
/*     */       }
/* 128 */       AdminRole ar = new AdminRole();
/* 129 */       ar.setAdmin(admin);
/* 130 */       AdminMenu adminMenu = new AdminMenu();
/* 131 */       adminMenu.setId(Integer.valueOf(Integer.parseInt(split2[0])));
/* 132 */       ar.setAdminMenu(adminMenu);
/* 133 */       ar.setOp(ss);
/* 134 */       this.ardao.save(ar);
/*     */     }
/*     */     try {
/* 137 */       this.out = response.getWriter();
/* 138 */       this.out.print("ok");
/* 139 */       this.out.flush();
/* 140 */       this.out.close();
/*     */     } catch (IOException e) {
/* 142 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findByIdAdmin(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 153 */     this.json = new JSONObject();
/* 154 */     int id = Integer.parseInt(request.getParameter("aid"));
/* 155 */     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));
/*     */     
/* 157 */     this.json.put("adminname", admin.getAdminname());
/* 158 */     this.json.put("head", admin.getHead());
/* 159 */     this.json.put("id", admin.getId());
/* 160 */     this.json.put("opname", admin.getOpname());
/* 161 */     Set<AdminRole> set = admin.getAdminRoles();
/* 162 */     JSONArray jsons = new JSONArray();
/* 163 */     for (AdminRole adminRole : set) {
/* 164 */       JSONObject json2 = new JSONObject();
/* 165 */       json2.put("mid", adminRole.getAdminMenu().getId());
/* 166 */       if (!"0".equals(adminRole.getOp())) {
/* 167 */         if ("1".equals(adminRole.getOp().substring(0, 1))) {
/* 168 */           json2.put("op1", adminRole.getAdminMenu().getId() + "01");
/*     */         } else {
/* 170 */           json2.put("op1", "10000");
/*     */         }
/* 172 */         if ("1".equals(adminRole.getOp().substring(2, 3))) {
/* 173 */           json2.put("op2", adminRole.getAdminMenu().getId() + "02");
/*     */         } else {
/* 175 */           json2.put("op2", "10000");
/*     */         }
/* 177 */         if ("1".equals(adminRole.getOp().substring(4, 5))) {
/* 178 */           json2.put("op3", adminRole.getAdminMenu().getId() + "03");
/*     */         } else {
/* 180 */           json2.put("op3", "10000");
/*     */         }
/*     */       }
/* 183 */       jsons.add(json2);
/*     */     }
/* 185 */     this.json.put("role", jsons);
/*     */     try {
/* 187 */       this.out = response.getWriter();
/* 188 */       this.out.print(this.json);
/* 189 */       this.out.flush();
/* 190 */       this.out.close();
/*     */     } catch (IOException e) {
/* 192 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addAdmin(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 203 */     String flg = "1";
/* 204 */     String aname = request.getParameter("aname");
/* 205 */     String pwd = request.getParameter("pwd");
/* 206 */     String opname = request.getParameter("opname");
/*     */     
/* 208 */     String nodes = request.getParameter("nodes");
/* 209 */     List<Admin> list = this.dao.findByHQL("from Admin where adminname=?", new Object[] { aname });
/* 210 */     if (list.size() > 0) {
/* 211 */       flg = "0";
/*     */     } else {
/* 213 */       Timestamp d = new Timestamp(System.currentTimeMillis());
/* 214 */       Admin admin = new Admin();
/* 215 */       admin.setAdminname(aname);
/* 216 */       admin.setPassword(Util.Md5(pwd));
/* 217 */       admin.setHead("null");
/* 218 */       admin.setOpname(opname);
/* 219 */       admin.setCreatetime(d);
/* 220 */       this.dao.save(admin);
/* 221 */       List<Admin> admin2 = this.dao.findByHQL("from Admin where adminname=?", new Object[] { aname });
/*     */       
/* 223 */       String[] split = nodes.split("\\@");
/* 224 */       for (String string : split) {
/* 225 */         String[] split2 = string.split("\\[");
/* 226 */         String ss = "0";
/* 227 */         if (split2[1].length() > 1) {
/* 228 */           ss = split2[1].split("\\]")[0];
/*     */         }
/* 230 */         AdminRole ar = new AdminRole();
/* 231 */         ar.setAdmin((Admin)admin2.get(0));
/* 232 */         AdminMenu adminMenu = new AdminMenu();
/* 233 */         adminMenu.setId(Integer.valueOf(Integer.parseInt(split2[0])));
/* 234 */         ar.setAdminMenu(adminMenu);
/* 235 */         ar.setOp(ss);
/* 236 */         this.ardao.save(ar);
/*     */       }
/*     */     }
/*     */     try {
/* 240 */       this.out = response.getWriter();
/* 241 */       this.out.print(flg);
/* 242 */       this.out.flush();
/* 243 */       this.out.close();
/*     */     } catch (IOException e) {
/* 245 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateImg(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 257 */     String url = request.getParameter("url");
/* 258 */     HttpSession session = request.getSession();
/* 259 */     Admin attribute = (Admin)session.getAttribute("admin");
/* 260 */     Admin admin = (Admin)this.dao.findById(attribute.getId());
/* 261 */     admin.setHead(url);
/* 262 */     this.dao.update(admin);
/* 263 */     session.setAttribute("admin", admin);
/*     */     try {
/* 265 */       this.out = response.getWriter();
/* 266 */       this.out.print("ok");
/* 267 */       this.out.flush();
/* 268 */       this.out.close();
/*     */     } catch (IOException e) {
/* 270 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void imgUpload(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 281 */     this.json = new JSONObject();
/*     */     
/* 283 */     DiskFileItemFactory factory = new DiskFileItemFactory();
/*     */     
/* 285 */     ServletFileUpload upload = new ServletFileUpload(factory);
/*     */     
/*     */ 
/* 288 */     upload.setHeaderEncoding("UTF-8");
/* 289 */     factory.setSizeThreshold(512000);
/* 290 */     File linshi = new File("C:\\linshi");
/* 291 */     factory.setRepository(linshi);
/* 292 */     upload.setSizeMax(5242880L);
/*     */     try
/*     */     {
/* 295 */       List<FileItem> items = upload.parseRequest(request);
/*     */       
/* 297 */       for (FileItem item : items)
/*     */       {
/* 299 */         if (item.isFormField()) {
/* 300 */           String name = item.getFieldName();
/* 301 */           String str1 = item.getString("utf-8");
/*     */         }
/*     */         else {
/* 304 */           String fileName = item.getName();
/* 305 */           long sizeInBytes = item.getSize();
/* 306 */           InputStream in = item.getInputStream();
/* 307 */           byte[] buffer = new byte['Ѐ'];
/* 308 */           int len = 0;
/* 309 */           String property = request.getSession().getServletContext().getRealPath("");
/* 310 */           Date date = new Date();
/* 311 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
/* 312 */           String imageupdatename = sdf.format(date);
/* 313 */           imageupdatename = imageupdatename + ".png";
/* 314 */           fileName = property + "/imgLoad/robotImg/" + imageupdatename;
/* 315 */           OutputStream out = new FileOutputStream(fileName);
/* 316 */           while ((len = in.read(buffer)) != -1) {
/* 317 */             out.write(buffer, 0, len);
/*     */           }
/* 319 */           out.close();
/* 320 */           in.close();
/*     */           
/* 322 */           this.json.put("str", "imgLoad/robotImg/" + imageupdatename);
/*     */         }
/*     */       }
/*     */     } catch (IOException e) {
/* 326 */       this.json.put("str", "no");
/* 327 */       e.printStackTrace();
/*     */     } catch (FileUploadException e) {
/* 329 */       this.json.put("str", "no");
/* 330 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 333 */       this.out = response.getWriter();
/* 334 */       this.out.print(this.json);
/* 335 */       this.out.flush();
/* 336 */       this.out.close();
/*     */     } catch (IOException e) {
/* 338 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updatePwd(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 349 */     String pwd = request.getParameter("pwd");
/* 350 */     HttpSession session = request.getSession();
/*     */     
/* 352 */     Admin attribute = null;
/* 353 */     String ipClients; if ((session != null) || (session.getAttribute("mapAdmin") != null)) {
/* 354 */       Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 355 */       ipClients = Util.getIpAddress(request);
/* 356 */       for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 357 */         if ((ipClients.equals(entry.getKey())) && 
/* 358 */           (entry.getValue() != null)) {
/* 359 */           attribute = (Admin)entry.getValue();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 364 */     Admin admin = (Admin)this.dao.findById(attribute.getId());
/* 365 */     admin.setPassword(Util.Md5(pwd));
/* 366 */     this.dao.update(admin);
/*     */     try {
/* 368 */       this.out = response.getWriter();
/* 369 */       this.out.print("ok");
/* 370 */       this.out.flush();
/* 371 */       this.out.close();
/*     */     } catch (IOException e) {
/* 373 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void isPwd(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 384 */     String str = "";
/* 385 */     String pwd = Util.Md5(request.getParameter("pwd"));
/* 386 */     HttpSession session = request.getSession();
/* 387 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 388 */     String ipClients = Util.getIpAddress(request);
/* 389 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 390 */       if (ipClients.equals(entry.getKey())) {
/* 391 */         if (((Admin)entry.getValue()).getPassword().equals(pwd)) {
/* 392 */           str = "ok";
/*     */         } else {
/* 394 */           str = "no";
/*     */         }
/*     */       }
/*     */     }
/*     */     try {
/* 399 */       this.out = response.getWriter();
/* 400 */       this.out.print(str);
/* 401 */       this.out.flush();
/* 402 */       this.out.close();
/*     */     } catch (IOException e) {
/* 404 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void adminList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 416 */     String comp = request.getParameter("comp");
/* 417 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 418 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 419 */     Integer compAdd = Integer.valueOf(0);
/* 420 */     Integer compDelete = Integer.valueOf(0);
/* 421 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/* 423 */     String[] splits = comp.split(",");
/*     */     
/* 425 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/* 426 */     compDelete = Integer.valueOf(Integer.parseInt(splits[1]));
/* 427 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[2]));
/*     */     
/* 429 */     PageModel<Admin> pm = this.dao.pageList(currentPage, pageSize);
/* 430 */     List<Admin> list = pm.getList();
/* 431 */     if (list.isEmpty()) {
/* 432 */       this.flag = "1";
/* 433 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     try {
/* 436 */       request.setAttribute("pm", pm);
/* 437 */       request.setAttribute("compAdd", compAdd);
/* 438 */       request.setAttribute("compDelete", compDelete);
/* 439 */       request.setAttribute("compUpdate", compUpdate);
/* 440 */       request.setAttribute("comp", comp);
/* 441 */       request.getRequestDispatcher("web/adminList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 443 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AdminServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */