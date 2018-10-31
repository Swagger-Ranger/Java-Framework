package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.ProxyDAO;
import com.guohaoshiye.yueba.entity.Proxy;
import com.guohaoshiye.yueba.entity.Proxy_class;
import com.guohaoshiye.yueba.hibernate.HibernateSessionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ProxyKG
  extends HttpServlet
{
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doPost(req, resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    Integer kg = Integer.valueOf(req.getParameter("kg"));
    Integer id = Integer.valueOf(req.getParameter("id"));
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Proxy proxy = (Proxy)session.get(Proxy.class, id);
    ProxyDAO dao = new ProxyDAO();
    if (kg.intValue() == 0)
    {


      Proxy_class proxy_class = new Proxy_class();
      proxy_class.setPid(id);
      proxy_class.setClazz(Integer.valueOf(1));
      proxy_class.setTimes(Long.valueOf(new Date().getTime()));
      proxy_class.setYikai(Integer.valueOf(0));
      proxy.setKg(Integer.valueOf(1));
      proxy.setRight(Integer.valueOf(1));


      dao.initUserGrade(id.intValue());
      try {
        session.beginTransaction();
        session.save(proxy);
        session.save(proxy_class);
        session.getTransaction().commit();

        session.beginTransaction();

        session.getTransaction().commit();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        session.beginTransaction().rollback();
        session.clear();
        session.close();
      }
    }
    else {
      proxy.setKg(Integer.valueOf(0));proxy.setRight(Integer.valueOf(0));

      Query queryNum = session.createSQLQuery("select * from proxy_class where pid = " + id).addEntity(Proxy_class.class);queryNum.setMaxResults(1);
      Proxy_class proxy_class1 = (Proxy_class)queryNum.uniqueResult();
      try
      {
        session.beginTransaction();
        session.save(proxy);
        if (proxy_class1 != null) session.delete(proxy_class1);
        session.getTransaction().commit();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        session.beginTransaction().rollback();
        session.clear();
        session.close();
      }
    }
  }



  public List<Proxy> findAllSubordinateUsers(int id)
  {
    ProxyDAO dao = new ProxyDAO();
    List<Proxy> usersList = new ArrayList();

    List<Proxy> proxyList = dao.sqlFindProxyUser(id);

    for (Proxy proxy : proxyList)
    {
      usersList.addAll(findAllSubordinateUsers(proxy.getId().intValue()));
    }
    usersList.addAll(proxyList);

    return usersList;
  }
}

