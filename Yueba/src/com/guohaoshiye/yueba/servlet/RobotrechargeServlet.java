/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.RobotrechargeDAO;
/*    */ import com.aiwan.entity.Robotrecharge;
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
/*    */ public class RobotrechargeServlet
/*    */   extends HttpServlet
/*    */ {
/* 20 */   private RobotrechargeDAO dao = new RobotrechargeDAO();
/* 21 */   private String flag = "";
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 29 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 34 */     response.setContentType("text/html;charset=utf-8");
/* 35 */     request.setCharacterEncoding("UTF-8");
/* 36 */     response.setCharacterEncoding("UTF-8");
/* 37 */     String op = request.getParameter("op");
/* 38 */     if ("loglist".equals(op)) {
/* 39 */       loglist(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   private void loglist(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 45 */     String comp = request.getParameter("comp");
/* 46 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 47 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 48 */     String[] param = { "rid", "aid" };
/* 49 */     String[] paramValue = new String[param.length];
/* 50 */     for (int i = 0; i < param.length; i++) {
/* 51 */       paramValue[i] = request.getParameter(param[i]);
/* 52 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 54 */     PageModel<Robotrecharge> pm = this.dao.sqlRechargeLog(currentPage, pageSize, param, paramValue);
/* 55 */     List<Robotrecharge> list = pm.getList();
/* 56 */     if (list.isEmpty()) {
/* 57 */       this.flag = "1";
/* 58 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 60 */     request.setAttribute("pm", pm);
/*    */     try {
/* 62 */       request.getRequestDispatcher("web/robotrecharge_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 65 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 67 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\RobotrechargeServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */