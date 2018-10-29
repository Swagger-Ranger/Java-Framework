/*     */ package com.aiwan.dao;
/*     */ 
/*     */ import com.aiwan.entity.PumpLog;
/*     */ import com.aiwan.hibernate.BaseHibernateDAO;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class PumpLogDAO
/*     */   extends BaseHibernateDAO<PumpLog>
/*     */ {
/*     */   public PageModel<PumpLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*     */   {
/*  17 */     String where = " where 1=1 ";
/*  18 */     for (int i = 0; i < param.length; i++) {
/*  19 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  20 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  21 */         if ("uid".equals(param[i])) {
/*  22 */           where = where + " and uid = '" + paramValue[i] + "' ";
/*     */         }
/*  24 */         else if ("tableid".equals(param[i])) {
/*  25 */           where = where + " and tableid = '" + paramValue[i] + "' ";
/*  26 */         } else if ("tabletype".equals(param[i])) {
/*  27 */           where = where + " and tabletype = '" + paramValue[i] + "' ";
/*  28 */         } else if ("gamechang".equals(param[i])) {
/*  29 */           where = where + " and gamechang = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  35 */     where = where + " and tabletype!=10 and tabletype!=11 ";
/*  36 */     return logList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   public PageModel<PumpLog> sqlLog2(int currentPage, int pageSize, String[] param, String[] paramValue) {
/*  40 */     String where = " where 1=1 ";
/*  41 */     for (int i = 0; i < param.length; i++) {
/*  42 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  43 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  44 */         if ("uid".equals(param[i])) {
/*  45 */           where = where + " and uid = '" + paramValue[i] + "' ";
/*     */         }
/*  47 */         else if ("tableid".equals(param[i])) {
/*  48 */           where = where + " and tableid = '" + paramValue[i] + "' ";
/*  49 */         } else if ("tabletype".equals(param[i])) {
/*  50 */           where = where + " and tabletype = '" + paramValue[i] + "' ";
/*  51 */         } else if ("gamechang".equals(param[i])) {
/*  52 */           where = where + " and gamechang = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  58 */     where = where + " and tabletype=10 or tabletype=11";
/*  59 */     return logList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   private PageModel<PumpLog> logList(int currentPage, int pageSize, String where)
/*     */   {
/*  64 */     PageModel<PumpLog> pm = new PageModel();
/*  65 */     String sql = "select count(id) from pump_log";
/*  66 */     if (where != null) {
/*  67 */       sql = sql + where;
/*     */     }
/*  69 */     pm.setPageSize(pageSize);
/*  70 */     pm.setSumCount(count(sql));
/*  71 */     pm.setCurrentPage(currentPage);
/*     */     
/*  73 */     String hql = "from PumpLog";
/*  74 */     if (where != null) {
/*  75 */       hql = hql + where + "order by createtime desc";
/*     */     }
/*  77 */     Query query = getSession().createQuery(hql);
/*     */     
/*  79 */     query.setMaxResults(pm.getPageSize());
/*     */     
/*  81 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/*  82 */     pm.setList(query.list());
/*  83 */     getSession().clear();
/*  84 */     getSession().close();
/*  85 */     return pm;
/*     */   }
/*     */   
/*     */ 
/*     */   public int count(String sql)
/*     */   {
/*  91 */     Query query = getSession().createSQLQuery(sql);
/*  92 */     return ((BigInteger)query.uniqueResult()).intValue();
/*     */   }
/*     */   
/*     */   public String findSqlSum(String sql) {
/*  96 */     String count = "0";
/*  97 */     Session session = null;
/*  98 */     Transaction tx = null;
/*     */     try {
/* 100 */       session = getSession();
/* 101 */       tx = session.beginTransaction();
/* 102 */       Query query = session.createSQLQuery(sql);
/* 103 */       Object c = query.uniqueResult();
/* 104 */       count = c.toString();
/* 105 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 107 */       System.out.println("执行HQL查找对象出现错误！");
/* 108 */       ex.printStackTrace();
/* 109 */       if (tx != null) {
/* 110 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 113 */       if (session != null) {
/* 114 */         session.clear();
/* 115 */         session.close();
/*     */       }
/*     */     }
/* 118 */     return count;
/*     */   }
/*     */   
/*     */   public String showYingli(String sql, Integer id) {
/* 122 */     String sum = "0";
/* 123 */     Session session = null;
/* 124 */     Transaction tx = null;
/*     */     try {
/* 126 */       session = getSession();
/* 127 */       tx = session.beginTransaction();
/* 128 */       Query query = session.createSQLQuery(sql);
/* 129 */       query.setParameter(0, id);
/*     */       
/* 131 */       Object c = query.uniqueResult();
/* 132 */       sum = c.toString();
/* 133 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 135 */       System.out.println("执行HQL查找对象出现错误！");
/* 136 */       ex.printStackTrace();
/* 137 */       if (tx != null) {
/* 138 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 141 */       if (session != null) {
/* 142 */         session.clear();
/* 143 */         session.close();
/*     */       }
/*     */     }
/* 146 */     return sum;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\PumpLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */