package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.AdminopLog;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;


public class AdminopLogDAO
  extends BaseHibernateDAO<AdminopLog>
{
  public PageModel<AdminopLog> sqlLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("aid".equals(param[i])) {
          where = where + " and aid = '" + paramValue[i] + "' ";
        }
        else if ("begin".equals(param[i])) {
          where = where + " and createTime >= '" + paramValue[i] + " 0:0:0' ";
        } else if ("end".equals(param[i])) {
          where = where + " and createTime <= '" + paramValue[i] + " 23:59:59' ";
        } else if ("operating".equals(param[i])) {
          where = where + " and operating = '" + paramValue[i] + "' ";
        }
      }
    }



    return logList(currentPage, pageSize, where);
  }

  private PageModel<AdminopLog> logList(int currentPage, int pageSize, String where)
  {
    PageModel<AdminopLog> pm = new PageModel();
    String sql = "select count(id) from adminop_log";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from AdminopLog";
    if (where != null) {
      hql = hql + where + "order by createTime desc";
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
}

