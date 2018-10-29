/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.dao.MailmanagementDAO;
/*    */ import com.aiwan.dao.SystemLogDAO;
/*    */ import com.aiwan.entity.Admin;
/*    */ import com.aiwan.entity.SystemLog;
/*    */ import com.aiwan.entity.Users;
/*    */ import com.aiwan.util.Util;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MailmanagementServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 28 */   private MailmanagementDAO dao = new MailmanagementDAO();
/* 29 */   private PrintWriter out = null;
/* 30 */   private SystemLogDAO sdao = new SystemLogDAO();
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 35 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 40 */     response.setContentType("text/html;charset=utf-8");
/* 41 */     request.setCharacterEncoding("UTF-8");
/* 42 */     response.setCharacterEncoding("UTF-8");
/* 43 */     String op = request.getParameter("op");
/* 44 */     if ("addMail".equals(op)) {
/* 45 */       addMail(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   private void addMail(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 51 */     Timestamp d = new Timestamp(System.currentTimeMillis());
/* 52 */     int type = Integer.parseInt(request.getParameter("type"));
/* 53 */     String describe = request.getParameter("describe");
/* 54 */     SystemLog log = new SystemLog();
/* 55 */     HttpSession session = request.getSession();
/* 56 */     String ipClients = Util.getIpAddress(request);
/* 57 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 58 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 59 */       if (ipClients.equals(entry.getKey())) {
/* 60 */         log.setAid(((Admin)entry.getValue()).getId());
/*    */       }
/*    */     }
/* 63 */     String typeMsg = type == 0 ? "发送邮件-普通玩家(群体)" : "发送邮件-推广员玩家(群体)";
/* 64 */     log.setOperating(typeMsg);
/* 65 */     log.setContent(describe);
/* 66 */     log.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 67 */     this.sdao.save(log);
/* 68 */     String sql = "";
/* 69 */     if (type == 0) {
/* 70 */       sql = "select u.* from users AS u where id not in(select uid FROM proxy)";
/*    */     } else {
/* 72 */       sql = "select u.* from users AS u where id in(select uid FROM proxy)";
/*    */     }
/* 74 */     List<Users> list = this.dao.findAllUser(sql);
/* 75 */     this.dao.saveMail(d, list, describe);
/*    */     try {
/* 77 */       this.out = response.getWriter();
/* 78 */       this.out.print("ok");
/* 79 */       this.out.flush();
/* 80 */       this.out.close();
/*    */     } catch (IOException e) {
/* 82 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\MailmanagementServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */