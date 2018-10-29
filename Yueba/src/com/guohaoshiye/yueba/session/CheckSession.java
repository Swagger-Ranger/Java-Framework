/*    */ package com.aiwan.session;
/*    */ 
/*    */ import com.aiwan.entity.Admin;
/*    */ import com.aiwan.util.Util;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckSession
/*    */   implements Filter
/*    */ {
/*    */   public void destroy() {}
/*    */   
/*    */   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
/*    */     throws IOException, ServletException
/*    */   {
/* 30 */     HttpServletRequest request = (HttpServletRequest)servletRequest;
/*    */     
/* 32 */     HttpServletResponse response = (HttpServletResponse)servletResponse;
/*    */     
/* 34 */     String currentURL = request.getRequestURI();
/* 35 */     int num = currentURL.indexOf("/", 1);
/* 36 */     num = num < 0 ? 0 : num;
/* 37 */     String targetURL = currentURL.substring(num, currentURL.length());
/* 38 */     HttpSession session = request.getSession();
/* 39 */     if ((targetURL.contains(".css")) || 
/* 40 */       (targetURL.contains(".js")) || 
/* 41 */       (targetURL.contains("img")) || 
/* 42 */       (targetURL.contains(".jpg")) || 
/* 43 */       (targetURL.contains(".png")) || 
/* 44 */       (targetURL.contains(".woff")) || 
/* 45 */       (targetURL.contains(".json")) || 
/* 46 */       (targetURL.contains(".ttf")) || 
/* 47 */       (targetURL.contains(".woff2")) || 
/* 48 */       (targetURL.contains(".doc")) || 
/* 49 */       (targetURL.contains("/AuthImageServlet")) || 
/* 50 */       (targetURL.contains("/LoginServlet")))
/*    */     {
/* 52 */       filterChain.doFilter(request, response);
/* 53 */       return;
/*    */     }
/* 55 */     if (!"/login.jsp".equals(targetURL)) {
/* 56 */       if ((session == null) || (session.getAttribute("mapAdmin") == null)) {
/* 57 */         String ipClients = Util.getIpAddress(request);
/* 58 */         Map<String, Admin> mapAdmin = new HashMap();
/* 59 */         mapAdmin.put(ipClients, null);
/* 60 */         session.setAttribute("mapAdmin", mapAdmin);
/* 61 */         response.sendRedirect("login.jsp");
/* 62 */         return;
/*    */       }
/* 64 */       String ipClients = Util.getIpAddress(request);
/* 65 */       Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 66 */       Integer i = Integer.valueOf(0);
/* 67 */       for (Map.Entry<String, Admin> entry : mapAdmin.entrySet())
/* 68 */         if (ipClients.equals(entry.getKey())) {
/* 69 */           if (entry.getValue() == null) {
/* 70 */             response.sendRedirect("login.jsp");
/*    */           }
/*    */         }
/*    */         else {
/* 74 */           localInteger1 = i;Integer localInteger2 = i = Integer.valueOf(i.intValue() + 1);
/*    */         }
/*    */       Integer localInteger1;
/* 77 */       if (i.intValue() == mapAdmin.size()) {
/* 78 */         mapAdmin.put(ipClients, null);
/* 79 */         session.setAttribute("mapAdmin", mapAdmin);
/* 80 */         response.sendRedirect("login.jsp");
/* 81 */         return;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 86 */     filterChain.doFilter(request, response);
/*    */   }
/*    */   
/*    */   public void init(FilterConfig filterConfig)
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\session\CheckSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */