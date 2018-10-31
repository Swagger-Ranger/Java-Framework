package com.guohaoshiye.yueba.hibernate;

import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;





public class BaseHibernateDAO<T>
  implements IBaseHibernateDAO<T>
{
  private Class<T> clazz;

  public BaseHibernateDAO()
  {
    ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
    this.clazz = ((Class)type.getActualTypeArguments()[0]);
  }


  public Session getSession()
  {
    return HibernateSessionFactory.getSession();
  }

  public void save(Object entity)
  {
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      session.save(entity);
      tx.commit();
    } catch (Exception ex) {
      System.out.println("保存对象出现错误！");
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


  public void update(Object entity)
  {
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      session.update(entity);
      tx.commit();
    } catch (Exception ex) {
      System.out.println("更新对象出现错误！");
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

  public void partUpdate(int id, String[] names, Object[] values)
  {
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();

      String tab = this.clazz.getSimpleName();
      String hql = "update " + tab + " t";
      for (int i = 0; i < names.length; i++) {
        hql = hql + " set t." + names[i] + "=?";
      }
      hql = hql + " where t.id=" + id;
      Query query = session.createQuery(hql);
      for (int i = 0; i < values.length; i++) {
        query.setParameter(i, values[i]);
      }
      System.out.println("部分更新：" + hql);
      query.executeUpdate();
      tx.commit();
    } catch (Exception ex) {
      System.out.println("更新对象部分属性出现错误！");
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


  public void delete(Serializable id)
  {
    T obj = findById(id);
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      session.delete(obj);
      tx.commit();
    } catch (Exception ex) {
      System.out.println("删除对象出现错误！");
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


  public T findById(Serializable id)
  {
    Session session = null;
    Transaction tx = null;
    T obj = null;
    try {
      session = getSession();
      tx = session.beginTransaction();
      obj = session.get(this.clazz, id);
      tx.commit();
    } catch (Exception ex) {
      System.out.println("查找对象出现错误！");
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
    return obj;
  }

  public List<T> findByHQL(String hql, Object... params)
  {
    List<T> list = null;
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();

      Query query = session.createQuery(hql);
      for (int i = 0; (params != null) && (i < params.length); i++) {
        query.setParameter(i, params[i]);
      }

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


  public List<T> queryPage(String hql, int pageNo, int pageSize)
  {
    List<T> list = null;
    Session session = null;
    Transaction tx = null;
    try {
      session = getSession();
      tx = session.beginTransaction();

      Query query = session.createQuery(hql);


      list = query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();

      tx.commit();
    } catch (Exception ex) {
      System.out.println("分页查询出现错误出现错误！");
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
}

