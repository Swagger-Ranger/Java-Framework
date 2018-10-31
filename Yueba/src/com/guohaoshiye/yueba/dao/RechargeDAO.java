package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Recharge;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.PrintStream;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RechargeDAO
  extends BaseHibernateDAO<Recharge>
{
  public PageModel<Recharge> sqlRechargeLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("userId".equals(param[i])) {
          where = where + " and userId = '" + paramValue[i] + "' ";
        } else if ("status".equals(param[i])) {
          where = where + " and status = '" + paramValue[i] + "' ";
        } else if ("order".equals(param[i])) {
          where = where + " and `order` = '" + paramValue[i] + "' ";
        } else if ("begin".equals(param[i])) {
          where = where + " and createtime >= '" + paramValue[i] + "' ";
        } else if ("end".equals(param[i])) {
          where = where + " and createtime <= '" + paramValue[i] + "' ";
        } else if ("gold".equals(param[i])) {
          where = where + " and gold = '" + paramValue[i] + "' ";
        }
      }
    }


    where = where + " and status!=-1 ";
    return logList(currentPage, pageSize, where);
  }

  private PageModel<Recharge> logList(int currentPage, int pageSize, String where) {
    PageModel<Recharge> pm = new PageModel();
    String sql = "select count(id) from recharge";
    if (where != null) {
      sql = sql + where;
    }
    System.out.println(sql);
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    where = where.replace("`", "");
    String hql = "from Recharge";
    if (where != null) {
      hql = hql + where + "order by createtime desc";
    }
    System.out.println(hql);
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

