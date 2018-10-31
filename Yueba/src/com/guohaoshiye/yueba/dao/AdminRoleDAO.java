package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.AdminRole;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminRoleDAO extends BaseHibernateDAO<AdminRole>
{
  public void deleteRole(Integer id)
  {
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      Query query = session.createSQLQuery("delete from admin_role where aid=?");
      query.setParameter(0, id);
      query.executeUpdate();
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
  }
}

