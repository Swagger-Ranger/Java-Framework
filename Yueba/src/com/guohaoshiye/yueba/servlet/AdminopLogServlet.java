/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.AdminopLogDAO;
/*    */ import com.aiwan.entity.AdminopLog;
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
/*    */ public class AdminopLogServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   private AdminopLogDAO dao = new AdminopLogDAO();
/* 21 */   private String flag = "";
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 25 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 30 */     response.setContentType("text/html;charset=utf-8");
/* 31 */     request.setCharacterEncoding("UTF-8");
/* 32 */     response.setCharacterEncoding("UTF-8");
/* 33 */     String op = request.getParameter("op");
/* 34 */     if ("loglist".equals(op)) {
/* 35 */       loglist(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void loglist(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 47 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 48 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 49 */     String[] param = { "aid", "begin", "end" };
/* 50 */     String[] paramValue = new String[param.length];
/* 51 */     for (int i = 0; i < param.length; i++) {
/* 52 */       paramValue[i] = request.getParameter(param[i]);
/* 53 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 55 */     PageModel<AdminopLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 56 */     List<AdminopLog> list = pm.getList();
/* 57 */     if (list.isEmpty()) {
/* 58 */       this.flag = "1";
/* 59 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 61 */     request.setAttribute("pm", pm);
/*    */     try {
/* 63 */       request.getRequestDispatcher("web/adminop_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 66 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 68 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AdminopLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */