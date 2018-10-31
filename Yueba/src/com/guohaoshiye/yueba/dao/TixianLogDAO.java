 package com.guohaoshiye.yueba.dao;

 import com.guohaoshiye.yueba.entity.TixianLog;
 import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
 import com.guohaoshiye.yueba.hibernate.PageModel;
 import java.io.PrintStream;
 import java.math.BigInteger;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.Transaction;


 public class TixianLogDAO
   extends BaseHibernateDAO<TixianLog>
 {
   public PageModel<TixianLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
   {
     String where = " where 1=1 ";
     for (int i = 0; i < param.length; i++) {
       if ((paramValue[i] != null) && (paramValue[i] != "") &&
         (paramValue[i] != null) && (paramValue[i] != "")) {
         if ("pid".equals(param[i])) {
           where = where + " and pid = '" + paramValue[i] + "' ";
         }
         else if ("begin".equals(param[i])) {
           where = where + " and createTime >= '" + paramValue[i] + "' ";
         } else if ("end".equals(param[i])) {
           where = where + " and createTime <= '" + paramValue[i] + "' ";
         } else if ("content".equals(param[i])) {
           where = where + " and content = '" + paramValue[i] + "' ";
         }
         else if ("txhz".equals(param[i])) {
           where = where + " and txhz = '" + paramValue[i] + "' ";
         }
       }
     }



     where = where + " and status=2 ";
     return logList(currentPage, pageSize, where);
   }

   private PageModel<TixianLog> logList(int currentPage, int pageSize, String where) {
     PageModel<TixianLog> pm = new PageModel();
     String sql = "select count(id) from tixian_log";
     if (where != null) {
       sql = sql + where;
     }
     pm.setPageSize(pageSize);
     pm.setSumCount(count(sql));
     pm.setCurrentPage(currentPage);

     String hql = "from TixianLog";
     if (where != null) {
       hql = hql + where + "order by createTime desc";
     }
     Query query = getSession().createQuery(hql);

     query.setMaxResults(pm.getPageSize());

     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
     pm.setList(query.list());
     getSession().clear();
     getSession().close();
     return pm;
   }

   public int count(String sql)
   {
     Query query = getSession().createSQLQuery(sql);
     return ((BigInteger)query.uniqueResult()).intValue();
   }

   public PageModel<TixianLog> sqlLoglist(int currentPage, int pageSize, String[] param, String[] paramValue)
   {
     String where = " where 1=1 ";
     for (int i = 0; i < param.length; i++) {
       if ((paramValue[i] != null) && (paramValue[i] != "") &&
         (paramValue[i] != null) && (paramValue[i] != "")) {
         if ("pid".equals(param[i])) {
           where = where + " and pid = '" + paramValue[i] + "' ";
         }
         else if ("begin".equals(param[i])) {
           where = where + " and createTime >= '" + paramValue[i] + "' ";
         } else if ("end".equals(param[i])) {
           where = where + " and createTime <= '" + paramValue[i] + "' ";
         } else if ("aid".equals(param[i])) {
           where = where + " and auditPeople = '" + paramValue[i] + "' ";
         } else if ("status".equals(param[i])) {
           where = where + " and status = '" + paramValue[i] + "' ";
         }
       }
     }



     where = where + " and status!=2 ";
     return logList(currentPage, pageSize, where);
   }

   public String showTiXianSum(String sql, Integer id) {
     String sum = "0";
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery(sql);
       query.setParameter(0, id);

       Object c = query.uniqueResult();
       sum = c.toString();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("执行HQL查找对象出现错误！");
       ex.printStackTrace();
       if (tx != null) {
         tx.rollback();
       }
     } finally {
       if (session != null) {
         session.clear();
         session.close();
       }
     }
     return sum;
   }

   public String findSqlSum(String sql) {
     String count = "0";
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery(sql);
       Object c = query.uniqueResult();
       count = c.toString();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("执行HQL查找对象出现错误！");
       ex.printStackTrace();
       if (tx != null) {
         tx.rollback();
       }
     } finally {
       if (session != null) {
         session.clear();
         session.close();
       }
     }
     return count;
   }
 }

