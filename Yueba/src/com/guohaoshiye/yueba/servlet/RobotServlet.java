/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.ParameterDAO;
/*     */ import com.aiwan.dao.RobotDAO;
/*     */ import com.aiwan.dao.RobotrechargeDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Parameter;
/*     */ import com.aiwan.entity.Robot;
/*     */ import com.aiwan.entity.Robotrecharge;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import com.aiwan.util.Util;
/*     */ import com.game.server.web.GameWebServer;
/*     */ import com.game.server.web.GameWebServerService;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
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
/*     */ import javax.xml.namespace.QName;
/*     */ import net.sf.json.JSONObject;
/*     */ import org.apache.commons.fileupload.FileItem;
/*     */ import org.apache.commons.fileupload.FileUploadException;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItemFactory;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RobotServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  51 */   private RobotrechargeDAO rdao = new RobotrechargeDAO();
/*  52 */   private RobotDAO dao = new RobotDAO();
/*  53 */   private ParameterDAO pdao = new ParameterDAO();
/*  54 */   private Parameter parameter = new Parameter();
/*  55 */   private String flag = "";
/*  56 */   private JSONObject json = null;
/*  57 */   private PrintWriter out = null;
/*  58 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  62 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  67 */     response.setContentType("text/html;charset=utf-8");
/*  68 */     request.setCharacterEncoding("UTF-8");
/*  69 */     response.setCharacterEncoding("UTF-8");
/*  70 */     String op = request.getParameter("op");
/*  71 */     if ("robotList".equals(op)) {
/*  72 */       robotList(request, response);
/*  73 */     } else if ("imgUpload".equals(op)) {
/*  74 */       imgUpload(request, response);
/*  75 */     } else if ("addRobot".equals(op)) {
/*  76 */       addRobot(request, response);
/*  77 */     } else if ("updateRobot".equals(op)) {
/*  78 */       updateRobot(request, response);
/*  79 */     } else if ("findById".equals(op)) {
/*  80 */       findById(request, response);
/*  81 */     } else if ("updateStatus".equals(op)) {
/*  82 */       updateStatus(request, response);
/*  83 */     } else if ("rechargeGold".equals(op)) {
/*  84 */       rechargeGold(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */   private void rechargeGold(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  90 */     int aid = Integer.parseInt(request.getParameter("aid"));
/*  91 */     int rid = Integer.parseInt(request.getParameter("rid"));
/*  92 */     int money = Integer.parseInt(request.getParameter("money"));
/*  93 */     Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
/*  94 */     GameWebServerService wb = null;
/*     */     try {
/*  96 */       wb = new GameWebServerService(new URL(parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */     }
/*     */     catch (MalformedURLException e) {
/*  99 */       e.printStackTrace();
/*     */     }
/* 101 */     wb.getGameWebServerPort().addGold(Integer.valueOf(money), Integer.valueOf(rid), 3);
/* 102 */     Robotrecharge robotrecharge = new Robotrecharge();
/* 103 */     robotrecharge.setAid(Integer.valueOf(aid));
/* 104 */     robotrecharge.setGold(Integer.valueOf(money));
/* 105 */     robotrecharge.setRid(Integer.valueOf(rid));
/* 106 */     robotrecharge.setTime(new Timestamp(System.currentTimeMillis()));
/* 107 */     this.rdao.save(robotrecharge);
/*     */     try {
/* 109 */       this.out = response.getWriter();
/* 110 */       this.out.print("ok");
/* 111 */       this.out.flush();
/* 112 */       this.out.close();
/*     */     } catch (IOException e) {
/* 114 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateStatus(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 125 */     int id = Integer.parseInt(request.getParameter("id"));
/* 126 */     Robot users = (Robot)this.dao.findById(Integer.valueOf(id));
/* 127 */     short status = Short.parseShort(request.getParameter("status"));
/* 128 */     String[] names = { "status" };
/* 129 */     Object[] values = { Short.valueOf(status) };
/* 130 */     this.dao.partUpdate(id, names, values);
/*     */     
/* 132 */     String ipClients = Util.getIpAddress(request);
/* 133 */     HttpSession session = request.getSession();
/* 134 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 135 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 136 */       if (ipClients.equals(entry.getKey())) {
/* 137 */         Admin value = (Admin)entry.getValue();
/* 138 */         AdminopLog l = new AdminopLog();
/* 139 */         l.setAid(value.getId());
/* 140 */         l.setDescription("修改了ID为[" + users.getId() + "]的机器人账号状态");
/* 141 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 142 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 146 */       this.out = response.getWriter();
/* 147 */       this.out.print("ok");
/* 148 */       this.out.flush();
/* 149 */       this.out.close();
/*     */     } catch (IOException e) {
/* 151 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findById(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 162 */     this.json = new JSONObject();
/* 163 */     int id = Integer.parseInt(request.getParameter("id"));
/* 164 */     Robot robot = (Robot)this.dao.findById(Integer.valueOf(id));
/* 165 */     this.json = JSONObject.fromObject(robot);
/*     */     try {
/* 167 */       this.out = response.getWriter();
/* 168 */       this.out.print(this.json);
/* 169 */       this.out.flush();
/* 170 */       this.out.close();
/*     */     } catch (IOException e) {
/* 172 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateRobot(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 183 */     int id = Integer.parseInt(request.getParameter("robotId"));
/* 184 */     String nickname = request.getParameter("realName");
/* 185 */     String autograph = request.getParameter("myself");
/* 186 */     String head = request.getParameter("userFace");
/* 187 */     Robot robot = (Robot)this.dao.findById(Integer.valueOf(id));
/* 188 */     robot.setNickname(nickname);
/* 189 */     robot.setAutograph(autograph);
/* 190 */     robot.setHead(head);
/* 191 */     this.dao.update(robot);
/* 192 */     String ipClients = Util.getIpAddress(request);
/* 193 */     HttpSession session = request.getSession();
/* 194 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 195 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 196 */       if (ipClients.equals(entry.getKey())) {
/* 197 */         Admin value = (Admin)entry.getValue();
/* 198 */         AdminopLog l = new AdminopLog();
/* 199 */         l.setAid(value.getId());
/* 200 */         l.setDescription("对ID为[" + robot.getId() + "]机器人进行了修改操作");
/* 201 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 202 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 206 */       this.out = response.getWriter();
/* 207 */       this.out.print("ok");
/* 208 */       this.out.flush();
/* 209 */       this.out.close();
/*     */     } catch (IOException e) {
/* 211 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addRobot(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 222 */     String account = request.getParameter("account");
/* 223 */     String nickname = request.getParameter("realName");
/* 224 */     String autograph = request.getParameter("myself");
/* 225 */     String head = request.getParameter("userFace");
/* 226 */     Robot robot = new Robot();
/* 227 */     robot.setAccount(account);
/* 228 */     robot.setNickname(nickname);
/* 229 */     robot.setAutograph(autograph);
/* 230 */     robot.setHead(head);
/* 231 */     Timestamp d = new Timestamp(System.currentTimeMillis());
/* 232 */     robot.setCreatetime(d);
/* 233 */     robot.setStatus(Short.valueOf(Short.parseShort("0")));
/* 234 */     robot.setGold(Integer.valueOf(0));
/* 235 */     robot.setIntegral(Integer.valueOf(0));
/* 236 */     this.dao.save(robot);
/* 237 */     String ipClients = Util.getIpAddress(request);
/* 238 */     HttpSession session = request.getSession();
/* 239 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 240 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 241 */       if (ipClients.equals(entry.getKey())) {
/* 242 */         Admin value = (Admin)entry.getValue();
/* 243 */         AdminopLog l = new AdminopLog();
/* 244 */         l.setAid(value.getId());
/* 245 */         l.setDescription("添加了新的机器人");
/* 246 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 247 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 251 */       this.out = response.getWriter();
/* 252 */       this.out.print("ok");
/* 253 */       this.out.flush();
/* 254 */       this.out.close();
/*     */     } catch (IOException e) {
/* 256 */       e.printStackTrace();
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
/* 267 */     this.json = new JSONObject();
/*     */     
/* 269 */     DiskFileItemFactory factory = new DiskFileItemFactory();
/*     */     
/* 271 */     ServletFileUpload upload = new ServletFileUpload(factory);
/*     */     
/*     */ 
/* 274 */     upload.setHeaderEncoding("UTF-8");
/* 275 */     factory.setSizeThreshold(512000);
/* 276 */     File linshi = new File("C:\\linshi");
/* 277 */     factory.setRepository(linshi);
/* 278 */     upload.setSizeMax(5242880L);
/*     */     try
/*     */     {
/* 281 */       List<FileItem> items = upload.parseRequest(request);
/*     */       
/* 283 */       for (FileItem item : items)
/*     */       {
/* 285 */         if (item.isFormField()) {
/* 286 */           String name = item.getFieldName();
/* 287 */           String str1 = item.getString("utf-8");
/*     */         }
/*     */         else {
/* 290 */           String fileName = item.getName();
/* 291 */           long sizeInBytes = item.getSize();
/* 292 */           InputStream in = item.getInputStream();
/* 293 */           byte[] buffer = new byte['Ѐ'];
/* 294 */           int len = 0;
/* 295 */           String property = request.getSession().getServletContext().getRealPath("");
/* 296 */           Date date = new Date();
/* 297 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
/* 298 */           String imageupdatename = sdf.format(date);
/* 299 */           imageupdatename = imageupdatename + ".png";
/* 300 */           fileName = property + "/imgLoad/robotImg/" + imageupdatename;
/* 301 */           OutputStream out = new FileOutputStream(fileName);
/* 302 */           while ((len = in.read(buffer)) != -1) {
/* 303 */             out.write(buffer, 0, len);
/*     */           }
/* 305 */           out.close();
/* 306 */           in.close();
/*     */           
/* 308 */           this.json.put("str", "imgLoad/robotImg/" + imageupdatename);
/*     */         }
/*     */       }
/*     */     } catch (IOException e) {
/* 312 */       this.json.put("str", "no");
/* 313 */       e.printStackTrace();
/*     */     } catch (FileUploadException e) {
/* 315 */       this.json.put("str", "no");
/* 316 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 319 */       this.out = response.getWriter();
/* 320 */       this.out.print(this.json);
/* 321 */       this.out.flush();
/* 322 */       this.out.close();
/*     */     } catch (IOException e) {
/* 324 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void robotList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 336 */     String comp = request.getParameter("comp");
/* 337 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 338 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 339 */     Integer compAdd = Integer.valueOf(0);
/* 340 */     Integer compUpdate = Integer.valueOf(0);
/* 341 */     String[] splits = comp.split(",");
/* 342 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/* 343 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));
/* 344 */     Map<Integer, Long> map2 = new HashMap();
/* 345 */     String[] param = { "uid", "nickname", "status" };
/* 346 */     String[] paramValue = new String[param.length];
/* 347 */     for (int i = 0; i < param.length; i++) {
/* 348 */       paramValue[i] = request.getParameter(param[i]);
/* 349 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/* 351 */     PageModel<Robot> pm = this.dao.sqlRobot(currentPage, pageSize, param, paramValue);
/* 352 */     List<Robot> list = pm.getList();
/* 353 */     if (list.isEmpty()) {
/* 354 */       this.flag = "1";
/* 355 */       request.setAttribute("flag", this.flag);
/*     */     }
/* 357 */     String ids = "";
/* 358 */     for (Robot robot : list) {
/* 359 */       String string = this.dao.findCount("select IFNULL(SUM(gold),0)from robotrecharge where rid = " + robot.getId());
/* 360 */       long parseLong = Long.parseLong(string);
/* 361 */       sum = parseLong - robot.getIntegral().longValue();
/* 362 */       map2.put(robot.getId(), Long.valueOf(sum));
/* 363 */       ids = ids + robot.getId() + ",";
/*     */     }
/* 365 */     this.parameter = ((Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0));
/* 366 */     GameWebServerService wb = null;
/*     */     try {
/* 368 */       wb = new GameWebServerService(new URL(this.parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */     }
/*     */     catch (MalformedURLException e) {
/* 371 */       e.printStackTrace();
/*     */     }
/* 373 */     String line = wb.getGameWebServerPort().checkUserOnLine(ids);
/* 374 */     String[] split = line.split(",");
/* 375 */     Map<Integer, Integer> map = new HashMap();
/* 376 */     String[] arrayOfString1 = split;long sum = arrayOfString1.length; for (long l1 = 0; l1 < sum; l1++) { String string = arrayOfString1[l1];
/* 377 */       String[] split2 = string.split(":");
/* 378 */       map.put(Integer.valueOf(Integer.parseInt(split2[0])), Integer.valueOf(Integer.parseInt(split2[1])));
/*     */     }
/*     */     
/* 381 */     request.setAttribute("comp", comp);
/* 382 */     request.setAttribute("map", map);
/* 383 */     request.setAttribute("map2", map2);
/* 384 */     request.setAttribute("compAdd", compAdd);
/* 385 */     request.setAttribute("compUpdate", compUpdate);
/* 386 */     request.setAttribute("pm", pm);
/*     */     try {
/* 388 */       request.getRequestDispatcher("web/robotList.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 391 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 393 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\RobotServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */