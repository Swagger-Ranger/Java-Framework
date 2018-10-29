/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.SystemLog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class SystemLogDAO
/*    */   extends BaseHibernateDAO<SystemLog>
/*    */ {
/*    */   public List<SystemLog> findlist()
/*    */   {
/* 18 */     List<SystemLog> list = null;
/* 19 */     Session session = null;
/* 20 */     Transaction tx = null;
/*    */     try {
/* 22 */       session = getSession();
/* 23 */       tx = session.beginTransaction();
/*    */       
/* 25 */       Query query = session.createQuery("from SystemLog order by createTime desc");
/* 26 */       query.setFirstResult(0);
/* 27 */       query.setMaxResults(5);
/* 28 */       list = query.list();
/* 29 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 31 */       System.out.println("执行HQL查找对象出现错误！");
/* 32 */       ex.printStackTrace();
/* 33 */       if (tx != null) {
/* 34 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 37 */       if (session != null) {
/* 38 */         session.clear();
/* 39 */         session.close();
/*    */       }
/*    */     }
/* 42 */     return list;
/*    */   }
/*    */   
/*    */   public PageModel<SystemLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 47 */     String where = " where 1=1 ";
/* 48 */     for (int i = 0; i < param.length; i++) {
/* 49 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 50 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 51 */         if ("aid".equals(param[i])) {
/* 52 */           where = where + " and aid = '" + paramValue[i] + "' ";
/*    */         }
/* 54 */         else if ("begin".equals(param[i])) {
/* 55 */           where = where + " and createTime >= '" + paramValue[i] + "' ";
/* 56 */         } else if ("end".equals(param[i])) {
/* 57 */           where = where + " and createTime <= '" + paramValue[i] + "' ";
/* 58 */         } else if ("operating".equals(param[i])) {
/* 59 */           where = where + " and operating = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 66 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */ 
/*    */   private PageModel<SystemLog> logList(int currentPage, int pageSize, String where)
/*    */   {
/* 72 */     PageModel<SystemLog> pm = new PageModel();
/* 73 */     String sql = "select count(id) from system_log";
/* 74 */     if (where != null) {
/* 75 */       sql = sql + where;
/*    */     }
/* 77 */     pm.setPageSize(pageSize);
/* 78 */     pm.setSumCount(count(sql));
/* 79 */     pm.setCurrentPage(currentPage);
/*    */     
/* 81 */     String hql = "from SystemLog";
/* 82 */     if (where != null) {
/* 83 */       hql = hql + where + "order by createTime desc";
/*    */     }
/* 85 */     Query query = getSession().createQuery(hql);
/*    */     
/* 87 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 89 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 90 */     pm.setList(query.list());
/* 91 */     getSession().clear();
/* 92 */     getSession().close();
/* 93 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 98 */     Query query = getSession().createSQLQuery(sql);
/* 99 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\SystemLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */