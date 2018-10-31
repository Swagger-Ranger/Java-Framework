package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Robotrecharge;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;


public class RobotrechargeDAO
  extends BaseHibernateDAO<Robotrecharge>
{
  public PageModel<Robotrecharge> sqlRechargeLog(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("rid".equals(param[i])) {
          where = where + " and rid = '" + paramValue[i] + "' ";
        } else if ("aid".equals(param[i])) {
          where = where + " and aid = '" + paramValue[i] + "' ";
        }
      }
    }


    return logList(currentPage, pageSize, where);
  }


  private PageModel<Robotrecharge> logList(int currentPage, int pageSize, String where)
  {
    PageModel<Robotrecharge> pm = new PageModel();
    String sql = "select count(id) from robotrecharge";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);
    String hql = "from Robotrecharge";
    if (where != null) {
      hql = hql + where + "order by time desc";
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

