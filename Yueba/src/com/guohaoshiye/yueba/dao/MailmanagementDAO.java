/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Mailmanagement;
/*    */ import com.aiwan.entity.Users;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.SQLQuery;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MailmanagementDAO
/*    */   extends BaseHibernateDAO<Mailmanagement>
/*    */ {
/*    */   public void saveMail(Timestamp d, List<Users> list, String describe)
/*    */   {
/* 24 */     Session session = getSession();
/* 25 */     Transaction tx = session.beginTransaction();
/* 26 */     session.doWork(new MailmanagementDAO.1(this, list, describe, d));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */     tx.commit();
/* 48 */     session.close();
/*    */   }
/*    */   
/*    */   public List<Users> findAllUser(String sql)
/*    */   {
/* 53 */     Session session = null;
/* 54 */     Transaction tx = null;
/* 55 */     List<Users> obj = new ArrayList();
/*    */     try {
/* 57 */       session = getSession();
/* 58 */       tx = session.beginTransaction();
/* 59 */       Query query = getSession().createSQLQuery(sql);
/* 60 */       ((SQLQuery)query).addEntity("u", Users.class);
/* 61 */       obj = query.list();
/* 62 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 64 */       System.out.println("查找对象出现错误！");
/* 65 */       ex.printStackTrace();
/* 66 */       if (tx != null) {
/* 67 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 70 */       if (session != null) {
/* 71 */         session.clear();
/* 72 */         session.close();
/*    */       }
/*    */     }
/* 75 */     return obj;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\MailmanagementDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */