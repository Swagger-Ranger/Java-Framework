/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Recharge;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ public class RechargeDAO
/*    */   extends BaseHibernateDAO<Recharge>
/*    */ {
/*    */   public PageModel<Recharge> sqlRechargeLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 18 */     String where = " where 1=1 ";
/* 19 */     for (int i = 0; i < param.length; i++) {
/* 20 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 21 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 22 */         if ("userId".equals(param[i])) {
/* 23 */           where = where + " and userId = '" + paramValue[i] + "' ";
/* 24 */         } else if ("status".equals(param[i])) {
/* 25 */           where = where + " and status = '" + paramValue[i] + "' ";
/* 26 */         } else if ("order".equals(param[i])) {
/* 27 */           where = where + " and `order` = '" + paramValue[i] + "' ";
/* 28 */         } else if ("begin".equals(param[i])) {
/* 29 */           where = where + " and createtime >= '" + paramValue[i] + "' ";
/* 30 */         } else if ("end".equals(param[i])) {
/* 31 */           where = where + " and createtime <= '" + paramValue[i] + "' ";
/* 32 */         } else if ("gold".equals(param[i])) {
/* 33 */           where = where + " and gold = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 39 */     where = where + " and status!=-1 ";
/* 40 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<Recharge> logList(int currentPage, int pageSize, String where) {
/* 44 */     PageModel<Recharge> pm = new PageModel();
/* 45 */     String sql = "select count(id) from recharge";
/* 46 */     if (where != null) {
/* 47 */       sql = sql + where;
/*    */     }
/* 49 */     System.out.println(sql);
/* 50 */     pm.setPageSize(pageSize);
/* 51 */     pm.setSumCount(count(sql));
/* 52 */     pm.setCurrentPage(currentPage);
/* 53 */     where = where.replace("`", "");
/* 54 */     String hql = "from Recharge";
/* 55 */     if (where != null) {
/* 56 */       hql = hql + where + "order by createtime desc";
/*    */     }
/* 58 */     System.out.println(hql);
/* 59 */     Query query = getSession().createQuery(hql);
/*    */     
/* 61 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 63 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 64 */     pm.setList(query.list());
/* 65 */     getSession().clear();
/* 66 */     getSession().close();
/* 67 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql) {
/* 71 */     Query query = getSession().createSQLQuery(sql);
/* 72 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public String findSqlSum(String sql) {
/* 76 */     String count = "0";
/* 77 */     Session session = null;
/* 78 */     Transaction tx = null;
/*    */     try {
/* 80 */       session = getSession();
/* 81 */       tx = session.beginTransaction();
/* 82 */       Query query = session.createSQLQuery(sql);
/* 83 */       Object c = query.uniqueResult();
/* 84 */       count = c.toString();
/* 85 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 87 */       System.out.println("执行HQL查找对象出现错误！");
/* 88 */       ex.printStackTrace();
/* 89 */       if (tx != null) {
/* 90 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 93 */       if (session != null) {
/* 94 */         session.clear();
/* 95 */         session.close();
/*    */       }
/*    */     }
/* 98 */     return count;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\RechargeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */