/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.AdminRole;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class AdminRoleDAO extends BaseHibernateDAO<AdminRole>
/*    */ {
/*    */   public void deleteRole(Integer id)
/*    */   {
/* 13 */     Session session = null;
/* 14 */     Transaction tx = null;
/*    */     try {
/* 16 */       session = getSession();
/* 17 */       tx = session.beginTransaction();
/* 18 */       Query query = session.createSQLQuery("delete from admin_role where aid=?");
/* 19 */       query.setParameter(0, id);
/* 20 */       query.executeUpdate();
/* 21 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 23 */       System.out.println("执行HQL查找对象出现错误！");
/* 24 */       ex.printStackTrace();
/* 25 */       if (tx != null) {
/* 26 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 29 */       if (session != null) {
/* 30 */         session.clear();
/* 31 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\AdminRoleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */