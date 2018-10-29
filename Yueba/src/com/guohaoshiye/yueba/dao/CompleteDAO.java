/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Complete;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class CompleteDAO extends BaseHibernateDAO<Complete>
/*    */ {
/*    */   public PageModel<Complete> pageList(int currentPage, int pageSize)
/*    */   {
/* 13 */     PageModel<Complete> pm = new PageModel();
/* 14 */     String sql = "select count(id) from Complete";
/* 15 */     pm.setPageSize(pageSize);
/* 16 */     pm.setSumCount(count(sql));
/* 17 */     pm.setCurrentPage(currentPage);
/* 18 */     Query query = getSession().createQuery("from Complete");
/*    */     
/* 20 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 22 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 23 */     pm.setList(query.list());
/* 24 */     getSession().clear();
/* 25 */     getSession().close();
/* 26 */     return pm;
/*    */   }
/*    */   
/* 29 */   public int count(String sql) { Query query = getSession().createQuery(sql);
/* 30 */     return ((Long)query.uniqueResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\CompleteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */