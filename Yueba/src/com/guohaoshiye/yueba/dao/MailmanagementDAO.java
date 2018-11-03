package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity_olddemo.Mailmanagement;
import com.guohaoshiye.yueba.entity_olddemo.Users;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;


public class MailmanagementDAO
  extends BaseHibernateDAO<Mailmanagement>
{
  public void saveMail(Timestamp d, List<Users> list, String describe)
  {
    Session session = getSession();
    Transaction tx = session.beginTransaction();
//    session.doWork(new MailmanagementDAO.1(this, list, describe, d));
    session.doWork(new Work() {
      int count = 0;
      @Override
      public void execute(Connection connection) throws SQLException {
        String sql = "INSERT INTO mailmanagement (uid,content,state,type,goods,createtime) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (Users users : list) {
          ps.setInt(1, users.getId().intValue());
//          ps.setString(2, this.val$describe);
          ps.setString(2, describe);
          ps.setInt(3, 0);
          ps.setInt(4, 0);
          ps.setString(5, "");
          ps.setTimestamp(6, d);
          ps.addBatch();
          if (++count % 1000 == 0) {
            ps.executeBatch();
          }
        }
        ps.executeBatch();
      }
    });


    tx.commit();
    session.close();
  }

  public List<Users> findAllUser(String sql)
  {
    Session session = null;
    Transaction tx = null;
    List<Users> obj = new ArrayList();
    try {
      session = getSession();
      tx = session.beginTransaction();
      Query query = getSession().createSQLQuery(sql);
      ((SQLQuery)query).addEntity("u", Users.class);
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



}

