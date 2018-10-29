/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Robot;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class RobotDAO
/*    */   extends BaseHibernateDAO<Robot>
/*    */ {
/*    */   public PageModel<Robot> sqlRobot(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 17 */     String where = " where 1=1 ";
/* 18 */     for (int i = 0; i < param.length; i++) {
/* 19 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 20 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 21 */         if ("nickname".equals(param[i])) {
/* 22 */           where = where + " and " + param[i] + " like '%" + paramValue[i] + "%'";
/*    */         }
/* 24 */         else if ("status".equals(param[i])) {
/* 25 */           where = where + " and status = '" + paramValue[i] + "' ";
/*    */         }
/* 27 */         else if ("uid".equals(param[i])) {
/* 28 */           where = where + " and id = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 34 */     return robotList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<Robot> robotList(int currentPage, int pageSize, String where) {
/* 38 */     PageModel<Robot> pm = new PageModel();
/* 39 */     String sql = "select count(id) from Robot";
/* 40 */     if (where != null) {
/* 41 */       sql = sql + where;
/*    */     }
/* 43 */     pm.setPageSize(pageSize);
/* 44 */     pm.setSumCount(count(sql));
/* 45 */     pm.setCurrentPage(currentPage);
/*    */     
/* 47 */     String hql = "from Robot";
/* 48 */     if (where != null) {
/* 49 */       hql = hql + where + "order by createtime desc";
/*    */     }
/* 51 */     Query query = getSession().createQuery(hql);
/*    */     
/* 53 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 55 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 56 */     pm.setList(query.list());
/* 57 */     getSession().clear();
/* 58 */     getSession().close();
/* 59 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql) {
/* 63 */     Query query = getSession().createSQLQuery(sql);
/* 64 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public String findCount(String sql)
/*    */   {
/* 69 */     String count = "0";
/* 70 */     Session session = null;
/* 71 */     Transaction tx = null;
/*    */     try {
/* 73 */       session = getSession();
/* 74 */       tx = session.beginTransaction();
/* 75 */       Query query = session.createSQLQuery(sql);
/* 76 */       Object c = query.uniqueResult();
/* 77 */       count = c.toString();
/* 78 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 80 */       System.out.println("执行HQL查找对象出现错误！");
/* 81 */       ex.printStackTrace();
/* 82 */       if (tx != null) {
/* 83 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 86 */       if (session != null) {
/* 87 */         session.clear();
/* 88 */         session.close();
/*    */       }
/*    */     }
/* 91 */     return count;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\RobotDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */