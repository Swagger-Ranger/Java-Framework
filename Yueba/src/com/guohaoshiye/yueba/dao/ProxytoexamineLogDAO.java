package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.ProxytoexamineLog;
import com.guohaoshiye.yueba.hibernate.BaseHibernateDAO;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.Session;























public class ProxytoexamineLogDAO
  extends BaseHibernateDAO<ProxytoexamineLog>
{
  private PageModel<ProxytoexamineLog> logList(int currentPage, int pageSize, String where)
  {
    PageModel<ProxytoexamineLog> pm = new PageModel();
    String sql = "select count(id) from proxytoexamine_log";
    if (where != null) {
      sql = sql + where;
    }
    pm.setPageSize(pageSize);
    pm.setSumCount(count(sql));
    pm.setCurrentPage(currentPage);

    String hql = "from ProxytoexamineLog";
    if (where != null) {
      hql = hql + where + "order by creatrtime desc";
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

  public PageModel<ProxytoexamineLog> sqlLoglist(int currentPage, int pageSize, String[] param, String[] paramValue)
  {
    String where = " where 1=1 ";
    for (int i = 0; i < param.length; i++) {
      if ((paramValue[i] != null) && (paramValue[i] != "") &&
        (paramValue[i] != null) && (paramValue[i] != "")) {
        if ("uid".equals(param[i])) {
          where = where + " and uid = '" + paramValue[i] + "' ";
        }
        else if ("begin".equals(param[i])) {
          where = where + " and creatrtime >= '" + paramValue[i] + "' ";
        } else if ("end".equals(param[i])) {
          where = where + " and creatrtime <= '" + paramValue[i] + "' ";
        } else if ("pid".equals(param[i])) {
          where = where + " and pid = '" + paramValue[i] + "' ";
        } else if ("phone".equals(param[i])) {
          where = where + " and phone = '" + paramValue[i] + "' ";
        } else if ("weixinhao".equals(param[i])) {
          where = where + " and weixinhao = '" + paramValue[i] + "' ";
        }
      }
    }



    where = where + " and state!=0 ";
    return logList(currentPage, pageSize, where);
  }
}

