/*    */ package com.aiwan.servlet;
/*    */ 
/*    */ import com.aiwan.util.VerifyCodeUtils;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuthImageServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 27 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 32 */     response.setHeader("Pragma", "No-cache");
/* 33 */     response.setHeader("Cache-Control", "no-cache");
/* 34 */     response.setDateHeader("Expires", 0L);
/* 35 */     response.setContentType("image/jpeg");
/*    */     
/*    */ 
/* 38 */     String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
/*    */     
/* 40 */     HttpSession session = request.getSession(true);
/*    */     
/* 42 */     session.removeAttribute("zyzm");
/* 43 */     session.setAttribute("zyzm", verifyCode.toLowerCase());
/*    */     
/* 45 */     int w = 116;int h = 36;
/* 46 */     VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AuthImageServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */