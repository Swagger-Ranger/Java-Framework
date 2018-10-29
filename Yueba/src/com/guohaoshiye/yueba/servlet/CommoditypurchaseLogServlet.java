/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.CommoditypurchaseLogDAO;
/*    */ import com.aiwan.entity.CommoditypurchaseLog;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommoditypurchaseLogServlet
/*    */   extends HttpServlet
/*    */ {
/* 20 */   private CommoditypurchaseLogDAO dao = new CommoditypurchaseLogDAO();
/* 21 */   private String flag = "";
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 26 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 31 */     response.setContentType("text/html;charset=utf-8");
/* 32 */     request.setCharacterEncoding("UTF-8");
/* 33 */     response.setCharacterEncoding("UTF-8");
/* 34 */     String op = request.getParameter("op");
/* 35 */     if ("commoditypurchaseLog".equals(op)) {
/* 36 */       commoditypurchaseLog(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void commoditypurchaseLog(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     String comp = request.getParameter("comp");
/* 49 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 50 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 51 */     String[] param = { "CommodityName", "PurchaseUserid", "begin", "end" };
/* 52 */     String[] paramValue = new String[param.length];
/* 53 */     for (int i = 0; i < param.length; i++) {
/* 54 */       paramValue[i] = request.getParameter(param[i]);
/* 55 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 57 */     PageModel<CommoditypurchaseLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/*    */     
/*    */ 
/* 60 */     String sum = this.dao.findSqlSum("select IFNULL(SUM(commodityTotalPrice),0) from commoditypurchase_log");
/*    */     
/* 62 */     String xhsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='flower'");
/*    */     
/* 64 */     String pcsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='sportcar'");
/*    */     
/* 66 */     String jdsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='egg'");
/*    */     
/* 68 */     String czsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='hammer'");
/*    */     
/* 70 */     String lbsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='horn'");
/* 71 */     List<CommoditypurchaseLog> list = pm.getList();
/* 72 */     if (list.isEmpty()) {
/* 73 */       this.flag = "1";
/* 74 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 76 */     request.setAttribute("comp", comp);
/* 77 */     request.setAttribute("pm", pm);
/*    */     
/* 79 */     request.setAttribute("sum", sum);
/* 80 */     request.setAttribute("xhsum", xhsum);
/* 81 */     request.setAttribute("pcsum", pcsum);
/* 82 */     request.setAttribute("jdsum", jdsum);
/* 83 */     request.setAttribute("czsum", czsum);
/* 84 */     request.setAttribute("lbsum", lbsum);
/*    */     try {
/* 86 */       request.getRequestDispatcher("web/commoditypurchase_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 89 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 91 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\CommoditypurchaseLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */