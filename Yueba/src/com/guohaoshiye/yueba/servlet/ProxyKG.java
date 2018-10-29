/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.ProxyDAO;
/*     */ import com.aiwan.entity.Proxy;
/*     */ import com.aiwan.entity.Proxy_class;
/*     */ import com.aiwan.hibernate.HibernateSessionFactory;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SQLQuery;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ public class ProxyKG
/*     */   extends HttpServlet
/*     */ {
/*     */   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
/*     */     throws ServletException, IOException
/*     */   {
/*  28 */     doPost(req, resp);
/*     */   }
/*     */   
/*     */   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
/*     */   {
/*  33 */     Integer kg = Integer.valueOf(req.getParameter("kg"));
/*  34 */     Integer id = Integer.valueOf(req.getParameter("id"));
/*  35 */     Session session = HibernateSessionFactory.getSessionFactory().openSession();
/*  36 */     Proxy proxy = (Proxy)session.get(Proxy.class, id);
/*  37 */     ProxyDAO dao = new ProxyDAO();
/*  38 */     if (kg.intValue() == 0)
/*     */     {
/*     */ 
/*     */ 
/*  42 */       Proxy_class proxy_class = new Proxy_class();
/*  43 */       proxy_class.setPid(id);
/*  44 */       proxy_class.setClazz(Integer.valueOf(1));
/*  45 */       proxy_class.setTimes(Long.valueOf(new Date().getTime()));
/*  46 */       proxy_class.setYikai(Integer.valueOf(0));
/*  47 */       proxy.setKg(Integer.valueOf(1));
/*  48 */       proxy.setRight(Integer.valueOf(1));
/*     */       
/*     */ 
/*  51 */       dao.initUserGrade(id.intValue());
/*     */       try {
/*  53 */         session.beginTransaction();
/*  54 */         session.save(proxy);
/*  55 */         session.save(proxy_class);
/*  56 */         session.getTransaction().commit();
/*     */         
/*  58 */         session.beginTransaction();
/*     */         
/*  60 */         session.getTransaction().commit();
/*     */       } catch (Exception e) {
/*  62 */         e.printStackTrace();
/*     */       } finally {
/*  64 */         session.beginTransaction().rollback();
/*  65 */         session.clear();
/*  66 */         session.close();
/*     */       }
/*     */     }
/*     */     else {
/*  70 */       proxy.setKg(Integer.valueOf(0));proxy.setRight(Integer.valueOf(0));
/*     */       
/*  72 */       Query queryNum = session.createSQLQuery("select * from proxy_class where pid = " + id).addEntity(Proxy_class.class);queryNum.setMaxResults(1);
/*  73 */       Proxy_class proxy_class1 = (Proxy_class)queryNum.uniqueResult();
/*     */       try
/*     */       {
/*  76 */         session.beginTransaction();
/*  77 */         session.save(proxy);
/*  78 */         if (proxy_class1 != null) session.delete(proxy_class1);
/*  79 */         session.getTransaction().commit();
/*     */       } catch (Exception e) {
/*  81 */         e.printStackTrace();
/*     */       } finally {
/*  83 */         session.beginTransaction().rollback();
/*  84 */         session.clear();
/*  85 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Proxy> findAllSubordinateUsers(int id)
/*     */   {
/*  94 */     ProxyDAO dao = new ProxyDAO();
/*  95 */     List<Proxy> usersList = new ArrayList();
/*     */     
/*  97 */     List<Proxy> proxyList = dao.sqlFindProxyUser(id);
/*     */     
/*  99 */     for (Proxy proxy : proxyList)
/*     */     {
/* 101 */       usersList.addAll(findAllSubordinateUsers(proxy.getId().intValue()));
/*     */     }
/* 103 */     usersList.addAll(proxyList);
/*     */     
/* 105 */     return usersList;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\ProxyKG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */