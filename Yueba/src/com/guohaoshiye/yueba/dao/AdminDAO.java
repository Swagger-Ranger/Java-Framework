/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Admin;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class AdminDAO extends com.aiwan.hibernate.BaseHibernateDAO<Admin>
/*    */ {
/*    */   public PageModel<Admin> pageList(int currentPage, int pageSize)
/*    */   {
/* 12 */     PageModel<Admin> pm = new PageModel();
/* 13 */     String sql = "select count(id) from Admin";
/* 14 */     pm.setPageSize(pageSize);
/* 15 */     pm.setSumCount(count(sql));
/* 16 */     pm.setCurrentPage(currentPage);
/* 17 */     Query query = getSession().createQuery("from Admin");
/*    */     
/* 19 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 21 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 22 */     pm.setList(query.list());
/* 23 */     getSession().clear();
/* 24 */     getSession().close();
/* 25 */     return pm;
/*    */   }
/*    */   
/* 28 */   public int count(String sql) { Query query = getSession().createQuery(sql);
/* 29 */     return ((Long)query.uniqueResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\AdminDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */