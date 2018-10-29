/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminDAO;
/*     */ import com.aiwan.dao.AdminMenuDAO;
/*     */ import com.aiwan.dao.AdminRoleDAO;
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminMenu;
/*     */ import com.aiwan.entity.AdminRole;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.util.Util;
/*     */ import java.io.IOException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class LoginServlet extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  30 */   private AdminDAO dao = new AdminDAO();
/*  31 */   private AdminMenuDAO amdao = new AdminMenuDAO();
/*  32 */   private AdminRoleDAO ardao = new AdminRoleDAO();
/*  33 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  38 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  43 */     response.setContentType("text/html;charset=utf-8");
/*  44 */     request.setCharacterEncoding("UTF-8");
/*  45 */     response.setCharacterEncoding("UTF-8");
/*     */     
/*  47 */     String type = request.getParameter("type");
/*  48 */     HttpSession session = request.getSession();
/*  49 */     if (type == null)
/*     */     {
/*  51 */       session.invalidate();
/*     */       
/*  53 */       request.getRequestDispatcher("login.jsp").forward(request, response);
/*  54 */       return;
/*     */     }
/*     */     
/*  57 */     if ("loginOut".equals(type)) {
/*  58 */       Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/*  59 */       String ipClients = Util.getIpAddress(request);
/*  60 */       for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/*  61 */         if (ipClients.equals(entry.getKey())) {
/*  62 */           entry.setValue(null);
/*     */         }
/*     */       }
/*  65 */       session.setAttribute("mapAdmin", mapAdmin);
/*  66 */       response.sendRedirect("login.jsp");
/*  67 */       return;
/*     */     }
/*  69 */     String yzm = request.getParameter("code");
/*  70 */     String username = request.getParameter("username");
/*  71 */     String password = request.getParameter("password");
/*  72 */     String zyzm = (String)session.getAttribute("zyzm");
/*  73 */     if ((zyzm != null) && (!zyzm.equalsIgnoreCase(yzm))) {
/*  74 */       request.setAttribute("prompt", "验证码错误");
/*     */       try {
/*  76 */         request.getRequestDispatcher("login.jsp").forward(request, response);
/*     */       }
/*     */       catch (ServletException e) {
/*  79 */         e.printStackTrace();
/*     */       } catch (IOException e) {
/*  81 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/*  84 */       String hql = "from Admin where adminname=? and password=?";
/*  85 */       if ((username == null) || (password == null)) {
/*  86 */         response.sendRedirect("login.jsp");
/*  87 */         return;
/*     */       }
/*  89 */       List<Admin> findByHQL = this.dao.findByHQL(hql, new Object[] { username, Util.Md5(password) });
/*  90 */       if (findByHQL.size() > 0) {
/*  91 */         Admin admin = (Admin)findByHQL.get(0);
/*     */         
/*  93 */         Set<AdminRole> adminRoles = admin.getAdminRoles();
/*  94 */         adminRoles = Util.sortByValue(adminRoles);
/*  95 */         StringBuffer sb = new StringBuffer();
/*     */         
/*  97 */         sb.append("[");
/*  98 */         for (AdminRole adminRole : adminRoles)
/*  99 */           if (adminRole.getAdminMenu().getRank().intValue() == 0) {
/* 100 */             sb.append("{");
/* 101 */             sb.append("'title':'" + adminRole.getAdminMenu().getTitle() + "',");
/* 102 */             sb.append("'icon':'" + adminRole.getAdminMenu().getIcon() + "',");
/* 103 */             sb.append("'href':'" + adminRole.getAdminMenu().getUrl() + "&comp=" + adminRole.getOp() + "',");
/* 104 */             sb.append("'spread':" + adminRole.getAdminMenu().getSpread() + ",");
/* 105 */             List<AdminMenu> adminMenulist = this.amdao.findByHQL("from AdminMenu where rank=?", new Object[] { adminRole.getAdminMenu().getId() });
/* 106 */             if (adminMenulist.size() > 0) {
/* 107 */               sb.append("'children':[");
/*     */             }
/*     */             
/* 110 */             for (Iterator localIterator3 = adminRoles.iterator(); localIterator3.hasNext();) { adminRole2 = (AdminRole)localIterator3.next();
/* 111 */               if (adminRole2.getAdminMenu().getRank() == adminRole.getAdminMenu().getId()) {
/* 112 */                 sb.append("{");
/* 113 */                 sb.append("'title':'" + adminRole2.getAdminMenu().getTitle() + "',");
/* 114 */                 sb.append("'icon':'" + adminRole2.getAdminMenu().getIcon() + "',");
/* 115 */                 sb.append("'href':'" + adminRole2.getAdminMenu().getUrl() + "&comp=" + adminRole2.getOp() + "',");
/* 116 */                 sb.append("'spread':" + adminRole2.getAdminMenu().getSpread() + ",");
/* 117 */                 List<AdminMenu> adminMenulist2 = this.amdao.findByHQL("from AdminMenu where rank=?", new Object[] { adminRole2.getAdminMenu().getId() });
/* 118 */                 if (adminMenulist2.size() > 0) {
/* 119 */                   sb.append("'children':[");
/*     */                 }
/*     */                 
/* 122 */                 for (AdminRole adminRole3 : adminRoles) {
/* 123 */                   if (adminRole3.getAdminMenu().getRank() == adminRole2.getAdminMenu().getId()) {
/* 124 */                     sb.append("{");
/* 125 */                     sb.append("'title':'" + adminRole3.getAdminMenu().getTitle() + "',");
/* 126 */                     sb.append("'icon':'" + adminRole3.getAdminMenu().getIcon() + "',");
/* 127 */                     sb.append("'href':'" + adminRole3.getAdminMenu().getUrl() + "&comp=" + adminRole3.getOp() + "',");
/* 128 */                     sb.append("'spread':" + adminRole3.getAdminMenu().getSpread());
/* 129 */                     sb.append("},");
/*     */                   }
/*     */                 }
/* 132 */                 sb = new StringBuffer(sb.substring(0, sb.length() - 1));
/* 133 */                 if (adminMenulist2.size() > 0) {
/* 134 */                   sb.append("]");
/*     */                 }
/* 136 */                 sb.append("},");
/*     */               }
/*     */             }
/* 139 */             sb = new StringBuffer(sb.substring(0, sb.length() - 1));
/* 140 */             if (adminMenulist.size() > 0) {
/* 141 */               sb.append("]");
/*     */             }
/* 143 */             sb.append("},");
/*     */           }
/*     */         AdminRole adminRole2;
/* 146 */         sb = new StringBuffer(sb.substring(0, sb.length() - 1));
/* 147 */         sb.append("]");
/* 148 */         String s2 = new String(sb);
/* 149 */         s2 = s2.replace('\'', '"');
/* 150 */         String property = request.getSession().getServletContext().getRealPath("");
/* 151 */         property = property + "/json/navs.json";
/* 152 */         boolean b = Util.writeFile(property, s2);
/* 153 */         Object set = admin.getAdminRoles();
/* 154 */         for (AdminRole adminRole2 : (Set)set) {
/* 155 */           if (adminRole2.getAdminMenu().getId().intValue() == 1) {
/* 156 */             op = adminRole2.getOp();
/* 157 */             String[] split = ((String)op).split(",");
/* 158 */             admin.setAdminHomeOp1(Integer.valueOf(Integer.parseInt(split[0])));
/* 159 */             admin.setAdminHomeOp2(Integer.valueOf(Integer.parseInt(split[1])));
/*     */           }
/*     */         }
/*     */         Object op;
/* 163 */         String ipClients = Util.getIpAddress(request);
/* 164 */         if ((session != null) && (session.getAttribute("mapAdmin") != null)) {
/* 165 */           Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 166 */           for (op = mapAdmin.entrySet().iterator(); ((Iterator)op).hasNext();) { Map.Entry<String, Admin> entry = (Map.Entry)((Iterator)op).next();
/* 167 */             if (ipClients.equals(entry.getKey())) {
/* 168 */               entry.setValue(admin);
/*     */             }
/*     */           }
/* 171 */           session.setAttribute("mapAdmin", mapAdmin);
/*     */         } else {
/* 173 */           Map<String, Admin> mapAdmin = new HashMap();
/* 174 */           mapAdmin.put(ipClients, admin);
/* 175 */           session.setAttribute("mapAdmin", mapAdmin);
/*     */         }
/* 177 */         if (b) {
/* 178 */           Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 179 */           for (op = mapAdmin.entrySet().iterator(); ((Iterator)op).hasNext();) { Map.Entry<String, Admin> entry = (Map.Entry)((Iterator)op).next();
/* 180 */             if (ipClients.equals(entry.getKey())) {
/* 181 */               Admin value = (Admin)entry.getValue();
/* 182 */               AdminopLog l = new AdminopLog();
/* 183 */               l.setAid(value.getId());
/* 184 */               l.setDescription("登录后台管理系统.");
/* 185 */               l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 186 */               this.apdao.save(l);
/*     */             }
/*     */           }
/*     */           try {
/* 190 */             request.getRequestDispatcher("web/index.jsp").forward(request, response);
/*     */           }
/*     */           catch (ServletException e) {
/* 193 */             e.printStackTrace();
/*     */           } catch (IOException e) {
/* 195 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       } else {
/* 199 */         request.setAttribute("prompt", "用户名或密码错误");
/*     */         try {
/* 201 */           request.getRequestDispatcher("login.jsp").forward(request, response);
/*     */         }
/*     */         catch (ServletException e) {
/* 204 */           e.printStackTrace();
/*     */         } catch (IOException e) {
/* 206 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\LoginServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */