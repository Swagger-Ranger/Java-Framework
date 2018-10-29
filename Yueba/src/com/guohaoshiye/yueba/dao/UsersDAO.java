/*     */ package com.aiwan.dao;
/*     */ 
/*     */ import com.aiwan.entity.Users;
/*     */ import com.aiwan.hibernate.BaseHibernateDAO;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.sf.json.JSONArray;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ public class UsersDAO
/*     */   extends BaseHibernateDAO<Users>
/*     */ {
/*     */   public PageModel<Users> sqlUsers(int currentPage, int pageSize, String[] param, String[] paramValue)
/*     */   {
/*  22 */     String where = " where 1=1 ";
/*  23 */     for (int i = 0; i < param.length; i++) {
/*  24 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  25 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  26 */         if ("nickname".equals(param[i])) {
/*  27 */           where = where + " and " + param[i] + " like '%" + paramValue[i] + "%'";
/*     */         }
/*  29 */         else if ("status".equals(param[i])) {
/*  30 */           where = where + " and status = '" + paramValue[i] + "' ";
/*     */         }
/*  32 */         else if ("uid".equals(param[i])) {
/*  33 */           where = where + " and id = '" + paramValue[i] + "' ";
/*  34 */         } else if ("pid".equals(param[i])) {
/*  35 */           where = where + " and pid = '" + paramValue[i] + "' ";
/*  36 */         } else if ("realName".equals(param[i])) {
/*  37 */           where = where + " and realName = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  43 */     return userList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   public PageModel<Users> userList(int currentPage, int pageSize, String where) {
/*  47 */     PageModel<Users> pm = new PageModel();
/*  48 */     String sql = "select count(id) from Users";
/*  49 */     if (where != null) {
/*  50 */       sql = sql + where;
/*     */     }
/*  52 */     pm.setPageSize(pageSize);
/*  53 */     pm.setSumCount(count(sql));
/*  54 */     pm.setCurrentPage(currentPage);
/*     */     
/*  56 */     String hql = "from Users";
/*  57 */     if (where != null) {
/*  58 */       hql = hql + where + "order by createtime desc";
/*     */     }
/*  60 */     Query query = getSession().createQuery(hql);
/*     */     
/*  62 */     query.setMaxResults(pm.getPageSize());
/*     */     
/*  64 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/*  65 */     pm.setList(query.list());
/*  66 */     getSession().clear();
/*  67 */     getSession().close();
/*  68 */     return pm;
/*     */   }
/*     */   
/*     */   public int count(String sql)
/*     */   {
/*  73 */     Query query = getSession().createSQLQuery(sql);
/*  74 */     return ((BigInteger)query.uniqueResult()).intValue();
/*     */   }
/*     */   
/*     */   public String findByUidTime(Integer id) {
/*  78 */     String count = "0";
/*  79 */     Session session = null;
/*  80 */     Transaction tx = null;
/*     */     try {
/*  82 */       session = getSession();
/*  83 */       tx = session.beginTransaction();
/*  84 */       Query query = session.createSQLQuery("select IFNULL(SUM(IFNULL(TIMESTAMPDIFF(SECOND,logintime,signout),0)),0) AS tim from login_log where uid = ?");
/*  85 */       query.setParameter(0, id);
/*  86 */       Object c = query.uniqueResult();
/*  87 */       count = c.toString();
/*  88 */       tx.commit();
/*     */     } catch (Exception ex) {
/*  90 */       System.out.println("执行HQL查找对象出现错误！");
/*  91 */       ex.printStackTrace();
/*  92 */       if (tx != null) {
/*  93 */         tx.rollback();
/*     */       }
/*     */     } finally {
/*  96 */       if (session != null) {
/*  97 */         session.clear();
/*  98 */         session.close();
/*     */       }
/*     */     }
/* 101 */     return count;
/*     */   }
/*     */   
/*     */   public String findByLoginCount(Integer id) {
/* 105 */     String count = "0";
/* 106 */     Session session = null;
/* 107 */     Transaction tx = null;
/*     */     try {
/* 109 */       session = getSession();
/* 110 */       tx = session.beginTransaction();
/* 111 */       Query query = session.createSQLQuery("select COUNT(id) AS logincount from login_log where uid = ?");
/* 112 */       query.setParameter(0, id);
/* 113 */       Object c = query.uniqueResult();
/* 114 */       count = c.toString();
/* 115 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 117 */       System.out.println("执行HQL查找对象出现错误！");
/* 118 */       ex.printStackTrace();
/* 119 */       if (tx != null) {
/* 120 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 123 */       if (session != null) {
/* 124 */         session.clear();
/* 125 */         session.close();
/*     */       }
/*     */     }
/* 128 */     return count;
/*     */   }
/*     */   
/*     */   public String findAllgoldtrue(String sql) {
/* 132 */     String count = "0";
/* 133 */     Session session = null;
/* 134 */     Transaction tx = null;
/*     */     try {
/* 136 */       session = getSession();
/* 137 */       tx = session.beginTransaction();
/* 138 */       Query query = session.createSQLQuery(sql);
/* 139 */       Object c = query.uniqueResult();
/* 140 */       count = c.toString();
/* 141 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 143 */       System.out.println("执行HQL查找对象出现错误！");
/* 144 */       ex.printStackTrace();
/* 145 */       if (tx != null) {
/* 146 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 149 */       if (session != null) {
/* 150 */         session.clear();
/* 151 */         session.close();
/*     */       }
/*     */     }
/* 154 */     return count;
/*     */   }
/*     */   
/*     */   public void updatePid(int id) {
/* 158 */     Session session = null;
/* 159 */     Transaction tx = null;
/*     */     try {
/* 161 */       session = getSession();
/* 162 */       tx = session.beginTransaction();
/* 163 */       Query query = session.createSQLQuery("update users set pid = 0 where pid = " + id);
/* 164 */       int update = query.executeUpdate();
/* 165 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 167 */       System.out.println("执行HQL查找对象出现错误！");
/* 168 */       ex.printStackTrace();
/* 169 */       if (tx != null) {
/* 170 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 173 */       if (session != null) {
/* 174 */         session.clear();
/* 175 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<Integer, String> findGameCount(String sql) {
/* 181 */     Map<Integer, String> map = new HashMap();
/* 182 */     map.put(Integer.valueOf(1), "0");
/* 183 */     map.put(Integer.valueOf(2), "0");
/* 184 */     map.put(Integer.valueOf(3), "0");
/* 185 */     map.put(Integer.valueOf(4), "0");
/* 186 */     Session session = null;
/* 187 */     Transaction tx = null;
/*     */     try {
/* 189 */       session = getSession();
/* 190 */       tx = session.beginTransaction();
/* 191 */       Query query = session.createSQLQuery(sql);
/* 192 */       List list = query.list();
/* 193 */       if (list.size() > 0) {
/* 194 */         for (Object object : list) {
/* 195 */           JSONArray json = JSONArray.fromObject(object);
/* 196 */           if (((Integer)json.get(0)).intValue() == 1) {
/* 197 */             map.put(Integer.valueOf(1), json.get(1).toString());
/*     */           }
/* 199 */           if (((Integer)json.get(0)).intValue() == 2) {
/* 200 */             map.put(Integer.valueOf(2), json.get(1).toString());
/*     */           }
/* 202 */           if (((Integer)json.get(0)).intValue() == 3) {
/* 203 */             map.put(Integer.valueOf(3), json.get(1).toString());
/*     */           }
/* 205 */           if (((Integer)json.get(0)).intValue() == 4) {
/* 206 */             map.put(Integer.valueOf(4), json.get(1).toString());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 211 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 213 */       System.out.println("执行HQL查找对象出现错误！");
/* 214 */       ex.printStackTrace();
/* 215 */       if (tx != null) {
/* 216 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 219 */       if (session != null) {
/* 220 */         session.clear();
/* 221 */         session.close();
/*     */       }
/*     */     }
/* 224 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\UsersDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */