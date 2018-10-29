/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.AdminDAO;
/*    */ import com.aiwan.dao.AdminRechargeLogDAO;
/*    */ import com.aiwan.dao.UsersDAO;
/*    */ import com.aiwan.entity.Admin;
/*    */ import com.aiwan.entity.AdminRechargeLog;
/*    */ import com.aiwan.entity.Users;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.json.JSONObject;
/*    */ 
/*    */ public class AdminRechargeLogServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private AdminRechargeLogDAO dao = new AdminRechargeLogDAO();
/* 24 */   private UsersDAO udao = new UsersDAO();
/* 25 */   private AdminDAO adao = new AdminDAO();
/* 26 */   private String flag = "";
/* 27 */   private JSONObject json = null;
/* 28 */   private PrintWriter out = null;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 32 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 37 */     response.setContentType("text/html;charset=utf-8");
/* 38 */     request.setCharacterEncoding("UTF-8");
/* 39 */     response.setCharacterEncoding("UTF-8");
/* 40 */     String op = request.getParameter("op");
/* 41 */     if ("adminRechargeLogList".equals(op)) {
/* 42 */       adminRechargeLogList(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void adminRechargeLogList(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 54 */     String comp = request.getParameter("comp");
/* 55 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 56 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 57 */     String[] param = { "uid", "aid", "rtype", "money", "begin", "end" };
/* 58 */     String[] paramValue = new String[param.length];
/* 59 */     for (int i = 0; i < param.length; i++) {
/* 60 */       paramValue[i] = request.getParameter(param[i]);
/* 61 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 63 */     PageModel<AdminRechargeLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 64 */     String jbsum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=1");
/* 65 */     String zssum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=2");
/* 66 */     String jfsum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=3");
/* 67 */     List<AdminRechargeLog> list = pm.getList();
/* 68 */     if (list.isEmpty()) {
/* 69 */       this.flag = "1";
/* 70 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 72 */     List<Users> ulist = this.udao.findByHQL("from Users", null);
/* 73 */     List<Admin> alist = this.adao.findByHQL("from Admin", null);
/* 74 */     request.setAttribute("comp", comp);
/* 75 */     request.setAttribute("ulist", ulist);
/* 76 */     request.setAttribute("alist", alist);
/* 77 */     request.setAttribute("jbsum", jbsum);
/* 78 */     request.setAttribute("zssum", zssum);
/* 79 */     request.setAttribute("jfsum", jfsum);
/* 80 */     request.setAttribute("pm", pm);
/*    */     try {
/* 82 */       request.getRequestDispatcher("web/admin_recharge_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 85 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 87 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AdminRechargeLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */