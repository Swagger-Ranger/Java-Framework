package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity_olddemo.Complete;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import org.hibernate.Query;

public class CompleteDAO extends BaseHibernateDAO<Complete>
{
  public PageModel<Complete> pageList(int currentPage, int pageSize)
  {
    PageModel<Complete> pm = new PageModel();
    String sql = "select count(id) from Complete";
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    Query query = getSession().createQuery("from Complete");

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

