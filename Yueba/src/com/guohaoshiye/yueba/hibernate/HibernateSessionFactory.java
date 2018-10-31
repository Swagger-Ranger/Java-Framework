/*     */ package com.guohaoshiye.yueba.hibernate;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.cfg.Configuration;
/*     */ import org.hibernate.service.ServiceRegistry;
/*     */ import org.hibernate.service.ServiceRegistryBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HibernateSessionFactory
/*     */ {
/*  24 */   private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
/*     */   
/*     */   private static SessionFactory sessionFactory;
/*  27 */   private static Configuration configuration = new Configuration();
/*     */   private static ServiceRegistry serviceRegistry;
/*     */   
/*     */   static {
/*     */     try {
/*  32 */       configuration.configure();
/*  33 */       serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
/*  34 */       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
/*     */     } catch (Exception e) {
/*  36 */       System.err.println("%%%% Error Creating SessionFactory %%%%");
/*  37 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Session getSession()
/*     */     throws HibernateException
/*     */   {
/*  51 */     Session session = (Session)threadLocal.get();
/*     */     
/*  53 */     if ((session == null) || (!session.isOpen())) {
/*  54 */       if (sessionFactory == null) {
/*  55 */         rebuildSessionFactory();
/*     */       }
/*  57 */       session = sessionFactory != null ? sessionFactory.openSession() : null;
/*     */       
/*  59 */       threadLocal.set(session);
/*     */     }
/*     */     
/*  62 */     return session;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void rebuildSessionFactory()
/*     */   {
/*     */     try
/*     */     {
/*  71 */       configuration.configure();
/*  72 */       serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
/*  73 */       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
/*     */     } catch (Exception e) {
/*  75 */       System.err.println("%%%% Error Creating SessionFactory %%%%");
/*  76 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void closeSession()
/*     */     throws HibernateException
/*     */   {
/*  86 */     Session session = (Session)threadLocal.get();
/*  87 */     threadLocal.set(null);
/*     */     
/*  89 */     if (session != null) {
/*  90 */       session.close();
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   public static SessionFactory getSessionFactory()
/*     */   {
/*  99 */     return sessionFactory;
/*     */   }

/*     */   
/*     */ 
/*     */ 
/*     */   public static Configuration getConfiguration()
/*     */   {
/* 106 */     return configuration;
/*     */   }
/*     */ }

