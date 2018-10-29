/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.ProxytoexamineLog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProxytoexamineLogDAO
/*    */   extends BaseHibernateDAO<ProxytoexamineLog>
/*    */ {
/*    */   private PageModel<ProxytoexamineLog> logList(int currentPage, int pageSize, String where)
/*    */   {
/* 37 */     PageModel<ProxytoexamineLog> pm = new PageModel();
/* 38 */     String sql = "select count(id) from proxytoexamine_log";
/* 39 */     if (where != null) {
/* 40 */       sql = sql + where;
/*    */     }
/* 42 */     pm.setPageSize(pageSize);
/* 43 */     pm.setSumCount(count(sql));
/* 44 */     pm.setCurrentPage(currentPage);
/*    */     
/* 46 */     String hql = "from ProxytoexamineLog";
/* 47 */     if (where != null) {
/* 48 */       hql = hql + where + "order by creatrtime desc";
/*    */     }
/* 50 */     Query query = getSession().createQuery(hql);
/*    */     
/* 52 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 54 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 55 */     pm.setList(query.list());
/* 56 */     getSession().clear();
/* 57 */     getSession().close();
/* 58 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql)
/*    */   {
/* 63 */     Query query = getSession().createSQLQuery(sql);
/* 64 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public PageModel<ProxytoexamineLog> sqlLoglist(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 69 */     String where = " where 1=1 ";
/* 70 */     for (int i = 0; i < param.length; i++) {
/* 71 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 72 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 73 */         if ("uid".equals(param[i])) {
/* 74 */           where = where + " and uid = '" + paramValue[i] + "' ";
/*    */         }
/* 76 */         else if ("begin".equals(param[i])) {
/* 77 */           where = where + " and creatrtime >= '" + paramValue[i] + "' ";
/* 78 */         } else if ("end".equals(param[i])) {
/* 79 */           where = where + " and creatrtime <= '" + paramValue[i] + "' ";
/* 80 */         } else if ("pid".equals(param[i])) {
/* 81 */           where = where + " and pid = '" + paramValue[i] + "' ";
/* 82 */         } else if ("phone".equals(param[i])) {
/* 83 */           where = where + " and phone = '" + paramValue[i] + "' ";
/* 84 */         } else if ("weixinhao".equals(param[i])) {
/* 85 */           where = where + " and weixinhao = '" + paramValue[i] + "' ";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 92 */     where = where + " and state!=0 ";
/* 93 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\ProxytoexamineLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */