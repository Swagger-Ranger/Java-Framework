/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Robotrecharge;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ 
/*    */ public class RobotrechargeDAO
/*    */   extends BaseHibernateDAO<Robotrecharge>
/*    */ {
/*    */   public PageModel<Robotrecharge> sqlRechargeLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 16 */     String where = " where 1=1 ";
/* 17 */     for (int i = 0; i < param.length; i++) {
/* 18 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 19 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 20 */         if ("rid".equals(param[i])) {
/* 21 */           where = where + " and rid = '" + paramValue[i] + "' ";
/* 22 */         } else if ("aid".equals(param[i])) {
/* 23 */           where = where + " and aid = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 29 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */ 
/*    */   private PageModel<Robotrecharge> logList(int currentPage, int pageSize, String where)
/*    */   {
/* 35 */     PageModel<Robotrecharge> pm = new PageModel();
/* 36 */     String sql = "select count(id) from robotrecharge";
/* 37 */     if (where != null) {
/* 38 */       sql = sql + where;
/*    */     }
/* 40 */     pm.setPageSize(pageSize);
/* 41 */     pm.setSumCount(count(sql));
/* 42 */     pm.setCurrentPage(currentPage);
/* 43 */     String hql = "from Robotrecharge";
/* 44 */     if (where != null) {
/* 45 */       hql = hql + where + "order by time desc";
/*    */     }
/* 47 */     Query query = getSession().createQuery(hql);
/*    */     
/* 49 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 51 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 52 */     pm.setList(query.list());
/* 53 */     getSession().clear();
/* 54 */     getSession().close();
/* 55 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 60 */     Query query = getSession().createSQLQuery(sql);
/* 61 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\RobotrechargeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */