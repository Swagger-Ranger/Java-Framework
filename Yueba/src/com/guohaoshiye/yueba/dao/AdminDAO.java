package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.hibernate.PageModel;
import org.hibernate.Query;

public class AdminDAO extends com.guohaoshiye.yueba.hibernate.BaseHibernateDAO<Admin>
{
  public PageModel<Admin> pageList(int currentPage, int pageSize)
  {
    PageModel<Admin> pm = new PageModel();
    String sql = "select count(id) from Admin";
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    Query query = getSession().createQuery("from Admin");

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
}

