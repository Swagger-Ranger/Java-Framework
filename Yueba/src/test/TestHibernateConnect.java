/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: TestHibernateConnect
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:43
 * Description: 测试数据库连接配置是否正确
 * Aha-eureka:
 *******************************************************************************/

package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import static com.guohaoshiye.yueba.hibernate.HibernateSessionFactory.getSession;

public class TestHibernateConnect {


    public static String findByUidTime(Integer id) {
        String count = "0";
        Session session = null;
        Transaction tx = null;
        try {
            session = getSession();
            tx = session.beginTransaction();
            org.hibernate.Query query = session.createSQLQuery("select IFNULL(SUM(IFNULL(TIMESTAMPDIFF(SECOND,logintime,signout),0)),0) AS tim from login_log where uid = ?");
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

    public static void main(String[] args) {
//        Configuration cfg = new Configuration();
//        cfg.configure();
//        //2.使用sessionFactory
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
//        //3使用sessionfactory 实例化session对象
//        Session session = sessionFactory.openSession();
//        //4.开始事务
//        Transaction transaction = session.beginTransaction();
//        //5.调用 session 保存 数据。
//        session.save(accept);
//        //6.commit transaction
//        transaction.commit();
//        //7.close  Database resources
//        session.close();
//        sessionFactory.close();


//        Accept accept = new Accept();
////        String hql="update Users user set user.age=20 where user.age=18";
//        String hql="select count(id) from Users";
//        Query queryupdate=session.createQuery(hql);
//        int ret=queryupdate.executeUpdate();
//


//        Configuration cfg = new Configuration();

        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);


//        SessionFactory sessionFactory = new Configuration().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select IFNULL(SUM(IFNULL(TIMESTAMPDIFF(SECOND,logintime,signout),0)),0) AS tim from login_log where uid = 10088";
        String hql_count = "select count(id) from Users";
        Query query = session.createSQLQuery(hql_count);
//        query.setParameter(10088);
        Object c = query.uniqueResult();
        String count = c.toString();
        System.out.println(count);
        System.out.println(findByUidTime(10088));//---com.guohaoshiye.yueba.hibernate.HibernateSessionFactory 33行有问题



    }
}
