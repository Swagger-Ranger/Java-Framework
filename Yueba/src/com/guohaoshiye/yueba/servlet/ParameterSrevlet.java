/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.ParameterDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Parameter;
/*     */ import com.aiwan.util.Util;
/*     */ import com.game.server.web.GameWebServer;
/*     */ import com.game.server.web.GameWebServerService;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.sql.Timestamp;
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
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ public class ParameterSrevlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  32 */   private ParameterDAO dao = new ParameterDAO();
/*  33 */   private String flag = "";
/*  34 */   private JSONObject json = null;
/*  35 */   private PrintWriter out = null;
/*  36 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  40 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  45 */     response.setContentType("text/html;charset=utf-8");
/*  46 */     request.setCharacterEncoding("UTF-8");
/*  47 */     response.setCharacterEncoding("UTF-8");
/*  48 */     String op = request.getParameter("op");
/*  49 */     if ("parameterList".equals(op)) {
/*  50 */       parameterList(request, response);
/*  51 */     } else if ("updateParameter".equals(op)) {
/*  52 */       updateParameter(request, response);
/*  53 */     } else if ("selectSysPwd".equals(op)) {
/*  54 */       selectSysPwd(request, response);
/*  55 */     } else if ("updateSysPwd".equals(op)) {
/*  56 */       updateSysPwd(request, response);
/*  57 */     } else if ("closeServer".equals(op)) {
/*  58 */       closeServer(request, response);
/*     */     }
/*  60 */     else if ("cleanupRoom".equals(op)) {
/*  61 */       cleanupRoom(request, response);
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
/*     */   private void cleanupRoom(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  74 */     String flg = "";
/*  75 */     int rid = Integer.parseInt(request.getParameter("rid"));
/*  76 */     Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
/*  77 */     GameWebServerService wb = null;
/*     */     try {
/*  79 */       URL url = new URL(p.getValue());
/*  80 */       wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */       
/*  82 */       boolean b = wb.getGameWebServerPort().closeRoom(rid);
/*  83 */       if (b) {
/*  84 */         flg = "ok";
/*     */       } else {
/*  86 */         flg = "on";
/*     */       }
/*     */     } catch (MalformedURLException e1) {
/*  89 */       flg = "on";
/*  90 */       e1.printStackTrace();
/*     */     }
/*     */     try {
/*  93 */       this.out = response.getWriter();
/*  94 */       this.out.print(flg);
/*  95 */       this.out.flush();
/*  96 */       this.out.close();
/*     */     } catch (IOException e) {
/*  98 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void closeServer(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 109 */     Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
/* 110 */     GameWebServerService wb = null;
/*     */     try {
/* 112 */       URL url = new URL(p.getValue());
/* 113 */       wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */       
/* 115 */       wb.getGameWebServerPort().closeServer();
/*     */     } catch (MalformedURLException e1) {
/* 117 */       e1.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateSysPwd(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 127 */     int id = Integer.parseInt(request.getParameter("id"));
/* 128 */     String pwd = request.getParameter("pwd");
/* 129 */     String[] names = { "value" };
/* 130 */     Object[] values = { Util.Md5(pwd) };
/* 131 */     this.dao.partUpdate(id, names, values);
/*     */     try {
/* 133 */       this.out = response.getWriter();
/* 134 */       this.out.print("ok");
/* 135 */       this.out.flush();
/* 136 */       this.out.close();
/*     */     } catch (IOException e) {
/* 138 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void selectSysPwd(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 148 */     String msg = "on";
/* 149 */     String pwd = request.getParameter("pwd");
/* 150 */     List<Parameter> list = this.dao.findByHQL("from Parameter where name=? and value=?", new Object[] { "BackstagePwd", Util.Md5(pwd) });
/* 151 */     if (list.size() > 0) {
/* 152 */       msg = "ok";
/*     */     }
/*     */     try {
/* 155 */       this.out = response.getWriter();
/* 156 */       this.out.print(msg);
/* 157 */       this.out.flush();
/* 158 */       this.out.close();
/*     */     } catch (IOException e) {
/* 160 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateParameter(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 171 */     int id = Integer.parseInt(request.getParameter("id"));
/* 172 */     Parameter parameter2 = (Parameter)this.dao.findById(Integer.valueOf(id));
/* 173 */     String value = request.getParameter("value");
/* 174 */     String[] names = { "value" };
/* 175 */     Object[] values = { value };
/* 176 */     this.dao.partUpdate(id, names, values);
/*     */     
/* 178 */     String ipClients = Util.getIpAddress(request);
/* 179 */     HttpSession session = request.getSession();
/* 180 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 181 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 182 */       if (ipClients.equals(entry.getKey())) {
/* 183 */         Admin value2 = (Admin)entry.getValue();
/* 184 */         AdminopLog l = new AdminopLog();
/* 185 */         l.setAid(value2.getId());
/* 186 */         l.setDescription("对参数【" + parameter2.getExplain() + "】进行了修改。");
/* 187 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 188 */         this.apdao.save(l);
/*     */       }
/*     */     }
/* 191 */     Parameter parameter = (Parameter)this.dao.findById(Integer.valueOf(id));
/* 192 */     if ("rollingbulletin".equals(parameter.getName())) {
/* 193 */       Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
/* 194 */       GameWebServerService wb = null;
/*     */       try {
/* 196 */         wb = new GameWebServerService(new URL(p.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
/*     */       }
/*     */       catch (MalformedURLException e) {
/* 199 */         e.printStackTrace();
/*     */       }
/* 201 */       wb.getGameWebServerPort().updateParameter("rollingbulletin", value);
/*     */     }
/*     */     try {
/* 204 */       this.out = response.getWriter();
/* 205 */       this.out.print("ok");
/* 206 */       this.out.flush();
/* 207 */       this.out.close();
/*     */     } catch (IOException e) {
/* 209 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void parameterList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 219 */     String url = "";
/* 220 */     String comp = request.getParameter("comp");
/* 221 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/* 223 */     String[] splits = comp.split(",");
/* 224 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[0]));
/*     */     
/*     */ 
/* 227 */     int type = Integer.parseInt(request.getParameter("type"));
/* 228 */     List<Parameter> list = this.dao.findByHQL("from Parameter where type=?", new Object[] { Integer.valueOf(type) });
/* 229 */     if (type == 1) {
/* 230 */       url = "web/parameterList1.jsp";
/*     */     }
/* 232 */     if (type == 2) {
/* 233 */       url = "web/parameterList2.jsp";
/*     */     }
/* 235 */     if (type == 3) {
/* 236 */       url = "web/parameterList3.jsp";
/*     */     }
/* 238 */     if (type == 4) {
/* 239 */       url = "web/parameterList4.jsp";
/*     */     }
/* 241 */     if (type == 5) {
/* 242 */       url = "web/parameterList5.jsp";
/*     */     }
/* 244 */     if (type == 6) {
/* 245 */       url = "web/parameterList6.jsp";
/*     */     }
/*     */     try {
/* 248 */       request.setAttribute("list", list);
/* 249 */       request.setAttribute("compUpdate", compUpdate);
/* 250 */       request.getRequestDispatcher(url).forward(request, response);
/*     */     } catch (Exception e) {
/* 252 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\ParameterSrevlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */