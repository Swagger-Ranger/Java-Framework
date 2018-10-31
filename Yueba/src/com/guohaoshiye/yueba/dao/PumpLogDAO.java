 package com.guohaoshiye.yueba.dao;

 import com.guohaoshiye.yueba.entity.PumpLog;
 import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
 import com.guohaoshiye.yueba.hibernate.PageModel;
 import java.io.PrintStream;
 import java.math.BigInteger;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.Transaction;

 public class PumpLogDAO
   extends BaseHibernateDAO<PumpLog>
 {
   public PageModel<PumpLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
   {
     String where = " where 1=1 ";
     for (int i = 0; i < param.length; i++) {
       if ((paramValue[i] != null) && (paramValue[i] != "") &&
         (paramValue[i] != null) && (paramValue[i] != "")) {
         if ("uid".equals(param[i])) {
           where = where + " and uid = '" + paramValue[i] + "' ";
         }
         else if ("tableid".equals(param[i])) {
           where = where + " and tableid = '" + paramValue[i] + "' ";
         } else if ("tabletype".equals(param[i])) {
           where = where + " and tabletype = '" + paramValue[i] + "' ";
         } else if ("gamechang".equals(param[i])) {
           where = where + " and gamechang = '" + paramValue[i] + "' ";
         }
       }
     }


     where = where + " and tabletype!=10 and tabletype!=11 ";
     return logList(currentPage, pageSize, where);
   }

   public PageModel<PumpLog> sqlLog2(int currentPage, int pageSize, String[] param, String[] paramValue) {
     String where = " where 1=1 ";
     for (int i = 0; i < param.length; i++) {
       if ((paramValue[i] != null) && (paramValue[i] != "") &&
         (paramValue[i] != null) && (paramValue[i] != "")) {
         if ("uid".equals(param[i])) {
           where = where + " and uid = '" + paramValue[i] + "' ";
         }
         else if ("tableid".equals(param[i])) {
           where = where + " and tableid = '" + paramValue[i] + "' ";
         } else if ("tabletype".equals(param[i])) {
           where = where + " and tabletype = '" + paramValue[i] + "' ";
         } else if ("gamechang".equals(param[i])) {
           where = where + " and gamechang = '" + paramValue[i] + "' ";
         }
       }
     }


     where = where + " and tabletype=10 or tabletype=11";
     return logList(currentPage, pageSize, where);
   }

   private PageModel<PumpLog> logList(int currentPage, int pageSize, String where)
   {
     PageModel<PumpLog> pm = new PageModel();
     String sql = "select count(id) from pump_log";
     if (where != null) {
       sql = sql + where;
     }
     pm.setPageSize(pageSize);
     pm.setSumCount(count(sql));
     pm.setCurrentPage(currentPage);

     String hql = "from PumpLog";
     if (where != null) {
       hql = hql + where + "order by createtime desc";
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

   public String showYingli(String sql, Integer id) {
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
 }

