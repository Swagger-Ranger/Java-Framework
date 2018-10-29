/*     */ package com.aiwan.dao;
/*     */ 
/*     */ import com.aiwan.entity.TixianLog;
/*     */ import com.aiwan.hibernate.BaseHibernateDAO;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ public class TixianLogDAO
/*     */   extends BaseHibernateDAO<TixianLog>
/*     */ {
/*     */   public PageModel<TixianLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*     */   {
/*  18 */     String where = " where 1=1 ";
/*  19 */     for (int i = 0; i < param.length; i++) {
/*  20 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  21 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  22 */         if ("pid".equals(param[i])) {
/*  23 */           where = where + " and pid = '" + paramValue[i] + "' ";
/*     */         }
/*  25 */         else if ("begin".equals(param[i])) {
/*  26 */           where = where + " and createTime >= '" + paramValue[i] + "' ";
/*  27 */         } else if ("end".equals(param[i])) {
/*  28 */           where = where + " and createTime <= '" + paramValue[i] + "' ";
/*  29 */         } else if ("content".equals(param[i])) {
/*  30 */           where = where + " and content = '" + paramValue[i] + "' ";
/*     */         }
/*  32 */         else if ("txhz".equals(param[i])) {
/*  33 */           where = where + " and txhz = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  40 */     where = where + " and status=2 ";
/*  41 */     return logList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   private PageModel<TixianLog> logList(int currentPage, int pageSize, String where) {
/*  45 */     PageModel<TixianLog> pm = new PageModel();
/*  46 */     String sql = "select count(id) from tixian_log";
/*  47 */     if (where != null) {
/*  48 */       sql = sql + where;
/*     */     }
/*  50 */     pm.setPageSize(pageSize);
/*  51 */     pm.setSumCount(count(sql));
/*  52 */     pm.setCurrentPage(currentPage);
/*     */     
/*  54 */     String hql = "from TixianLog";
/*  55 */     if (where != null) {
/*  56 */       hql = hql + where + "order by createTime desc";
/*     */     }
/*  58 */     Query query = getSession().createQuery(hql);
/*     */     
/*  60 */     query.setMaxResults(pm.getPageSize());
/*     */     
/*  62 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/*  63 */     pm.setList(query.list());
/*  64 */     getSession().clear();
/*  65 */     getSession().close();
/*  66 */     return pm;
/*     */   }
/*     */   
/*     */   public int count(String sql)
/*     */   {
/*  71 */     Query query = getSession().createSQLQuery(sql);
/*  72 */     return ((BigInteger)query.uniqueResult()).intValue();
/*     */   }
/*     */   
/*     */   public PageModel<TixianLog> sqlLoglist(int currentPage, int pageSize, String[] param, String[] paramValue)
/*     */   {
/*  77 */     String where = " where 1=1 ";
/*  78 */     for (int i = 0; i < param.length; i++) {
/*  79 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  80 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  81 */         if ("pid".equals(param[i])) {
/*  82 */           where = where + " and pid = '" + paramValue[i] + "' ";
/*     */         }
/*  84 */         else if ("begin".equals(param[i])) {
/*  85 */           where = where + " and createTime >= '" + paramValue[i] + "' ";
/*  86 */         } else if ("end".equals(param[i])) {
/*  87 */           where = where + " and createTime <= '" + paramValue[i] + "' ";
/*  88 */         } else if ("aid".equals(param[i])) {
/*  89 */           where = where + " and auditPeople = '" + paramValue[i] + "' ";
/*  90 */         } else if ("status".equals(param[i])) {
/*  91 */           where = where + " and status = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  98 */     where = where + " and status!=2 ";
/*  99 */     return logList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   public String showTiXianSum(String sql, Integer id) {
/* 103 */     String sum = "0";
/* 104 */     Session session = null;
/* 105 */     Transaction tx = null;
/*     */     try {
/* 107 */       session = getSession();
/* 108 */       tx = session.beginTransaction();
/* 109 */       Query query = session.createSQLQuery(sql);
/* 110 */       query.setParameter(0, id);
/*     */       
/* 112 */       Object c = query.uniqueResult();
/* 113 */       sum = c.toString();
/* 114 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 116 */       System.out.println("执行HQL查找对象出现错误！");
/* 117 */       ex.printStackTrace();
/* 118 */       if (tx != null) {
/* 119 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 122 */       if (session != null) {
/* 123 */         session.clear();
/* 124 */         session.close();
/*     */       }
/*     */     }
/* 127 */     return sum;
/*     */   }
/*     */   
/*     */   public String findSqlSum(String sql) {
/* 131 */     String count = "0";
/* 132 */     Session session = null;
/* 133 */     Transaction tx = null;
/*     */     try {
/* 135 */       session = getSession();
/* 136 */       tx = session.beginTransaction();
/* 137 */       Query query = session.createSQLQuery(sql);
/* 138 */       Object c = query.uniqueResult();
/* 139 */       count = c.toString();
/* 140 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 142 */       System.out.println("执行HQL查找对象出现错误！");
/* 143 */       ex.printStackTrace();
/* 144 */       if (tx != null) {
/* 145 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 148 */       if (session != null) {
/* 149 */         session.clear();
/* 150 */         session.close();
/*     */       }
/*     */     }
/* 153 */     return count;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\TixianLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */