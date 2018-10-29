/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.ParameterDAO;
/*     */ import com.aiwan.dao.ProxyDAO;
/*     */ import com.aiwan.dao.PumpLogDAO;
/*     */ import com.aiwan.dao.TixianLogDAO;
/*     */ import com.aiwan.dao.UsersDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Parameter;
/*     */ import com.aiwan.entity.Proxy;
/*     */ import com.aiwan.entity.Proxy_num;
/*     */ import com.aiwan.entity.Users;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import com.aiwan.util.Util;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import net.sf.json.JSONArray;
/*     */ import net.sf.json.JSONObject;
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
/*     */ public class ProxyServlet
/*     */   extends HttpServlet
/*     */ {
/*  49 */   private PumpLogDAO pdao = new PumpLogDAO();
/*  50 */   private ParameterDAO ptdao = new ParameterDAO();
/*  51 */   private UsersDAO udao = new UsersDAO();
/*  52 */   private ProxyDAO dao = new ProxyDAO();
/*  53 */   private TixianLogDAO tdao = new TixianLogDAO();
/*  54 */   private String flag = "";
/*  55 */   private JSONObject json = null;
/*  56 */   private PrintWriter out = null;
/*  57 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  63 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  68 */     response.setContentType("text/html;charset=utf-8");
/*  69 */     request.setCharacterEncoding("UTF-8");
/*  70 */     response.setCharacterEncoding("UTF-8");
/*  71 */     String op = request.getParameter("op");
/*  72 */     if ("listProxy".equals(op)) {
/*  73 */       listProxy(request, response);
/*  74 */     } else if ("updateChouShui".equals(op)) {
/*  75 */       updateChouShui(request, response);
/*  76 */     } else if ("findAllAgents".equals(op)) {
/*  77 */       findAllAgents(request, response);
/*  78 */     } else if ("findAllUser".equals(op)) {
/*  79 */       findAllUser(request, response);
/*  80 */     } else if ("updateProxy".equals(op)) {
/*  81 */       updateProxy(request, response);
/*  82 */     } else if ("updateRight".equals(op)) {
/*  83 */       updateRight(request, response);
/*  84 */     } else if ("showByIdInfo".equals(op)) {
/*  85 */       showByIdInfo(request, response);
/*  86 */     } else if ("saveNumSession".equals(op)) {
/*  87 */       saveNumSession(request, response);
/*  88 */     } else if ("selectNum".equals(op)) {
/*  89 */       selectNum(request, response);
/*  90 */     } else if ("update2Proxy".equals(op)) {
/*  91 */       update2Proxy(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */   private void update2Proxy(HttpServletRequest request, HttpServletResponse response) {
/*  96 */     String str = "";
/*  97 */     Integer icon = null;
/*  98 */     this.json = new JSONObject();
/*  99 */     int id = Integer.parseInt(request.getParameter("id"));
/* 100 */     Integer isDisable = Integer.valueOf(Integer.parseInt(request.getParameter("isDisable")));
/* 101 */     Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
/* 102 */     proxy.setIsDisable(isDisable);
/* 103 */     if (isDisable.intValue() == 0) {
/* 104 */       proxy.setPid(Integer.valueOf(0));
/* 105 */       this.dao.upadtePid(id);
/* 106 */       this.udao.updatePid(id);
/*     */     }
/* 108 */     this.dao.update(proxy);
/* 109 */     String ipClients = Util.getIpAddress(request);
/* 110 */     HttpSession session = request.getSession();
/* 111 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 112 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 113 */       if (ipClients.equals(entry.getKey())) {
/* 114 */         Admin value = (Admin)entry.getValue();
/* 115 */         AdminopLog l = new AdminopLog();
/* 116 */         l.setAid(value.getId());
/* 117 */         l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【账号状态】");
/* 118 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 119 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 123 */       this.out = response.getWriter();
/* 124 */       this.out.print("ok");
/* 125 */       this.out.flush();
/* 126 */       this.out.close();
/*     */     } catch (IOException e) {
/* 128 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void selectNum(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 135 */     Proxy_num proxy_num = this.dao.selectNum();
/* 136 */     JSONObject json = JSONObject.fromObject(proxy_num);
/*     */     try {
/* 138 */       this.out = response.getWriter();
/* 139 */       this.out.print(json.toString());
/* 140 */       this.out.flush();
/* 141 */       this.out.close();
/*     */     } catch (IOException e) {
/* 143 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveNumSession(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 149 */     String str = "error";
/*     */     try {
/* 151 */       int pNumber1 = Integer.parseInt(request.getParameter("number1"));
/* 152 */       int pNumber2 = Integer.parseInt(request.getParameter("number2"));
/* 153 */       int pNumber3 = Integer.parseInt(request.getParameter("number3"));
/* 154 */       this.dao.UpdateNum(pNumber1, pNumber2, pNumber3);
/* 155 */       str = "ok";
/*     */     } catch (Exception e) {
/* 157 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 160 */       this.out = response.getWriter();
/* 161 */       this.out.print(str);
/* 162 */       this.out.flush();
/* 163 */       this.out.close();
/*     */     } catch (IOException e) {
/* 165 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void showByIdInfo(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 172 */     this.json = new JSONObject();
/* 173 */     String flg = "0";
/* 174 */     int pid = Integer.parseInt(request.getParameter("pid"));
/* 175 */     Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(pid));
/* 176 */     if (proxy.getPid().intValue() != 0) {
/* 177 */       flg = "1";
/* 178 */       Proxy proxy2 = (Proxy)this.dao.findById(proxy.getPid());
/* 179 */       JSONObject json2 = JSONObject.fromObject(proxy2);
/* 180 */       this.json.put("proxy", json2);
/*     */     }
/* 182 */     this.json.put("flg", flg);
/*     */     try {
/* 184 */       this.out = response.getWriter();
/* 185 */       this.out.print(this.json);
/* 186 */       this.out.flush();
/* 187 */       this.out.close();
/*     */     } catch (IOException e) {
/* 189 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateRight(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 200 */     this.json = new JSONObject();
/* 201 */     int id = Integer.parseInt(request.getParameter("id"));
/* 202 */     Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
/* 203 */     Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
/* 204 */     proxy.setRight(status);
/* 205 */     this.dao.update(proxy);
/* 206 */     String ipClients = Util.getIpAddress(request);
/* 207 */     HttpSession session = request.getSession();
/* 208 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 209 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 210 */       if (ipClients.equals(entry.getKey())) {
/* 211 */         Admin value = (Admin)entry.getValue();
/* 212 */         AdminopLog l = new AdminopLog();
/* 213 */         l.setAid(value.getId());
/* 214 */         l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【代理后台权限】");
/* 215 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 216 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 220 */       this.out = response.getWriter();
/* 221 */       this.out.print("ok");
/* 222 */       this.out.flush();
/* 223 */       this.out.close();
/*     */     } catch (IOException e) {
/* 225 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateProxy(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 236 */     String str = "";
/* 237 */     Integer icon = null;
/* 238 */     this.json = new JSONObject();
/* 239 */     int id = Integer.parseInt(request.getParameter("id"));
/* 240 */     Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
/* 241 */     Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
/* 242 */     proxy.setStatus(status);
/* 243 */     if (status.intValue() == 0) {
/* 244 */       this.dao.partUpdateProxy(proxy.getPid(), id);
/* 245 */       proxy.setPid(Integer.valueOf(0));
/* 246 */       this.dao.upadtePid(id);
/* 247 */       this.udao.updatePid(id);
/*     */     }
/* 249 */     this.dao.update(proxy);
/* 250 */     String ipClients = Util.getIpAddress(request);
/* 251 */     HttpSession session = request.getSession();
/* 252 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 253 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 254 */       if (ipClients.equals(entry.getKey())) {
/* 255 */         Admin value = (Admin)entry.getValue();
/* 256 */         AdminopLog l = new AdminopLog();
/* 257 */         l.setAid(value.getId());
/* 258 */         l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【账号状态】");
/* 259 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 260 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 264 */       this.out = response.getWriter();
/* 265 */       this.out.print("ok");
/* 266 */       this.out.flush();
/* 267 */       this.out.close();
/*     */     } catch (IOException e) {
/* 269 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findAllUser(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 280 */     int pid = Integer.parseInt(request.getParameter("pid"));
/* 281 */     List<Proxy> plist = this.dao.sqlHeProxy(pid);
/* 282 */     StringBuffer sb = new StringBuffer();
/* 283 */     sb.append("[");
/* 284 */     for (Proxy proxy : plist) {
/* 285 */       List<Users> ulist = this.dao.sqlHeUser(proxy.getId());
/* 286 */       sb.append("{");
/* 287 */       sb.append("\"code\":\"" + proxy.getId() + "\",");
/* 288 */       sb.append("\"name\":\"推广员:" + proxy.getNickname() + "&nbsp;&nbsp;ID:" + proxy.getId() + "\",");
/* 289 */       sb.append("\"icon\":\"icon-th\",");
/* 290 */       sb.append("\"child\":[");
/* 291 */       if (!ulist.isEmpty()) {
/* 292 */         for (Users users : ulist) {
/* 293 */           sb.append("{");
/* 294 */           sb.append("\"code\":\"" + users.getId() + "\",");
/* 295 */           sb.append("\"parentCode\":\"" + users.getPid() + "\",");
/* 296 */           sb.append("\"icon\":\"\",");
/* 297 */           sb.append("\"name\":\"会员:" + users.getNickname() + "&nbsp;&nbsp;ID:" + users.getId() + "\",");
/* 298 */           sb.append("\"child\":[]");
/* 299 */           sb.append("},");
/*     */         }
/* 301 */         sb = new StringBuffer(sb.substring(0, sb.length() - 1));
/*     */       }
/* 303 */       sb.append("]");
/* 304 */       sb.append("},");
/*     */     }
/* 306 */     String sb2 = new String(sb);
/* 307 */     sb2 = sb2.substring(0, sb2.length() - 1);
/* 308 */     sb2 = sb2 + "]";
/*     */     try {
/* 310 */       this.out = response.getWriter();
/* 311 */       this.out.print(sb2);
/* 312 */       this.out.flush();
/* 313 */       this.out.close();
/*     */     } catch (IOException e) {
/* 315 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findAllAgents(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 326 */     this.json = new JSONObject();
/* 327 */     int pid = Integer.parseInt(request.getParameter("pid"));
/* 328 */     List<Proxy> plist = this.dao.sqlHeProxy(pid);
/* 329 */     for (Proxy proxy : plist) {
/* 330 */       List<Users> ulist = this.dao.sqlHeUser(proxy.getId());
/* 331 */       proxy.setUsers(ulist);
/*     */     }
/* 333 */     JSONArray json2 = JSONArray.fromObject(plist);
/* 334 */     Parameter parameter = (Parameter)this.ptdao.findByHQL("from Parameter where name='pingntaipump'", null).get(0);
/* 335 */     int int1 = Integer.parseInt(parameter.getValue());
/* 336 */     int i = 100 - int1;
/* 337 */     double s = i * 0.01D;
/* 338 */     String totalRevenue = this.pdao.findSqlSum("select cast(IFNULL(SUM(allpump),0)*" + s + " as decimal(18,2)) FROM pump_log where uid in (select id from users where pid in (select id from proxy where FIND_IN_SET(id, getChildLstProxy(" + pid + "))))");
/* 339 */     this.json.put("jsonArray", json2);
/* 340 */     this.json.put("totalRevenue", totalRevenue);
/*     */     try {
/* 342 */       this.out = response.getWriter();
/* 343 */       this.out.print(this.json);
/* 344 */       this.out.flush();
/* 345 */       this.out.close();
/*     */     } catch (IOException e) {
/* 347 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateChouShui(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 359 */     String str = "";
/*     */     try {
/* 361 */       int id = Integer.parseInt(request.getParameter("id"));
/* 362 */       int yiji = Integer.parseInt(request.getParameter("yiji"));
/* 363 */       int erji = Integer.parseInt(request.getParameter("erji"));
/* 364 */       int sanji = Integer.parseInt(request.getParameter("sanji"));
/* 365 */       proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
/* 366 */       proxy.setYiji(Integer.valueOf(yiji));
/* 367 */       proxy.setErji(Integer.valueOf(erji));
/* 368 */       proxy.setSanji(Integer.valueOf(sanji));
/* 369 */       this.dao.update(proxy);
/* 370 */       str = "ok";
/* 371 */       ipClients = Util.getIpAddress(request);
/* 372 */       HttpSession session = request.getSession();
/* 373 */       Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 374 */       for (Map.Entry<String, Admin> entry : mapAdmin.entrySet())
/* 375 */         if (ipClients.equals(entry.getKey())) {
/* 376 */           Admin value = (Admin)entry.getValue();
/* 377 */           AdminopLog l = new AdminopLog();
/* 378 */           l.setAid(value.getId());
/* 379 */           l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【奖励比例】");
/* 380 */           l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 381 */           this.apdao.save(l);
/*     */         }
/*     */     } catch (Exception e) { Proxy proxy;
/*     */       String ipClients;
/* 385 */       str = "on";
/*     */     }
/*     */     try {
/* 388 */       this.out = response.getWriter();
/* 389 */       this.out.print(str);
/* 390 */       this.out.flush();
/* 391 */       this.out.close();
/*     */     } catch (IOException e) {
/* 393 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void listProxy(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 400 */     String comp = request.getParameter("comp");
/* 401 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 402 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 403 */     String type = request.getParameter("type");
/*     */     
/* 405 */     Integer proxyOp1 = Integer.valueOf(0);
/* 406 */     Integer proxyOp2 = Integer.valueOf(0);
/* 407 */     Integer proxyOp3 = Integer.valueOf(0);
/*     */     
/* 409 */     String[] splits = comp.split(",");
/*     */     
/* 411 */     proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));
/* 412 */     proxyOp2 = Integer.valueOf(Integer.parseInt(splits[1]));
/* 413 */     proxyOp3 = Integer.valueOf(Integer.parseInt(splits[2]));
/*     */     
/*     */ 
/* 416 */     String[] param = { "nickname", "status", "pid", "kg", "ppid", "phone", "trueName", "contactWay", "isDisable" };
/* 417 */     String[] paramValue = new String[param.length];
/* 418 */     for (int i = 0; i < param.length; i++) {
/* 419 */       paramValue[i] = request.getParameter(param[i]);
/* 420 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/* 422 */     PageModel<Proxy> pm = this.dao.sqlProxy(currentPage, pageSize, param, paramValue);
/* 423 */     List<Proxy> list = pm.getList();
/* 424 */     if (list.isEmpty()) {
/* 425 */       this.flag = "1";
/* 426 */       request.setAttribute("flag", this.flag);
/*     */     } else {
/* 428 */       HashMap<Integer, String> map = new HashMap();
/* 429 */       HashMap<Integer, String> map2 = new HashMap();
/* 430 */       HashMap<Integer, String> map3 = new HashMap();
/* 431 */       for (Proxy proxy : list) {
/* 432 */         double f = proxy.getIntegral().doubleValue();
/* 433 */         DecimalFormat df = new DecimalFormat("###############0.##");
/* 434 */         String s = df.format(f);
/* 435 */         BigDecimal sum = new BigDecimal(0);
/* 436 */         String yijisum = this.pdao.showYingli("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) FROM pump_log where oneproxyid=?", proxy.getId());
/* 437 */         String yerjisum = this.pdao.showYingli("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) FROM pump_log where twoproxyid=?", proxy.getId());
/* 438 */         String sanjisum = this.pdao.showYingli("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) FROM pump_log where threeproxyid=?", proxy.getId());
/* 439 */         sum = sum.add(new BigDecimal(yijisum));
/* 440 */         sum = sum.add(new BigDecimal(yerjisum));
/* 441 */         sum = sum.add(new BigDecimal(sanjisum));
/* 442 */         String txsum = this.tdao.showTiXianSum("select IFNULL(SUM(Ingots),0) from tixian_log where `status` =0 and pid =?", proxy.getId());
/* 443 */         map.put(proxy.getId(), sum.toString());
/* 444 */         map2.put(proxy.getId(), s);
/* 445 */         map3.put(proxy.getId(), txsum);
/*     */       }
/* 447 */       request.setAttribute("map", map);
/* 448 */       request.setAttribute("map2", map2);
/* 449 */       request.setAttribute("map3", map3);
/*     */     }
/* 451 */     request.setAttribute("pm", pm);
/* 452 */     request.setAttribute("proxyOp1", proxyOp1);
/* 453 */     request.setAttribute("proxyOp2", proxyOp2);
/* 454 */     request.setAttribute("proxyOp3", proxyOp3);
/* 455 */     request.setAttribute("comp", comp);
/* 456 */     request.setAttribute("type", type);
/*     */     try {
/* 458 */       request.getRequestDispatcher("web/prxoyList.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 461 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 463 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\ProxyServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */