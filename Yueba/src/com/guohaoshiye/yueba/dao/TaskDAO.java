/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Task;
/*    */ import com.aiwan.hibernate.BaseHibernateDAO;
/*    */ import com.aiwan.hibernate.PageModel;
/*    */ import java.io.PrintStream;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class TaskDAO extends BaseHibernateDAO<Task>
/*    */ {
/*    */   public PageModel<Task> pageList(int currentPage, int pageSize)
/*    */   {
/* 15 */     PageModel<Task> pm = new PageModel();
/* 16 */     String sql = "select count(id) from Task";
/* 17 */     pm.setPageSize(pageSize);
/* 18 */     pm.setSumCount(count(sql));
/* 19 */     pm.setCurrentPage(currentPage);
/* 20 */     Query query = getSession().createQuery("from Task");
/*    */     
/* 22 */     query.setMaxResults(pm.getPageSize());
/*    */     
/* 24 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/* 25 */     pm.setList(query.list());
/* 26 */     getSession().clear();
/* 27 */     getSession().close();
/* 28 */     return pm;
/*    */   }
/*    */   
/* 31 */   public int count(String sql) { Query query = getSession().createQuery(sql);
/* 32 */     return ((Long)query.uniqueResult()).intValue();
/*    */   }
/*    */   
/* 35 */   public void saveTask(Task t) { Session session = null;
/* 36 */     Transaction tx = null;
/*    */     try {
/* 38 */       session = getSession();
/* 39 */       tx = session.beginTransaction();
/* 40 */       String sql = "INSERT INTO task(acceptid,completeid,reward,type,state,describe) VALUES(" + t.getAcceptid() + "," + t.getCompleteid() + "," + t.getReward() + "," + t.getType() + "," + t.getState() + ",'" + t.getDescribe() + "')";
/* 41 */       System.out.println(sql);
/* 42 */       session.createSQLQuery(sql).executeUpdate();
/* 43 */       tx.commit();
/*    */     } catch (Exception ex) {
/* 45 */       System.out.println("添加对象出现错误！");
/* 46 */       ex.printStackTrace();
/* 47 */       if (tx != null) {
/* 48 */         tx.rollback();
/*    */       }
/*    */     } finally {
/* 51 */       if (session != null) {
/* 52 */         session.clear();
/* 53 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\TaskDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */