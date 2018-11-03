 package com.guohaoshiye.yueba.dao;

 import com.guohaoshiye.yueba.entity_olddemo.Proxy;
 import com.guohaoshiye.yueba.entity_olddemo.Proxy_num;
 import com.guohaoshiye.yueba.entity_olddemo.Users;
 import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
 import com.guohaoshiye.yueba.hibernate.PageModel;

 import java.math.BigInteger;
 import java.util.ArrayList;
 import java.util.List;
 import org.hibernate.Query;
 import org.hibernate.SQLQuery;
 import org.hibernate.Session;
 import org.hibernate.Transaction;

 public class ProxyDAO extends BaseHibernateDAO<Proxy>
 {
   public PageModel<Proxy> sqlProxy(int currentPage, int pageSize, String[] param, String[] paramValue)
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
         else if ("pid".equals(param[i])) {
           where = where + " and id = '" + paramValue[i] + "' ";
         }
         else if ("kg".equals(param[i])) {
           where = where + " and kg = '" + paramValue[i] + "' ";
         }
         else if ("ppid".equals(param[i])) {
           where = where + " and pid = '" + paramValue[i] + "' ";
         }
         else if ("phone".equals(param[i])) {
           where = where + " and phone = '" + paramValue[i] + "' ";
         }
         else if ("trueName".equals(param[i])) {
           where = where + " and trueName = '" + paramValue[i] + "' ";
         }
         else if ("contactWay".equals(param[i])) {
           where = where + " and contactWay = '" + paramValue[i] + "' ";
         }
         else if ("isDisable".equals(param[i])) {
           where = where + " and isDisable = '" + paramValue[i] + "' ";
         }
       }
     }



     return proxyList(currentPage, pageSize, where);
   }

   private PageModel<Proxy> proxyList(int currentPage, int pageSize, String where)
   {
     PageModel<Proxy> pm = new PageModel();
     String sql = "select count(id) from proxy";
     if (where != null) {
       sql = sql + where;
     }
     pm.setPageSize(pageSize);
     pm.setSumCount(count(sql));
     pm.setCurrentPage(currentPage);

     String hql = "from Proxy";
     if (where != null) {
       hql = hql + where + "order by status desc";
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

   public List<Proxy> sqlHeProxy(int pid) {
     Session session = null;
     Transaction tx = null;
     List<Proxy> obj = new ArrayList();
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("select p.* from proxy p where FIND_IN_SET(id, getChildLstProxy(" + pid + "))");
       ((SQLQuery)query).addEntity("p", Proxy.class);
       obj = query.list();
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

   public List<Users> sqlHeUser(Integer id) {
     Session session = null;
     Transaction tx = null;
     List<Users> obj = new ArrayList();
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createQuery("from Users where pid=" + id);
       obj = query.list();
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

   public void upadtePid(int id) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("update proxy set pid = 0 where pid = " + id);
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

   public void UpdateNum(int number1, int number2, int number3) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("REPLACE INTO `proxy_num` (`id`, `yiji`, `erji`, `sanji`)\nVALUES\n  ('1000', " + number1 + "," + number2 + " ," + number3 + " )");


       int update = query.executeUpdate();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("执行HQL更新出现错误！");
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

   public void initUserGrade(int id) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("insert into proxy_users(yiji,erji,sanji,uid) values(0,0,0," + id + ")");
       int update = query.executeUpdate();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("执行HQL加入出现错误！");
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

   public void deleteUserGrade(int id) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("delete from proxy_users where uid=" + id);
       int update = query.executeUpdate();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("执行HQL删除取消出现错误！");
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

   public Proxy_num selectNum()
   {
     Session session = null;
     Transaction tx = null;
     Proxy_num obj = new Proxy_num();
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("select * from proxy_num where id=1000").addEntity(Proxy_num.class);
       query.setMaxResults(1);
       obj = (Proxy_num)query.uniqueResult();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
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

   public List<Proxy> sqlFindSubordinateProxy(int id) {
     Session session = null;
     List<Proxy> obj = new ArrayList();
     try {
       session = getSession();
       Query query = session.createSQLQuery("SELECT p2.* FROM proxy p1 INNER JOIN proxy p2 ON p1.id = p2.`pid` WHERE p1.id = " + id).addEntity(Proxy.class);
       obj = query.list();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
       ex.printStackTrace();
     } finally {
       if (session != null) {
         session.clear();
         session.close();
       }
     }
     return obj;
   }

   public List<Proxy> sqlFindProxyUser(int id) {
     Session session = null;
     List<Proxy> obj = new ArrayList();
     try {
       session = getSession();
       Query query = session.createSQLQuery("SELECT p.* FROM  proxy p where p.pid = " + id).addEntity(Proxy.class);
       obj = query.list();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
       ex.printStackTrace();
     } finally {
       if (session != null) {
         session.clear();
         session.close();
       }
     }
     return obj;
   }

   public List<Users> sqlFindSelfUserId(Integer id) {
     Session session = null;
     List<Users> obj = new ArrayList();
     try {
       session = getSession();
       Query query = session.createSQLQuery("SELECT u.* FROM users u INNER JOIN proxy p ON p.uid = u.id WHERE u.status = 1 AND p.id = " + id).addEntity(Users.class);
       obj = query.list();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
       ex.printStackTrace();
     } finally {
       if (session != null) {
         session.clear();
         session.close();
       }
     }
     return obj;
   }



   public void addSubordinateUsers(Integer id, List<Proxy> proxyList)
   {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("insert into users_line_relation(user_id,line_user_id,create_time) values(" + id + "," + id + ", now())");
       int update = query.executeUpdate();
       for (Proxy proxy : proxyList) {
         query = session.createSQLQuery("insert into users_line_relation(user_id,line_user_id,create_time) values(" + proxy.getId() + "," + id + ", now())");
         update = query.executeUpdate();
       }
       tx.commit();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
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



   public void removeSubordinateUsers(Integer id)
   {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("delete from users_line_relation where line_user_id = " + id);
       int update = query.executeUpdate();
       tx.commit();
     } catch (Exception ex) {
       System.out.println("获取对象出现错误！");
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

   public void partUpdateProxy(Integer pid, int id) {
     Session session = null;
     Transaction tx = null;
     try {
       session = getSession();
       tx = session.beginTransaction();
       Query query = session.createSQLQuery("update Proxy set pid=" + pid + " where pid = " + id);
       query.executeUpdate();
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
 }

