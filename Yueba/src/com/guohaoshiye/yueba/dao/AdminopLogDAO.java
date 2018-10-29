/*    */ package com.guohaoshiye.yueba.dao;
/*    */ 
/*    */ import com.aiwan.entity.AdminopLog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ 
/*    */ public class AdminopLogDAO
/*    */   extends BaseHibernateDAO<AdminopLog>
/*    */ {
/*    */   public PageModel<AdminopLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 16 */     String where = " where 1=1 ";
/* 17 */     for (int i = 0; i < param.length; i++) {
/* 18 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 19 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 20 */         if ("aid".equals(param[i])) {
/* 21 */           where = where + " and aid = '" + paramValue[i] + "' ";
/*    */         }
/* 23 */         else if ("begin".equals(param[i])) {
/* 24 */           where = where + " and createTime >= '" + paramValue[i] + " 0:0:0' ";
/* 25 */         } else if ("end".equals(param[i])) {
/* 26 */           where = where + " and createTime <= '" + paramValue[i] + " 23:59:59' ";
/* 27 */         } else if ("operating".equals(param[i])) {
/* 28 */           where = where + " and operating = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 35 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<AdminopLog> logList(int currentPage, int pageSize, String where)
/*    */   {
/* 40 */     PageModel<AdminopLog> pm = new PageModel();
/* 41 */     String sql = "select count(id) from adminop_log";
/* 42 */     if (where != null) {
/* 43 */       sql = sql + where;
/*    */     }
/* 45 */     pm.setPageSize(pageSize);
/* 46 */     pm.setSumCount(count(sql));
/* 47 */     pm.setCurrentPage(currentPage);
/*    */     
/* 49 */     String hql = "from AdminopLog";
/* 50 */     if (where != null) {
/* 51 */       hql = hql + where + "order by createTime desc";
/*    */     }
/* 53 */     Query query = getSession().createQuery(hql);
/*    */     
/* 55 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 57 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 58 */     pm.setList(query.list());
/* 59 */     getSession().clear();
/* 60 */     getSession().close();
/* 61 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 66 */     Query query = getSession().createSQLQuery(sql);
/* 67 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\AdminopLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */