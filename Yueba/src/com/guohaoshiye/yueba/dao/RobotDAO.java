package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Robot;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.PrintStream;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RobotDAO
  extends BaseHibernateDAO<Robot>
{
  public PageModel<Robot> sqlRobot(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("nickname".equals(param[i])) {
          where = where + " and " + param[i] + " like '%" + paramValue[i] + "%'";
        }
        else if ("status".equals(param[i])) {
          where = where + " and status = '" + paramValue[i] + "' ";
        }
        else if ("uid".equals(param[i])) {
          where = where + " and id = '" + paramValue[i] + "' ";
        }
      }
    }


    return robotList(currentPage, pageSize, where);
  }

  private PageModel<Robot> robotList(int currentPage, int pageSize, String where) {
    PageModel<Robot> pm = new PageModel();
    String sql = "select count(id) from Robot";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from Robot";
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

  public int count(String sql) {
    Query query = getSession().createSQLQuery(sql);
    return ((BigInteger)query.uniqueResult()).intValue();
  }

  public String findCount(String sql)
  {
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

