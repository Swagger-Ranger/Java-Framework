/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminRechargeLogDAO;
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.ParameterDAO;
/*     */ import com.aiwan.dao.SystemLogDAO;
/*     */ import com.aiwan.dao.UsersDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminRechargeLog;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Parameter;
/*     */ import com.aiwan.entity.SystemLog;
/*     */ import com.aiwan.entity.Users;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import com.aiwan.util.Util;
/*     */ import com.game.server.web.GameWebServer;
/*     */ import com.game.server.web.GameWebServerService;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.xml.namespace.QName;
/*     */ import net.sf.json.JSONArray;
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ public class UsersServlet extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  44 */   private UsersDAO dao = new UsersDAO();
/*  45 */   private ParameterDAO pdao = new ParameterDAO();
/*  46 */   private AdminRechargeLogDAO arldao = new AdminRechargeLogDAO();
/*  47 */   private String flag = "";
/*  48 */   private JSONObject json = null;
/*  49 */   private PrintWriter out = null;
/*  50 */   private SystemLogDAO sdao = new SystemLogDAO();
/*  51 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  55 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  60 */     response.setContentType("text/html;charset=utf-8");
/*  61 */     request.setCharacterEncoding("UTF-8");
/*  62 */     response.setCharacterEncoding("UTF-8");
/*  63 */     String op = request.getParameter("op");
/*  64 */     if ("userslist".equals(op)) {
/*  65 */       userslist(request, response);
/*  66 */     } else if ("updateStatus".equals(op)) {
/*  67 */       updateStatus(request, response);
/*  68 */     } else if ("rechargeGold".equals(op)) {
/*  69 */       rechargeGold(request, response);
/*  70 */     } else if ("newDayUser".equals(op)) {
/*  71 */       newDayUser(request, response);
/*  72 */     } else if ("updateUserSeparate".equals(op)) {
/*  73 */       updateUserSeparate(request, response);
/*  74 */     } else if ("sendPlacard".equals(op)) {
/*  75 */       sendPlacard(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendPlacard(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  88 */     String mag = request.getParameter("msg");
/*  89 */     Parameter p = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
/*  90 */     SystemLog log = new SystemLog();
/*  91 */     HttpSession session = request.getSession();
/*  92 */     String ipClients = Util.getIpAddress(request);
/*  93 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/*  94 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/*  95 */       if (ipClients.equals(entry.getKey())) {
/*  96 */         log.setAid(((Admin)entry.getValue()).getId());
/*     */       }
/*     */     }
/*  99 */     log.setOperating("发送及时公告");
/* 100 */     log.setContent(mag);
/* 101 */     log.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 102 */     this.sdao.save(log);
/* 103 */     GameWebServerService wb = null;
/*     */     try {
/* 105 */       URL url = new URL(p.getValue());
/* 106 */       wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */       
/* 108 */       wb.getGameWebServerPort().message(mag, 1); return;
/*     */     } catch (MalformedURLException e1) {
/* 110 */       e1.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 113 */         this.out = response.getWriter();
/* 114 */         this.out.print("ok");
/* 115 */         this.out.flush();
/* 116 */         this.out.close();
/*     */       } catch (IOException e) {
/* 118 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateUserSeparate(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 130 */     String ipClients = Util.getIpAddress(request);
/* 131 */     int id = Integer.parseInt(request.getParameter("id"));
/* 132 */     Users users = (Users)this.dao.findById(Integer.valueOf(id));
/* 133 */     String[] names = { "pid" };
/* 134 */     Object[] values = { Integer.valueOf(0) };
/* 135 */     this.dao.partUpdate(id, names, values);
/*     */     
/* 137 */     HttpSession session = request.getSession();
/* 138 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 139 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 140 */       if (ipClients.equals(entry.getKey())) {
/* 141 */         Admin value = (Admin)entry.getValue();
/* 142 */         AdminopLog l = new AdminopLog();
/* 143 */         l.setAid(value.getId());
/* 144 */         l.setDescription("对ID为[" + users.getId() + "]的用户进行了脱离操作");
/* 145 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 146 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 150 */       this.out = response.getWriter();
/* 151 */       this.out.print("ok");
/* 152 */       this.out.flush();
/* 153 */       this.out.close();
/*     */     } catch (IOException e) {
/* 155 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void newDayUser(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 167 */     this.json = new JSONObject();
/*     */     
/* 169 */     Date day = new Date();
/* 170 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 171 */     String date = df.format(day);
/* 172 */     String begin = date + " 0:0:0";
/* 173 */     String end = date + " 23:59:59";
/*     */     
/*     */ 
/* 176 */     String newDayProxyCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from proxy where createTime>='" + begin + "'");
/*     */     
/* 178 */     String ProxyCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from proxy");
/*     */     
/*     */ 
/*     */ 
/* 182 */     String newDayUserCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users where createtime>='" + begin + "' and createtime<='" + end + "'");
/*     */     
/* 184 */     String UserCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users");
/*     */     
/* 186 */     String integralUser = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users where integral>0");
/* 187 */     Map<Integer, String> map = this.dao.findGameCount("select playtype,count(*) from game_alllog GROUP BY playtype");
/* 188 */     Map<Integer, String> map2 = this.dao.findGameCount("select playtype,count(*) from (select * from game_alllog where creattime>='" + begin + "' and creattime<='" + end + "') as ss GROUP BY playtype");
/*     */     
/*     */ 
/* 191 */     List<SystemLog> loglist = this.sdao.findlist();
/* 192 */     JSONArray jsonloglist = JSONArray.fromObject(loglist);
/*     */     
/* 194 */     Parameter p = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
/* 195 */     GameWebServerService wb = null;
/* 196 */     Integer onlineCount = Integer.valueOf(0);
/* 197 */     boolean status = false;
/*     */     try {
/* 199 */       URL url = new URL(p.getValue());
/* 200 */       wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */       
/* 202 */       onlineCount = wb.getGameWebServerPort().userCount();
/* 203 */       status = wb.getGameWebServerPort().getServerStatus(); return;
/*     */     } catch (MalformedURLException e1) {
/* 205 */       e1.printStackTrace();
/*     */     } finally {
/* 207 */       this.json.put("status", Boolean.valueOf(status));
/* 208 */       this.json.put("loglist", jsonloglist);
/* 209 */       this.json.put("zong1", map.get(Integer.valueOf(1)));
/* 210 */       this.json.put("zong2", map.get(Integer.valueOf(2)));
/* 211 */       this.json.put("zong3", map.get(Integer.valueOf(3)));
/* 212 */       this.json.put("zong4", map.get(Integer.valueOf(4)));
/* 213 */       this.json.put("jin1", map2.get(Integer.valueOf(1)));
/* 214 */       this.json.put("jin2", map2.get(Integer.valueOf(2)));
/* 215 */       this.json.put("jin3", map2.get(Integer.valueOf(3)));
/* 216 */       this.json.put("jin4", map2.get(Integer.valueOf(4)));
/*     */       
/* 218 */       this.json.put("newDayProxyCount", newDayProxyCount);
/* 219 */       this.json.put("ProxyCount", ProxyCount);
/*     */       
/* 221 */       this.json.put("onlineCount", onlineCount);
/* 222 */       this.json.put("newDayUserCount", newDayUserCount);
/* 223 */       this.json.put("UserCount", UserCount);
/* 224 */       this.json.put("integralUser", integralUser);
/*     */       try {
/* 226 */         this.out = response.getWriter();
/* 227 */         this.out.print(this.json);
/* 228 */         this.out.flush();
/* 229 */         this.out.close();
/*     */       } catch (IOException e) {
/* 231 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void rechargeGold(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 243 */     int id = Integer.parseInt(request.getParameter("id"));
/* 244 */     Users users = (Users)this.dao.findById(Integer.valueOf(id));
/* 245 */     int uid = Integer.parseInt(request.getParameter("uid"));
/* 246 */     int type = Integer.parseInt(request.getParameter("type"));
/* 247 */     int money = Integer.parseInt(request.getParameter("money"));
/* 248 */     Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
/* 249 */     GameWebServerService wb = null;
/*     */     try {
/* 251 */       wb = new GameWebServerService(new URL(parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */     }
/*     */     catch (MalformedURLException e) {
/* 254 */       e.printStackTrace();
/*     */     }
/* 256 */     wb.getGameWebServerPort().addGold(Integer.valueOf(money), Integer.valueOf(uid), type);
/* 257 */     AdminRechargeLog arlog = new AdminRechargeLog();
/* 258 */     arlog.setAid(Integer.valueOf(id));
/* 259 */     arlog.setMoney(money + "");
/* 260 */     arlog.setRtype(Integer.valueOf(type));
/* 261 */     arlog.setUid(Integer.valueOf(uid));
/* 262 */     Timestamp d = new Timestamp(System.currentTimeMillis());
/* 263 */     arlog.setCreateTime(d);
/* 264 */     this.arldao.save(arlog);
/*     */     try {
/* 266 */       this.out = response.getWriter();
/* 267 */       this.out.print("ok");
/* 268 */       this.out.flush();
/* 269 */       this.out.close();
/*     */     } catch (IOException e) {
/* 271 */       e.printStackTrace();
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
/* 282 */     int id = Integer.parseInt(request.getParameter("id"));
/* 283 */     Users users = (Users)this.dao.findById(Integer.valueOf(id));
/* 284 */     short status = Short.parseShort(request.getParameter("status"));
/* 285 */     String[] names = { "status" };
/* 286 */     Object[] values = { Short.valueOf(status) };
/* 287 */     this.dao.partUpdate(id, names, values);
/*     */     
/* 289 */     String ipClients = Util.getIpAddress(request);
/* 290 */     HttpSession session = request.getSession();
/* 291 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 292 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 293 */       if (ipClients.equals(entry.getKey())) {
/* 294 */         Admin value = (Admin)entry.getValue();
/* 295 */         AdminopLog l = new AdminopLog();
/* 296 */         l.setAid(value.getId());
/* 297 */         l.setDescription("修改了ID为[" + users.getId() + "]的用户账号状态");
/* 298 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 299 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 303 */       this.out = response.getWriter();
/* 304 */       this.out.print("ok");
/* 305 */       this.out.flush();
/* 306 */       this.out.close();
/*     */     } catch (IOException e) {
/* 308 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void userslist(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 319 */     String type = request.getParameter("type");
/* 320 */     String show = request.getParameter("show");
/*     */     
/* 322 */     String comp = request.getParameter("comp");
/* 323 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/*     */ 
/* 326 */     Integer compRecharge = Integer.valueOf(0);
/*     */     
/*     */ 
/* 329 */     String[] splits = comp.split(",");
/* 330 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[0]));
/*     */     
/*     */ 
/* 333 */     compRecharge = Integer.valueOf(Integer.parseInt(splits[1]));
/*     */     
/*     */ 
/*     */ 
/* 337 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 338 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 339 */     PageModel<Users> pm = null;
/* 340 */     if ((type != null) && (!"".equals(type))) {
/* 341 */       request.setAttribute("type", type);
/* 342 */       if ("1".equals(type))
/*     */       {
/* 344 */         Date day = new Date();
/* 345 */         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 346 */         String date = df.format(day);
/* 347 */         String begin = date + " 0:0:0";
/* 348 */         String end = date + " 23:59:59";
/*     */         
/* 350 */         pm = this.dao.userList(currentPage, pageSize, " where createtime>='" + begin + "' and createtime<='" + end + "'");
/* 351 */       } else if ("2".equals(type))
/*     */       {
/* 353 */         pm = this.dao.userList(currentPage, pageSize, " where integral>0 ");
/*     */       }
/*     */     } else {
/* 356 */       String[] param = { "uid", "nickname", "status", "pid", "realName" };
/* 357 */       String[] paramValue = new String[param.length];
/* 358 */       for (i = 0; i < param.length; i++) {
/* 359 */         paramValue[i] = request.getParameter(param[i]);
/* 360 */         request.setAttribute(param[i], paramValue[i]);
/*     */       }
/* 362 */       pm = this.dao.sqlUsers(currentPage, pageSize, param, paramValue);
/*     */     }
/*     */     
/* 365 */     List<Users> list = pm.getList();
/* 366 */     if (list.isEmpty()) {
/* 367 */       this.flag = "1";
/* 368 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     
/*     */ 
/* 372 */     HashMap<Integer, String> map = new HashMap();
/* 373 */     for (int i = list.iterator(); i.hasNext();) { users = (Users)i.next();
/* 374 */       String time = this.dao.findByUidTime(users.getId());
/* 375 */       BigDecimal time1 = new BigDecimal(time);
/* 376 */       BigDecimal time2 = new BigDecimal(3600);
/* 377 */       BigDecimal time3 = time1.divide(time2, 2, 4);
/* 378 */       map.put(users.getId(), time3.toString());
/*     */     }
/*     */     Users users;
/* 381 */     HashMap<Integer, String> map2 = new HashMap();
/* 382 */     for (Users users : list) {
/* 383 */       String count = this.dao.findByLoginCount(users.getId());
/* 384 */       map2.put(users.getId(), count);
/*     */     }
/*     */     
/* 387 */     String trueUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from users where status=1");
/*     */     
/* 389 */     String warehouseIntegralUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(warehouseIntegral),0) from users where status=1");
/*     */     
/* 391 */     String trueProxyIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from proxy where status=1");
/*     */     
/* 393 */     String falseUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from users where status=0");
/*     */     
/* 395 */     String zuanshit = this.dao.findAllgoldtrue("select IFNULL(SUM(diamonds),0) from users where status=1");
/*     */     
/* 397 */     String zuanshif = this.dao.findAllgoldtrue("select IFNULL(SUM(diamonds),0) from users where status=0");
/*     */     
/* 399 */     String jinbit = this.dao.findAllgoldtrue("select IFNULL(SUM(gold),0) from users where status=1");
/*     */     
/* 401 */     String jinbif = this.dao.findAllgoldtrue("select IFNULL(SUM(gold),0) from users where status=0");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 427 */       request.setAttribute("comp", comp);
/* 428 */       request.setAttribute("compUpdate", compUpdate);
/*     */       
/*     */ 
/* 431 */       request.setAttribute("compRecharge", compRecharge);
/*     */       
/*     */ 
/* 434 */       request.setAttribute("trueUserIntegral", trueUserIntegral);
/* 435 */       request.setAttribute("warehouseIntegralUserIntegral", warehouseIntegralUserIntegral);
/* 436 */       request.setAttribute("trueProxyIntegral", trueProxyIntegral);
/* 437 */       request.setAttribute("falseUserIntegral", falseUserIntegral);
/* 438 */       request.setAttribute("zuanshit", zuanshit);
/* 439 */       request.setAttribute("zuanshif", zuanshif);
/* 440 */       request.setAttribute("jinbit", jinbit);
/* 441 */       request.setAttribute("jinbif", jinbif);
/* 442 */       request.setAttribute("map", map);
/* 443 */       request.setAttribute("map2", map2);
/*     */       
/* 445 */       request.setAttribute("pm", pm);
/* 446 */       request.setAttribute("show", show);
/* 447 */       request.getRequestDispatcher("web/usersList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 449 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\UsersServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */