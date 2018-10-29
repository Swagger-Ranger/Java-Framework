/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.SystemLogDAO;
/*    */ import com.aiwan.entity.SystemLog;
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
/*    */ public class SystemLogServlet
/*    */   extends HttpServlet
/*    */ {
/* 19 */   private String flag = "";
/* 20 */   private SystemLogDAO dao = new SystemLogDAO();
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
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
/* 35 */     if ("loglist".equals(op)) {
/* 36 */       loglist(request, response);
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
/* 48 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 49 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 50 */     String[] param = { "aid", "begin", "end", "operating" };
/* 51 */     String[] paramValue = new String[param.length];
/* 52 */     for (int i = 0; i < param.length; i++) {
/* 53 */       paramValue[i] = request.getParameter(param[i]);
/* 54 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 56 */     PageModel<SystemLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 57 */     List<SystemLog> list = pm.getList();
/* 58 */     if (list.isEmpty()) {
/* 59 */       this.flag = "1";
/* 60 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 62 */     request.setAttribute("pm", pm);
/*    */     try {
/* 64 */       request.getRequestDispatcher("web/sysadmin_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 67 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 69 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\SystemLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */