/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.CommoditypurchaseLog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ public class CommoditypurchaseLogDAO
/*    */   extends BaseHibernateDAO<CommoditypurchaseLog>
/*    */ {
/*    */   public PageModel<CommoditypurchaseLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 18 */     String where = " where 1=1 ";
/* 19 */     for (int i = 0; i < param.length; i++) {
/* 20 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 21 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 22 */         if ("CommodityName".equals(param[i])) {
/* 23 */           where = where + " and commodityName = '" + paramValue[i] + "' ";
/*    */         }
/* 25 */         else if ("PurchaseUserid".equals(param[i])) {
/* 26 */           where = where + " and purchaseUserid = '" + paramValue[i] + "' ";
/* 27 */         } else if ("begin".equals(param[i])) {
/* 28 */           where = where + " and createTime >= '" + paramValue[i] + " 0:0:0' ";
/* 29 */         } else if ("end".equals(param[i])) {
/* 30 */           where = where + " and createTime <= '" + paramValue[i] + " 23:59:59' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 36 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<CommoditypurchaseLog> logList(int currentPage, int pageSize, String where)
/*    */   {
/* 41 */     PageModel<CommoditypurchaseLog> pm = new PageModel();
/* 42 */     String sql = "select count(id) from commoditypurchase_log";
/* 43 */     if (where != null) {
/* 44 */       sql = sql + where;
/*    */     }
/* 46 */     pm.setPageSize(pageSize);
/* 47 */     pm.setSumCount(count(sql));
/* 48 */     pm.setCurrentPage(currentPage);
/*    */     
/* 50 */     String hql = "from CommoditypurchaseLog";
/* 51 */     if (where != null) {
/* 52 */       hql = hql + where + "order by createTime desc";
/*    */     }
/* 54 */     Query query = getSession().createQuery(hql);
/*    */     
/* 56 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 58 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 59 */     pm.setList(query.list());
/* 60 */     getSession().clear();
/* 61 */     getSession().close();
/* 62 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 67 */     Query query = getSession().createSQLQuery(sql);
/* 68 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public String findSqlSum(String sql) {
/* 72 */     String count = "0";
/* 73 */     Session session = null;
/* 74 */     Transaction tx = null;
/*    */     try {
/* 76 */       session = getSession();
/* 77 */       tx = session.beginTransaction();
/* 78 */       Query query = session.createSQLQuery(sql);
/* 79 */       Object c = query.uniqueResult();
/* 80 */       count = c.toString();
/* 81 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 83 */       System.out.println("执行HQL查找对象出现错误！");
/* 84 */       ex.printStackTrace();
/* 85 */       if (tx != null) {
/* 86 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 89 */       if (session != null) {
/* 90 */         session.clear();
/* 91 */         session.close();
/*    */       }
/*    */     }
/* 94 */     return count;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\CommoditypurchaseLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */