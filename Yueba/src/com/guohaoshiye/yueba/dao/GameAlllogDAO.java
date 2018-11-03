package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity_olddemo.GameAlllog;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;

import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class GameAlllogDAO
  extends BaseHibernateDAO<GameAlllog>
{
  public PageModel<GameAlllog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("roomNumber".equals(param[i])) {
          where = where + " and roomNumber = '" + paramValue[i] + "' ";
        }
        else if ("playtype".equals(param[i])) {
          where = where + " and playtype = '" + paramValue[i] + "' ";
        } else if ("gamechang".equals(param[i])) {
          where = where + " and gamechang = '" + paramValue[i] + "' ";
        } else if ("begin".equals(param[i])) {
          where = where + " and creattime >= '" + paramValue[i] + "' ";
        } else if ("end".equals(param[i])) {
          where = where + " and creattime <= '" + paramValue[i] + "' ";
        } else if ("uid".equals(param[i])) {
          where = where + " and alluserid like '%" + paramValue[i] + "%'";
        }
      }
    }



    return logList(currentPage, pageSize, where);
  }

  private PageModel<GameAlllog> logList(int currentPage, int pageSize, String where) {
    PageModel<GameAlllog> pm = new PageModel();
    String sql = "select count(id) from game_alllog";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from GameAlllog";
    if (where != null) {
      hql = hql + where + "order by creattime desc";
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

  public Integer deleteLog(String begin, String end) {
    Session session = null;
    Transaction tx = null;
    Integer index = Integer.valueOf(0);
    String hql = "delete from GameAlllog where creattime >= '" + begin + "' and creattime <= '" + end + "' ";
    try
    {
      session = getSession();
      tx = session.beginTransaction();
      index = Integer.valueOf(session.createQuery(hql)
        .executeUpdate());
      tx.commit();
    } catch (Exception e) {
      System.out.println("日志删除出现错误！");
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();
      }
    } finally {
      if (session != null) {
        session.clear();
        session.close();
      }
    }
    return index;
  }
}

