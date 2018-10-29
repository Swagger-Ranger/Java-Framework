/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.AdminDAO;
/*    */ import com.aiwan.dao.MailmanagementDAO;
/*    */ import com.aiwan.dao.ParameterDAO;
/*    */ import com.aiwan.dao.ProxyDAO;
/*    */ import com.aiwan.dao.ProxytoexamineLogDAO;
/*    */ import com.aiwan.dao.UsersDAO;
/*    */ import com.aiwan.entity.ProxytoexamineLog;
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
/*    */ 
/*    */ 
/*    */ public class ProxytoexamineLogServlet
/*    */   extends HttpServlet
/*    */ {
/* 26 */   private ProxytoexamineLogDAO dao = new ProxytoexamineLogDAO();
/* 27 */   private ProxyDAO pdao = new ProxyDAO();
/* 28 */   private UsersDAO udao = new UsersDAO();
/* 29 */   private AdminDAO adao = new AdminDAO();
/* 30 */   private ParameterDAO padao = new ParameterDAO();
/* 31 */   private MailmanagementDAO mdao = new MailmanagementDAO();
/* 32 */   private String flag = "";
/* 33 */   private JSONObject json = null;
/* 34 */   private PrintWriter out = null;
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 39 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 43 */     response.setContentType("text/html;charset=utf-8");
/* 44 */     request.setCharacterEncoding("UTF-8");
/* 45 */     response.setCharacterEncoding("UTF-8");
/* 46 */     String op = request.getParameter("op");
/*    */     
/*    */ 
/* 49 */     if ("listProxytoexamineLog".equals(op)) {
/* 50 */       listProxytoexamineLog(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void listProxytoexamineLog(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 61 */     String comp = request.getParameter("comp");
/* 62 */     Integer proxyOp1 = Integer.valueOf(0);
/* 63 */     String[] splits = comp.split(",");
/* 64 */     proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));
/*    */     
/* 66 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 67 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/* 68 */     String[] param = { "uid", "pid", "phone", "begin", "end", "weixinhao" };
/* 69 */     String[] paramValue = new String[param.length];
/* 70 */     for (int i = 0; i < param.length; i++) {
/* 71 */       paramValue[i] = request.getParameter(param[i]);
/* 72 */       request.setAttribute(param[i], paramValue[i]);
/*    */     }
/* 74 */     PageModel<ProxytoexamineLog> pm = this.dao.sqlLoglist(currentPage, pageSize, param, paramValue);
/* 75 */     List<ProxytoexamineLog> list = pm.getList();
/* 76 */     if (list.isEmpty()) {
/* 77 */       this.flag = "1";
/* 78 */       request.setAttribute("flag", this.flag);
/*    */     }
/* 80 */     request.setAttribute("comp", comp);
/* 81 */     request.setAttribute("proxyOp1", proxyOp1);
/* 82 */     request.setAttribute("pm", pm);
/*    */     try {
/* 84 */       request.getRequestDispatcher("web/proxyshenqing_log.jsp").forward(request, response);
/*    */     }
/*    */     catch (ServletException e) {
/* 87 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 89 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\ProxytoexamineLogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */