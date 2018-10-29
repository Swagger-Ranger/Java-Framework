/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.AdminRechargeLog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ public class AdminRechargeLogDAO
/*    */   extends BaseHibernateDAO<AdminRechargeLog>
/*    */ {
/*    */   public PageModel<AdminRechargeLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 18 */     String where = " where 1=1 ";
/* 19 */     for (int i = 0; i < param.length; i++) {
/* 20 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 21 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 22 */         if ("uid".equals(param[i])) {
/* 23 */           where = where + " and uid = '" + paramValue[i] + "' ";
/*    */         }
/* 25 */         else if ("aid".equals(param[i])) {
/* 26 */           where = where + " and aid = '" + paramValue[i] + "' ";
/* 27 */         } else if ("rtype".equals(param[i])) {
/* 28 */           where = where + " and rtype = '" + paramValue[i] + "' ";
/* 29 */         } else if ("money".equals(param[i])) {
/* 30 */           where = where + " and money = '" + paramValue[i] + "' ";
/* 31 */         } else if ("begin".equals(param[i])) {
/* 32 */           where = where + " and createTime >= '" + paramValue[i] + "' ";
/* 33 */         } else if ("end".equals(param[i])) {
/* 34 */           where = where + " and createTime <= '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 40 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<AdminRechargeLog> logList(int currentPage, int pageSize, String where) {
/* 44 */     PageModel<AdminRechargeLog> pm = new PageModel();
/* 45 */     String sql = "select count(id) from admin_recharge_log";
/* 46 */     if (where != null) {
/* 47 */       sql = sql + where;
/*    */     }
/* 49 */     pm.setPageSize(pageSize);
/* 50 */     pm.setSumCount(count(sql));
/* 51 */     pm.setCurrentPage(currentPage);
/*    */     
/* 53 */     String hql = "from AdminRechargeLog";
/* 54 */     if (where != null) {
/* 55 */       hql = hql + where + "order by createTime desc";
/*    */     }
/* 57 */     Query query = getSession().createQuery(hql);
/*    */     
/* 59 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 61 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 62 */     pm.setList(query.list());
/* 63 */     getSession().clear();
/* 64 */     getSession().close();
/* 65 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 70 */     Query query = getSession().createSQLQuery(sql);
/* 71 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public String findSqlSum(String sql) {
/* 75 */     String count = "0";
/* 76 */     Session session = null;
/* 77 */     Transaction tx = null;
/*    */     try {
/* 79 */       session = getSession();
/* 80 */       tx = session.beginTransaction();
/* 81 */       Query query = session.createSQLQuery(sql);
/* 82 */       Object c = query.uniqueResult();
/* 83 */       count = c.toString();
/* 84 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 86 */       System.out.println("执行HQL查找对象出现错误！");
/* 87 */       ex.printStackTrace();
/* 88 */       if (tx != null) {
/* 89 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 92 */       if (session != null) {
/* 93 */         session.clear();
/* 94 */         session.close();
/*    */       }
/*    */     }
/* 97 */     return count;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\AdminRechargeLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */