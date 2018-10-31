package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.AdminRechargeLog;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.PrintStream;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AdminRechargeLogDAO
  extends BaseHibernateDAO<AdminRechargeLog>
{
  public PageModel<AdminRechargeLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("uid".equals(param[i])) {
          where = where + " and uid = '" + paramValue[i] + "' ";
        }
        else if ("aid".equals(param[i])) {
          where = where + " and aid = '" + paramValue[i] + "' ";
        } else if ("rtype".equals(param[i])) {
          where = where + " and rtype = '" + paramValue[i] + "' ";
        } else if ("money".equals(param[i])) {
          where = where + " and money = '" + paramValue[i] + "' ";
        } else if ("begin".equals(param[i])) {
          where = where + " and createTime >= '" + paramValue[i] + "' ";
        } else if ("end".equals(param[i])) {
          where = where + " and createTime <= '" + paramValue[i] + "' ";
        }
      }
    }


    return logList(currentPage, pageSize, where);
  }

  private PageModel<AdminRechargeLog> logList(int currentPage, int pageSize, String where) {
    PageModel<AdminRechargeLog> pm = new PageModel();
    String sql = "select count(id) from admin_recharge_log";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from AdminRechargeLog";
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

