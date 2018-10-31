package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.SystemLog;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SystemLogDAO
  extends BaseHibernateDAO<SystemLog>
{
  public List<SystemLog> findlist()
  {
    List<SystemLog> list = null;
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();

      Query query = session.createQuery("from SystemLog order by createTime desc");
      query.setFirstResult(0);
      query.setMaxResults(5);
      list = query.list();
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
    return list;
  }

  public PageModel<SystemLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("aid".equals(param[i])) {
          where = where + " and aid = '" + paramValue[i] + "' ";
        }
        else if ("begin".equals(param[i])) {
          where = where + " and createTime >= '" + paramValue[i] + "' ";
        } else if ("end".equals(param[i])) {
          where = where + " and createTime <= '" + paramValue[i] + "' ";
        } else if ("operating".equals(param[i])) {
          where = where + " and operating = '" + paramValue[i] + "' ";
        }
      }
    }



    return logList(currentPage, pageSize, where);
  }


  private PageModel<SystemLog> logList(int currentPage, int pageSize, String where)
  {
    PageModel<SystemLog> pm = new PageModel();
    String sql = "select count(id) from system_log";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from SystemLog";
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
}

