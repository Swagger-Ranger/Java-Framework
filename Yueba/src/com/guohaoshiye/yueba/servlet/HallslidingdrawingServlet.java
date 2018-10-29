/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.HallslidingdrawingDAO;
/*     */ import com.aiwan.dao.ParameterDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Hallslidingdrawing;
/*     */ import com.aiwan.entity.Parameter;
/*     */ import com.aiwan.util.Util;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HallslidingdrawingServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  45 */   private String flag = "";
/*  46 */   private JSONObject json = null;
/*  47 */   private PrintWriter out = null;
/*  48 */   private HallslidingdrawingDAO dao = new HallslidingdrawingDAO();
/*  49 */   private ParameterDAO pdao = new ParameterDAO();
/*  50 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  54 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  59 */     response.setContentType("text/html;charset=utf-8");
/*  60 */     request.setCharacterEncoding("UTF-8");
/*  61 */     response.setCharacterEncoding("UTF-8");
/*  62 */     String op = request.getParameter("op");
/*  63 */     if ("hallslidingdrawingList".equals(op)) {
/*  64 */       hallslidingdrawingList(request, response);
/*  65 */     } else if ("addImgUpload".equals(op)) {
/*  66 */       addImgUpload(request, response);
/*  67 */     } else if ("addImg".equals(op)) {
/*  68 */       addImg(request, response);
/*  69 */     } else if ("updateImg".equals(op)) {
/*  70 */       updateImg(request, response);
/*  71 */     } else if ("deleteImg".equals(op)) {
/*  72 */       deleteImg(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void deleteImg(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  83 */     int id = Integer.parseInt(request.getParameter("id"));
/*  84 */     this.dao.delete(Integer.valueOf(id));
/*     */     
/*  86 */     String ipClients = Util.getIpAddress(request);
/*  87 */     HttpSession session = request.getSession();
/*  88 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/*  89 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/*  90 */       if (ipClients.equals(entry.getKey())) {
/*  91 */         Admin value = (Admin)entry.getValue();
/*  92 */         AdminopLog l = new AdminopLog();
/*  93 */         l.setAid(value.getId());
/*  94 */         l.setDescription("删除了一张公告封面");
/*  95 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  96 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 100 */       this.out = response.getWriter();
/* 101 */       this.out.print("ok");
/* 102 */       this.out.flush();
/* 103 */       this.out.close();
/*     */     } catch (IOException e) {
/* 105 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void updateImg(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 112 */     int id = Integer.parseInt(request.getParameter("id"));
/* 113 */     String url = request.getParameter("url");
/* 114 */     Hallslidingdrawing hallslidingdrawing = (Hallslidingdrawing)this.dao.findById(Integer.valueOf(id));
/* 115 */     hallslidingdrawing.setUrl(url);
/* 116 */     this.dao.update(hallslidingdrawing);
/*     */     
/* 118 */     String ipClients = Util.getIpAddress(request);
/* 119 */     HttpSession session = request.getSession();
/* 120 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 121 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 122 */       if (ipClients.equals(entry.getKey())) {
/* 123 */         Admin value = (Admin)entry.getValue();
/* 124 */         AdminopLog l = new AdminopLog();
/* 125 */         l.setAid(value.getId());
/* 126 */         l.setDescription("修改了一张公告封面");
/* 127 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 128 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 132 */       this.out = response.getWriter();
/* 133 */       this.out.print("ok");
/* 134 */       this.out.flush();
/* 135 */       this.out.close();
/*     */     } catch (IOException e) {
/* 137 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void addImg(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 144 */     String url = request.getParameter("url");
/* 145 */     Timestamp d = new Timestamp(System.currentTimeMillis());
/* 146 */     Hallslidingdrawing hallslidingdrawing = new Hallslidingdrawing();
/* 147 */     hallslidingdrawing.setUrl(url);
/* 148 */     hallslidingdrawing.setCreatetime(d);
/* 149 */     hallslidingdrawing.setState(Integer.valueOf(0));
/* 150 */     this.dao.save(hallslidingdrawing);
/*     */     
/* 152 */     String ipClients = Util.getIpAddress(request);
/* 153 */     HttpSession session = request.getSession();
/* 154 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 155 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 156 */       if (ipClients.equals(entry.getKey())) {
/* 157 */         Admin value = (Admin)entry.getValue();
/* 158 */         AdminopLog l = new AdminopLog();
/* 159 */         l.setAid(value.getId());
/* 160 */         l.setDescription("添加了一张公告封面");
/* 161 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 162 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 166 */       this.out = response.getWriter();
/* 167 */       this.out.print("ok");
/* 168 */       this.out.flush();
/* 169 */       this.out.close();
/*     */     } catch (IOException e) {
/* 171 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addImgUpload(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 182 */     this.json = new JSONObject();
/* 183 */     String property = request.getSession().getServletContext().getRealPath("");
/* 184 */     Date date = new Date();
/* 185 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
/* 186 */     String imageupdatename = sdf.format(date);
/* 187 */     Integer width = Integer.valueOf(Integer.parseInt(request.getParameter("width")));
/* 188 */     Integer height = Integer.valueOf(Integer.parseInt(request.getParameter("height")));
/*     */     
/* 190 */     DiskFileItemFactory factory = new DiskFileItemFactory();
/*     */     
/* 192 */     ServletFileUpload upload = new ServletFileUpload(factory);
/* 193 */     upload.setHeaderEncoding("UTF-8");
/* 194 */     factory.setSizeThreshold(512000);
/* 195 */     File linshi = new File("C:\\linshi");
/* 196 */     factory.setRepository(linshi);
/* 197 */     upload.setSizeMax(5242880L);
/*     */     try
/*     */     {
/* 200 */       List<FileItem> items = upload.parseRequest(request);
/*     */       
/* 202 */       for (FileItem item : items)
/*     */       {
/* 204 */         if (item.isFormField()) {
/* 205 */           String name = item.getFieldName();
/* 206 */           String str1 = item.getString("utf-8");
/*     */         }
/*     */         else
/*     */         {
/* 210 */           String fileName = item.getName();
/* 211 */           long sizeInBytes = item.getSize();
/* 212 */           InputStream in = item.getInputStream();
/* 213 */           byte[] buffer = new byte['Ѐ'];
/* 214 */           int len = 0;
/* 215 */           fileName = property + "/imgLoad/temp/" + imageupdatename + ".png";
/* 216 */           OutputStream out = new FileOutputStream(fileName);
/* 217 */           while ((len = in.read(buffer)) != -1) {
/* 218 */             out.write(buffer, 0, len);
/*     */           }
/* 220 */           out.close();
/* 221 */           in.close();
/* 222 */           File file = new File(fileName);
/* 223 */           int imgWidth = Util.getImgWidth(file);
/* 224 */           int imgHeight = Util.getImgHeight(file);
/*     */           
/*     */ 
/* 227 */           if ((imgWidth == width.intValue()) && (imgHeight == height.intValue())) {
/* 228 */             String fileName2 = property + "/imgLoad/" + imageupdatename + ".png";
/* 229 */             file2 = new File(fileName2);
/*     */             
/* 231 */             file.deleteOnExit();
/*     */             try
/*     */             {
/* 234 */               file2.createNewFile();
/*     */             } catch (IOException e) {
/* 236 */               e.printStackTrace();
/*     */             }
/* 238 */             Util.cutFile(file, file2);
/* 239 */             String contextPath = request.getContextPath();
/* 240 */             Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name = ?", new Object[] { "domainName" }).get(0);
/* 241 */             String urlName = parameter.getValue() + "" + contextPath + "/imgLoad/" + imageupdatename + ".png";
/* 242 */             this.json.put("icon", "1");
/* 243 */             this.json.put("url", urlName);
/*     */           } else {
/* 245 */             this.json.put("icon", "0");
/*     */           }
/* 247 */           File file1 = new File(fileName);
/* 248 */           File file2 = file1.delete();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 253 */       e.printStackTrace();
/*     */     } catch (FileUploadException e) {
/* 255 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 258 */       this.out = response.getWriter();
/* 259 */       this.out.print(this.json);
/* 260 */       this.out.flush();
/* 261 */       this.out.close();
/*     */     } catch (IOException e) {
/* 263 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void hallslidingdrawingList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 270 */     String comp = request.getParameter("comp");
/* 271 */     Integer compAdd = Integer.valueOf(0);
/* 272 */     Integer compDelete = Integer.valueOf(0);
/* 273 */     Integer compUpdate = Integer.valueOf(0);
/* 274 */     String[] splits = comp.split(",");
/* 275 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/* 276 */     compDelete = Integer.valueOf(Integer.parseInt(splits[1]));
/* 277 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[2]));
/* 278 */     List<Hallslidingdrawing> list = this.dao.findByHQL("from Hallslidingdrawing", null);
/* 279 */     if (list.isEmpty()) {
/* 280 */       this.flag = "1";
/* 281 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     try {
/* 284 */       request.setAttribute("list", list);
/* 285 */       request.setAttribute("compAdd", compAdd);
/* 286 */       request.setAttribute("compDelete", compDelete);
/* 287 */       request.setAttribute("compUpdate", compUpdate);
/* 288 */       request.setAttribute("comp", comp);
/* 289 */       request.getRequestDispatcher("web/hallslidingdrawingList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 291 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\HallslidingdrawingServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */