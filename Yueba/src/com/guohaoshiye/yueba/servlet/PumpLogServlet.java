/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.ProxyDAO;
/*     */ import com.aiwan.dao.PumpLogDAO;
/*     */ import com.aiwan.dao.UsersDAO;
/*     */ import com.aiwan.entity.Proxy;
/*     */ import com.aiwan.entity.PumpLog;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ public class PumpLogServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  23 */   private PumpLogDAO dao = new PumpLogDAO();
/*  24 */   private UsersDAO udao = new UsersDAO();
/*  25 */   private ProxyDAO pdao = new ProxyDAO();
/*  26 */   private String flag = "";
/*  27 */   private JSONObject json = null;
/*  28 */   private PrintWriter out = null;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  32 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  37 */     response.setContentType("text/html;charset=utf-8");
/*  38 */     request.setCharacterEncoding("UTF-8");
/*  39 */     response.setCharacterEncoding("UTF-8");
/*  40 */     String op = request.getParameter("op");
/*  41 */     if ("pumpLogList".equals(op))
/*     */     {
/*  43 */       pumpLogList(request, response);
/*  44 */     } else if ("showServicefee".equals(op)) {
/*  45 */       showServicefee(request, response);
/*  46 */     } else if ("pumpLogList2".equals(op)) {
/*  47 */       pumpLogList2(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void pumpLogList2(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     String comp = request.getParameter("comp");
/*  59 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/*  60 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*  61 */     String[] param = { "uid", "tableid", "tabletype", "gamechang" };
/*  62 */     String[] paramValue = new String[param.length];
/*  63 */     for (int i = 0; i < param.length; i++) {
/*  64 */       paramValue[i] = request.getParameter(param[i]);
/*  65 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/*     */     
/*     */ 
/*  69 */     PageModel<PumpLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/*  70 */     List<PumpLog> list = pm.getList();
/*  71 */     if (list.isEmpty()) {
/*  72 */       this.flag = "1";
/*  73 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     
/*  76 */     String sumAllpump = this.dao.findSqlSum("select cast(IFNULL(SUM(allpump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
/*  77 */     String sumPingtaipump = this.dao.findSqlSum("select cast(IFNULL(SUM(pingtaipump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
/*  78 */     String sumOneproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
/*  79 */     String sumTwoproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
/*  80 */     String sumThreeproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
/*     */     
/*     */ 
/*  83 */     List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
/*     */     
/*  85 */     request.setAttribute("plist", plist);
/*  86 */     request.setAttribute("comp", comp);
/*     */     
/*  88 */     request.setAttribute("sumAllpump", sumAllpump);
/*  89 */     request.setAttribute("sumPingtaipump", sumPingtaipump);
/*  90 */     request.setAttribute("sumOneproxypump", sumOneproxypump);
/*  91 */     request.setAttribute("sumTwoproxypump", sumTwoproxypump);
/*  92 */     request.setAttribute("sumThreeproxypump", sumThreeproxypump);
/*     */     
/*  94 */     request.setAttribute("pm", pm);
/*     */     try {
/*  96 */       request.getRequestDispatcher("web/pump_log2.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/*  99 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 101 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void showServicefee(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 113 */     int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
/* 114 */     String haomiao = request.getParameter("haomiao");
/* 115 */     List<PumpLog> list = this.dao.findByHQL("from PumpLog where tableid=? and haomiao=?", new Object[] { Integer.valueOf(roomNumber), haomiao });
/* 116 */     if (list.isEmpty()) {
/* 117 */       this.flag = "1";
/* 118 */       request.setAttribute("flag", this.flag);
/*     */     }
/* 120 */     List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
/* 121 */     request.setAttribute("plist", plist);
/* 122 */     request.setAttribute("list", list);
/*     */     try {
/* 124 */       request.getRequestDispatcher("web/update/pumpInfo_log.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 127 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 129 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void pumpLogList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 135 */     String comp = request.getParameter("comp");
/* 136 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 137 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*     */     
/* 139 */     String[] param = { "uid", "tableid", "tabletype", "gamechang" };
/* 140 */     String[] paramValue = new String[param.length];
/* 141 */     for (int i = 0; i < param.length; i++) {
/* 142 */       paramValue[i] = request.getParameter(param[i]);
/* 143 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/*     */     
/* 146 */     PageModel<PumpLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 147 */     List<PumpLog> list = pm.getList();
/* 148 */     if (list.isEmpty()) {
/* 149 */       this.flag = "1";
/* 150 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     
/* 153 */     String sumAllpump = this.dao.findSqlSum("select cast(IFNULL(SUM(allpump),0) as decimal(18,2)) from pump_log where tabletype!=10");
/* 154 */     String sumPingtaipump = this.dao.findSqlSum("select cast(IFNULL(SUM(pingtaipump),0) as decimal(18,2)) from pump_log where tabletype!=10");
/* 155 */     String sumOneproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");
/* 156 */     String sumTwoproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");
/* 157 */     String sumThreeproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");
/*     */     
/*     */ 
/* 160 */     List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
/*     */     
/* 162 */     request.setAttribute("plist", plist);
/* 163 */     request.setAttribute("comp", comp);
/*     */     
/* 165 */     request.setAttribute("sumAllpump", sumAllpump);
/* 166 */     request.setAttribute("sumPingtaipump", sumPingtaipump);
/* 167 */     request.setAttribute("sumOneproxypump", sumOneproxypump);
/* 168 */     request.setAttribute("sumTwoproxypump", sumTwoproxypump);
/* 169 */     request.setAttribute("sumThreeproxypump", sumThreeproxypump);
/*     */     
/* 171 */     request.setAttribute("pm", pm);
/*     */     try {
/* 173 */       request.getRequestDispatcher("web/pump_log.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 176 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 178 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\PumpLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */