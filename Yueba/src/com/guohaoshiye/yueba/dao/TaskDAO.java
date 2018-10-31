package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Task;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.PrintStream;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskDAO extends BaseHibernateDAO<Task>
{
  public PageModel<Task> pageList(int currentPage, int pageSize)
  {
    PageModel<Task> pm = new PageModel();
    String sql = "select count(id) from Task";
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    Query query = getSession().createQuery("from Task");

    query.setMaxResults(pm.getPageSize());

    query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
    pm.setList(query.list());
    getSession().clear();
    getSession().close();
    return pm;
  }

  public int count(String sql) { Query query = getSession().createQuery(sql);
    return ((Long)query.uniqueResult()).intValue();
  }

  public void saveTask(Task t) { Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      String sql = "INSERT INTO task(acceptid,completeid,reward,type,state,describe) VALUES(" + t.getAcceptid() + "," + t.getCompleteid() + "," + t.getReward() + "," + t.getType() + "," + t.getState() + ",'" + t.getDescribe() + "')";
      System.out.println(sql);
      session.createSQLQuery(sql).executeUpdate();
      tx.commit();
    } catch (Exception ex) {
      System.out.println("添加对象出现错误！");
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
  }
}

