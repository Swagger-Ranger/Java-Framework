/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.RechargeDAO;
/*    */ import com.aiwan.dao.UsersDAO;
/*    */ import com.aiwan.entity.Recharge;
/*    */ import com.aiwan.entity.Users;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class RechargeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 21 */   private RechargeDAO dao = new RechargeDAO();
/* 22 */   private UsersDAO udao = new UsersDAO();
/* 23 */   private String flag = "";
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 26 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 31 */     response.setContentType("text/html;charset=utf-8");
/* 32 */     request.setCharacterEncoding("UTF-8");
/* 33 */     response.setCharacterEncoding("UTF-8");
/* 34 */     String op = request.getParameter("op");
/* 35 */     if ("rechargeList".equals(op)) {
/* 36 */       rechargeList(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void rechargeList(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 48 */     String comp = request.getParameter("comp");
/* 49 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 50 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 51 */     String[] param = { "status", "userId", "begin", "end", "order", "gold" };
/* 52 */     String[] paramValue = new String[param.length];
/* 53 */     for (int i = 0; i < param.length; i++) {
/* 54 */       paramValue[i] = request.getParameter(param[i]);
/* 55 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 57 */     PageModel<Recharge> pm = this.dao.sqlRechargeLog(currentPage, pageSize, param, paramValue);
/* 58 */     String sum = this.dao.findSqlSum("select cast(IFNULL(SUM(gold),0) as decimal(18,2)) from recharge where status=1");
/* 59 */     List<Recharge> list = pm.getList();
/* 60 */     System.out.println(list.size());
/* 61 */     if (list.isEmpty()) {
/* 62 */       this.flag = "1";
/* 63 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 65 */     List<Users> ulist = this.udao.findByHQL("from Users", null);
/* 66 */     request.setAttribute("ulist", ulist);
/* 67 */     request.setAttribute("comp", comp);
/* 68 */     request.setAttribute("sum", sum);
/* 69 */     request.setAttribute("pm", pm);
/*    */     try {
/* 71 */       request.getRequestDispatcher("web/recharge_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 74 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 76 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\RechargeServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */