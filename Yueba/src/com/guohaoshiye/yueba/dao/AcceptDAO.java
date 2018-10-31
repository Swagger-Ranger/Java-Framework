package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Accept;
import com.guohaoshiye.yueba.hibernate.PageModel;
import org.hibernate.Query;
import org.hibernate.Session;

public class AcceptDAO extends com.guohaoshiye.yueba.hibernate.BaseHibernateDAO<Accept>
{
  public PageModel<Accept> pageList(int currentPage, int pageSize)
  {
    PageModel<Accept> pm = new PageModel();
    String sql = "select count(id) from Accept";
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    Query query = getSession().createQuery("from Accept");

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

