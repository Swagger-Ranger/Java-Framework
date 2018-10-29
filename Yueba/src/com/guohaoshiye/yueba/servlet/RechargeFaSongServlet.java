/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ public class RechargeFaSongServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 25 */     response.setContentType("text/html;charset=utf-8");
/* 26 */     request.setCharacterEncoding("UTF-8");
/* 27 */     response.setCharacterEncoding("UTF-8");
/* 28 */     String op = request.getParameter("op");
/* 29 */     if ("rechargefasong".equals(op)) {
/* 30 */       rechargefasong(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   private void rechargefasong(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 36 */     System.out.println("支付来了~~~~~~~~~~~~~~~~~~");
/*    */     
/*    */ 
/* 39 */     request.setAttribute("flag", request.getParameter("p8_sign"));
/* 40 */     request.setAttribute("p14_customname", request.getParameter("p14_customname"));
/* 41 */     request.setAttribute("p16_customip", request.getParameter("p16_customip"));
/* 42 */     request.setAttribute("p25_treminal", request.getParameter("p25_treminal"));
/* 43 */     request.setAttribute("url", "http://order.z.jtpay.com/jh-web-order/order.receiveOrder");
/*    */     try {
/* 45 */       request.getRequestDispatcher("right/rechargefasong.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 48 */       e.printStackTrace();
/*    */     }
/*    */     catch (IOException e) {
/* 51 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\RechargeFaSongServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */