/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminDAO;
/*     */ import com.aiwan.dao.ProxyDAO;
/*     */ import com.aiwan.dao.TixianLogDAO;
/*     */ import com.aiwan.entity.Proxy;
/*     */ import com.aiwan.entity.TixianLog;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TixianLogServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  31 */   private TixianLogDAO dao = new TixianLogDAO();
/*  32 */   private ProxyDAO pdao = new ProxyDAO();
/*  33 */   private AdminDAO adao = new AdminDAO();
/*  34 */   private String flag = "";
/*  35 */   private JSONObject json = null;
/*  36 */   private PrintWriter out = null;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  39 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  44 */     response.setContentType("text/html;charset=utf-8");
/*  45 */     request.setCharacterEncoding("UTF-8");
/*  46 */     response.setCharacterEncoding("UTF-8");
/*  47 */     String op = request.getParameter("op");
/*  48 */     if ("tiXianAuditList".equals(op)) {
/*  49 */       tiXianAuditList(request, response);
/*  50 */     } else if ("adminAuditTiXian".equals(op)) {
/*  51 */       adminAuditTiXian(request, response);
/*  52 */     } else if ("tiXianLogList".equals(op)) {
/*  53 */       tiXianLogList(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tiXianLogList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  65 */     String comp = request.getParameter("comp");
/*  66 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/*  67 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*  68 */     String[] param = { "pid", "aid", "status", "begin", "end" };
/*  69 */     String[] paramValue = new String[param.length];
/*  70 */     for (int i = 0; i < param.length; i++) {
/*  71 */       paramValue[i] = request.getParameter(param[i]);
/*  72 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/*  74 */     PageModel<TixianLog> pm = this.dao.sqlLoglist(currentPage, pageSize, param, paramValue);
/*  75 */     List<TixianLog> list = pm.getList();
/*  76 */     if (list.isEmpty()) {
/*  77 */       this.flag = "1";
/*  78 */       request.setAttribute("flag", this.flag);
/*     */     }
/*  80 */     String sum1 = this.dao.findSqlSum("select cast(IFNULL(SUM(cash),0) as decimal(18,2)) from tixian_log");
/*  81 */     String sum2 = this.dao.findSqlSum("select cast(IFNULL(SUM(tax),0) as decimal(18,2)) from tixian_log");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     request.setAttribute("comp", comp);
/*  87 */     request.setAttribute("pm", pm);
/*  88 */     request.setAttribute("sum1", sum1);
/*  89 */     request.setAttribute("sum2", sum2);
/*     */     try {
/*  91 */       request.getRequestDispatcher("web/proxytixian_log.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/*  94 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  96 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void adminAuditTiXian(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 107 */     this.json = new JSONObject();
/* 108 */     int id = Integer.parseInt(request.getParameter("id"));
/* 109 */     int tid = Integer.parseInt(request.getParameter("tid"));
/* 110 */     int type = Integer.parseInt(request.getParameter("type"));
/* 111 */     TixianLog log = (TixianLog)this.dao.findById(Integer.valueOf(tid));
/* 112 */     log.setAuditPeople(Integer.valueOf(id));
/* 113 */     if (type == 1) {
/* 114 */       log.setStatus(Integer.valueOf(0));
/* 115 */     } else if (type == 2) {
/* 116 */       String text = request.getParameter("text");
/* 117 */       log.setStatus(Integer.valueOf(1));
/* 118 */       log.setDenyReason(text);
/*     */     }
/* 120 */     Timestamp d = new Timestamp(System.currentTimeMillis());
/* 121 */     log.setAuditTime(d);
/* 122 */     this.dao.update(log);
/* 123 */     if (type == 2) {
/* 124 */       String ingots = log.getIngots();
/* 125 */       Proxy proxy = (Proxy)this.pdao.findById(log.getPid());
/* 126 */       Double gold = proxy.getIntegral();
/* 127 */       BigDecimal b1 = new BigDecimal(gold.doubleValue());
/* 128 */       BigDecimal b2 = new BigDecimal(ingots);
/* 129 */       BigDecimal b3 = b1.add(b2);
/* 130 */       proxy.setIntegral(Double.valueOf(b3.doubleValue()));
/* 131 */       this.pdao.update(proxy);
/*     */     }
/* 133 */     this.json.put("str", "ok");
/*     */     try {
/* 135 */       this.out = response.getWriter();
/* 136 */       this.out.print(this.json);
/* 137 */       this.out.flush();
/* 138 */       this.out.close();
/*     */     } catch (IOException e) {
/* 140 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tiXianAuditList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 151 */     String comp = request.getParameter("comp");
/* 152 */     Integer proxyOp1 = Integer.valueOf(0);
/*     */     
/* 154 */     String[] splits = comp.split(",");
/*     */     
/* 156 */     proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));
/* 157 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 158 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 159 */     String[] param = { "pid", "begin", "end", "content", "txhz" };
/* 160 */     String[] paramValue = new String[param.length];
/* 161 */     for (int i = 0; i < param.length; i++) {
/* 162 */       paramValue[i] = request.getParameter(param[i]);
/* 163 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/* 165 */     PageModel<TixianLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 166 */     List<TixianLog> list = pm.getList();
/* 167 */     if (list.isEmpty()) {
/* 168 */       this.flag = "1";
/* 169 */       request.setAttribute("flag", this.flag);
/*     */     }
/* 171 */     List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
/* 172 */     request.setAttribute("plist", plist);
/* 173 */     request.setAttribute("comp", comp);
/* 174 */     request.setAttribute("proxyOp1", proxyOp1);
/* 175 */     request.setAttribute("pm", pm);
/*     */     try {
/* 177 */       request.getRequestDispatcher("web/proxytixian_check.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 180 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 182 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\TixianLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */