 package com.guohaoshiye.yueba.dao;

 import com.guohaoshiye.yueba.entity_olddemo.Users;
 import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
 import com.guohaoshiye.yueba.hibernate.PageModel;

 import java.math.BigInteger;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import net.sf.json.JSONArray;
 import org.hibernate.Query;
 import org.hibernate.Session;
 import org.hibernate.Transaction;


 public class UsersDAO
   extends BaseHibernateDAO<Users>
 {
   public PageModel<Users> sqlUsers(int currentPage, int pageSize, String[] param, String[] paramValue)
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
         } else if ("pid".equals(param[i])) {
           where = where + " and pid = '" + paramValue[i] + "' ";
         } else if ("realName".equals(param[i])) {
           where = where + " and realName = '" + paramValue[i] + "' ";
         }
       }
     }


     return userList(currentPage, pageSize, where);
   }

   public PageModel<Users> userList(int currentPage, int pageSize, String where) {
     PageModel<Users> pm = new PageModel();
     String sql = "select count(id) from Users";
     if (where != null) {
       sql = sql + where;
     }
     pm.setPageSize(pageSize);
     pm.setSumCount(count(sql));
     pm.setCurrentPage(currentPage);

     String hql = "from Users";
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

   public String findByUidTime(Integer id) {
     String count = "0";
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("select IFNULL(SUM(IFNULL(TIMESTAMPDIFF(SECOND,logintime,signout),0)),0) AS tim from login_log where uid = ?");
       query.setParameter(0, id);
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

   public String findByLoginCount(Integer id) {
     String count = "0";
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("select COUNT(id) AS logincount from login_log where uid = ?");
       query.setParameter(0, id);
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

   public String findAllgoldtrue(String sql) {
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

   public void updatePid(int id) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("update users set pid = 0 where pid = " + id);
       int update = query.executeUpdate();
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

   public Map<Integer, String> findGameCount(String sql) {
     Map<Integer, String> map = new HashMap();
     map.put(Integer.valueOf(1), "0");
     map.put(Integer.valueOf(2), "0");
     map.put(Integer.valueOf(3), "0");
     map.put(Integer.valueOf(4), "0");
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery(sql);
       List list = query.list();
       if (list.size() > 0) {
         for (Object object : list) {
           JSONArray json = JSONArray.fromObject(object);
           if (((Integer)json.get(0)).intValue() == 1) {
             map.put(Integer.valueOf(1), json.get(1).toString());
           }
           if (((Integer)json.get(0)).intValue() == 2) {
             map.put(Integer.valueOf(2), json.get(1).toString());
           }
           if (((Integer)json.get(0)).intValue() == 3) {
             map.put(Integer.valueOf(3), json.get(1).toString());
           }
           if (((Integer)json.get(0)).intValue() == 4) {
             map.put(Integer.valueOf(4), json.get(1).toString());
           }
         }
       }

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
     return map;
   }
 }

