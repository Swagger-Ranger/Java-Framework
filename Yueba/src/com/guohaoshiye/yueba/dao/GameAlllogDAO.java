/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.GameAlllog;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ public class GameAlllogDAO
/*    */   extends BaseHibernateDAO<GameAlllog>
/*    */ {
/*    */   public PageModel<GameAlllog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
/*    */   {
/* 18 */     String where = " where 1=1 ";
/* 19 */     for (int i = 0; i < param.length; i++) {
/* 20 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/* 21 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/* 22 */         if ("roomNumber".equals(param[i])) {
/* 23 */           where = where + " and roomNumber = '" + paramValue[i] + "' ";
/*    */         }
/* 25 */         else if ("playtype".equals(param[i])) {
/* 26 */           where = where + " and playtype = '" + paramValue[i] + "' ";
/* 27 */         } else if ("gamechang".equals(param[i])) {
/* 28 */           where = where + " and gamechang = '" + paramValue[i] + "' ";
/* 29 */         } else if ("begin".equals(param[i])) {
/* 30 */           where = where + " and creattime >= '" + paramValue[i] + "' ";
/* 31 */         } else if ("end".equals(param[i])) {
/* 32 */           where = where + " and creattime <= '" + paramValue[i] + "' ";
/* 33 */         } else if ("uid".equals(param[i])) {
/* 34 */           where = where + " and alluserid like '%" + paramValue[i] + "%'";
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 41 */     return logList(currentPage, pageSize, where);
/*    */   }
/*    */   
/*    */   private PageModel<GameAlllog> logList(int currentPage, int pageSize, String where) {
/* 45 */     PageModel<GameAlllog> pm = new PageModel();
/* 46 */     String sql = "select count(id) from game_alllog";
/* 47 */     if (where != null) {
/* 48 */       sql = sql + where;
/*    */     }
/* 50 */     pm.setPageSize(pageSize);
/* 51 */     pm.setSumCount(count(sql));
/* 52 */     pm.setCurrentPage(currentPage);
/*    */     
/* 54 */     String hql = "from GameAlllog";
/* 55 */     if (where != null) {
/* 56 */       hql = hql + where + "order by creattime desc";
/*    */     }
/* 58 */     Query query = getSession().createQuery(hql);
/*    */     
/* 60 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 62 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 63 */     pm.setList(query.list());
/* 64 */     getSession().clear();
/* 65 */     getSession().close();
/* 66 */     return pm;
/*    */   }
/*    */   
/*    */   public int count(String sql) {
/* 70 */     Query query = getSession().createSQLQuery(sql);
/* 71 */     return ((BigInteger)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/*    */   public Integer deleteLog(String begin, String end) {
/* 75 */     Session session = null;
/* 76 */     Transaction tx = null;
/* 77 */     Integer index = Integer.valueOf(0);
/* 78 */     String hql = "delete from GameAlllog where creattime >= '" + begin + "' and creattime <= '" + end + "' ";
/*    */     try
/*    */     {
/* 81 */       session = getSession();
/* 82 */       tx = session.beginTransaction();
/* 83 */       index = Integer.valueOf(session.createQuery(hql)
/* 84 */         .executeUpdate());
/* 85 */       tx.commit();
/*    */     } catch (Exception e) {
/* 87 */       System.out.println("日志删除出现错误！");
/* 88 */       e.printStackTrace();
/* 89 */       if (tx != null) {
/* 90 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 93 */       if (session != null) {
/* 94 */         session.clear();
/* 95 */         session.close();
/*    */       }
/*    */     }
/* 98 */     return index;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\GameAlllogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */