/*     */ package com.aiwan.dao;
/*     */ 
/*     */ import com.aiwan.entity.Proxy;
/*     */ import com.aiwan.entity.Proxy_num;
/*     */ import com.aiwan.entity.Users;
/*     */ import com.aiwan.hibernate.BaseHibernateDAO;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SQLQuery;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class ProxyDAO extends BaseHibernateDAO<Proxy>
/*     */ {
/*     */   public PageModel<Proxy> sqlProxy(int currentPage, int pageSize, String[] param, String[] paramValue)
/*     */   {
/*  21 */     String where = " where 1=1 ";
/*  22 */     for (int i = 0; i < param.length; i++) {
/*  23 */       if ((paramValue[i] != null) && (paramValue[i] != "") && 
/*  24 */         (paramValue[i] != null) && (paramValue[i] != "")) {
/*  25 */         if ("nickname".equals(param[i])) {
/*  26 */           where = where + " and " + param[i] + " like '%" + paramValue[i] + "%'";
/*     */         }
/*  28 */         else if ("status".equals(param[i])) {
/*  29 */           where = where + " and status = '" + paramValue[i] + "' ";
/*     */         }
/*  31 */         else if ("pid".equals(param[i])) {
/*  32 */           where = where + " and id = '" + paramValue[i] + "' ";
/*     */         }
/*  34 */         else if ("kg".equals(param[i])) {
/*  35 */           where = where + " and kg = '" + paramValue[i] + "' ";
/*     */         }
/*  37 */         else if ("ppid".equals(param[i])) {
/*  38 */           where = where + " and pid = '" + paramValue[i] + "' ";
/*     */         }
/*  40 */         else if ("phone".equals(param[i])) {
/*  41 */           where = where + " and phone = '" + paramValue[i] + "' ";
/*     */         }
/*  43 */         else if ("trueName".equals(param[i])) {
/*  44 */           where = where + " and trueName = '" + paramValue[i] + "' ";
/*     */         }
/*  46 */         else if ("contactWay".equals(param[i])) {
/*  47 */           where = where + " and contactWay = '" + paramValue[i] + "' ";
/*     */         }
/*  49 */         else if ("isDisable".equals(param[i])) {
/*  50 */           where = where + " and isDisable = '" + paramValue[i] + "' ";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  57 */     return proxyList(currentPage, pageSize, where);
/*     */   }
/*     */   
/*     */   private PageModel<Proxy> proxyList(int currentPage, int pageSize, String where)
/*     */   {
/*  62 */     PageModel<Proxy> pm = new PageModel();
/*  63 */     String sql = "select count(id) from proxy";
/*  64 */     if (where != null) {
/*  65 */       sql = sql + where;
/*     */     }
/*  67 */     pm.setPageSize(pageSize);
/*  68 */     pm.setSumCount(count(sql));
/*  69 */     pm.setCurrentPage(currentPage);
/*     */     
/*  71 */     String hql = "from Proxy";
/*  72 */     if (where != null) {
/*  73 */       hql = hql + where + "order by status desc";
/*     */     }
/*  75 */     Query query = getSession().createQuery(hql);
/*     */     
/*  77 */     query.setMaxResults(pm.getPageSize());
/*     */     
/*  79 */     query.setFirstResult((pm.getCurrentPage() - 1) * pm.getPageSize());
/*  80 */     pm.setList(query.list());
/*  81 */     getSession().clear();
/*  82 */     getSession().close();
/*  83 */     return pm;
/*     */   }
/*     */   
/*     */ 
/*     */   public int count(String sql)
/*     */   {
/*  89 */     Query query = getSession().createSQLQuery(sql);
/*  90 */     return ((BigInteger)query.uniqueResult()).intValue();
/*     */   }
/*     */   
/*     */   public List<Proxy> sqlHeProxy(int pid) {
/*  94 */     Session session = null;
/*  95 */     Transaction tx = null;
/*  96 */     List<Proxy> obj = new ArrayList();
/*     */     try {
/*  98 */       session = getSession();
/*  99 */       tx = session.beginTransaction();
/* 100 */       Query query = session.createSQLQuery("select p.* from proxy p where FIND_IN_SET(id, getChildLstProxy(" + pid + "))");
/* 101 */       ((SQLQuery)query).addEntity("p", Proxy.class);
/* 102 */       obj = query.list();
/* 103 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 105 */       System.out.println("查找对象出现错误！");
/* 106 */       ex.printStackTrace();
/* 107 */       if (tx != null) {
/* 108 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 111 */       if (session != null) {
/* 112 */         session.clear();
/* 113 */         session.close();
/*     */       }
/*     */     }
/* 116 */     return obj;
/*     */   }
/*     */   
/*     */   public List<Users> sqlHeUser(Integer id) {
/* 120 */     Session session = null;
/* 121 */     Transaction tx = null;
/* 122 */     List<Users> obj = new ArrayList();
/*     */     try {
/* 124 */       session = getSession();
/* 125 */       tx = session.beginTransaction();
/* 126 */       Query query = session.createQuery("from Users where pid=" + id);
/* 127 */       obj = query.list();
/* 128 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 130 */       System.out.println("查找对象出现错误！");
/* 131 */       ex.printStackTrace();
/* 132 */       if (tx != null) {
/* 133 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 136 */       if (session != null) {
/* 137 */         session.clear();
/* 138 */         session.close();
/*     */       }
/*     */     }
/* 141 */     return obj;
/*     */   }
/*     */   
/*     */   public void upadtePid(int id) {
/* 145 */     Session session = null;
/* 146 */     Transaction tx = null;
/*     */     try {
/* 148 */       session = getSession();
/* 149 */       tx = session.beginTransaction();
/* 150 */       Query query = session.createSQLQuery("update proxy set pid = 0 where pid = " + id);
/* 151 */       int update = query.executeUpdate();
/* 152 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 154 */       System.out.println("执行HQL查找对象出现错误！");
/* 155 */       ex.printStackTrace();
/* 156 */       if (tx != null) {
/* 157 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 160 */       if (session != null) {
/* 161 */         session.clear();
/* 162 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void UpdateNum(int number1, int number2, int number3) {
/* 168 */     Session session = null;
/* 169 */     Transaction tx = null;
/*     */     try {
/* 171 */       session = getSession();
/* 172 */       tx = session.beginTransaction();
/* 173 */       Query query = session.createSQLQuery("REPLACE INTO `proxy_num` (`id`, `yiji`, `erji`, `sanji`)\nVALUES\n  ('1000', " + number1 + "," + number2 + " ," + number3 + " )");
/*     */       
/*     */ 
/* 176 */       int update = query.executeUpdate();
/* 177 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 179 */       System.out.println("执行HQL更新出现错误！");
/* 180 */       ex.printStackTrace();
/* 181 */       if (tx != null) {
/* 182 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 185 */       if (session != null) {
/* 186 */         session.clear();
/* 187 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void initUserGrade(int id) {
/* 193 */     Session session = null;
/* 194 */     Transaction tx = null;
/*     */     try {
/* 196 */       session = getSession();
/* 197 */       tx = session.beginTransaction();
/* 198 */       Query query = session.createSQLQuery("insert into proxy_users(yiji,erji,sanji,uid) values(0,0,0," + id + ")");
/* 199 */       int update = query.executeUpdate();
/* 200 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 202 */       System.out.println("执行HQL加入出现错误！");
/* 203 */       ex.printStackTrace();
/* 204 */       if (tx != null) {
/* 205 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 208 */       if (session != null) {
/* 209 */         session.clear();
/* 210 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteUserGrade(int id) {
/* 216 */     Session session = null;
/* 217 */     Transaction tx = null;
/*     */     try {
/* 219 */       session = getSession();
/* 220 */       tx = session.beginTransaction();
/* 221 */       Query query = session.createSQLQuery("delete from proxy_users where uid=" + id);
/* 222 */       int update = query.executeUpdate();
/* 223 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 225 */       System.out.println("执行HQL删除取消出现错误！");
/* 226 */       ex.printStackTrace();
/* 227 */       if (tx != null) {
/* 228 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 231 */       if (session != null) {
/* 232 */         session.clear();
/* 233 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Proxy_num selectNum()
/*     */   {
/* 240 */     Session session = null;
/* 241 */     Transaction tx = null;
/* 242 */     Proxy_num obj = new Proxy_num();
/*     */     try {
/* 244 */       session = getSession();
/* 245 */       tx = session.beginTransaction();
/* 246 */       Query query = session.createSQLQuery("select * from proxy_num where id=1000").addEntity(Proxy_num.class);
/* 247 */       query.setMaxResults(1);
/* 248 */       obj = (Proxy_num)query.uniqueResult();
/* 249 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 251 */       System.out.println("获取对象出现错误！");
/* 252 */       ex.printStackTrace();
/* 253 */       if (tx != null) {
/* 254 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 257 */       if (session != null) {
/* 258 */         session.clear();
/* 259 */         session.close();
/*     */       }
/*     */     }
/* 262 */     return obj;
/*     */   }
/*     */   
/*     */   public List<Proxy> sqlFindSubordinateProxy(int id) {
/* 266 */     Session session = null;
/* 267 */     List<Proxy> obj = new ArrayList();
/*     */     try {
/* 269 */       session = getSession();
/* 270 */       Query query = session.createSQLQuery("SELECT p2.* FROM proxy p1 INNER JOIN proxy p2 ON p1.id = p2.`pid` WHERE p1.id = " + id).addEntity(Proxy.class);
/* 271 */       obj = query.list();
/*     */     } catch (Exception ex) {
/* 273 */       System.out.println("获取对象出现错误！");
/* 274 */       ex.printStackTrace();
/*     */     } finally {
/* 276 */       if (session != null) {
/* 277 */         session.clear();
/* 278 */         session.close();
/*     */       }
/*     */     }
/* 281 */     return obj;
/*     */   }
/*     */   
/*     */   public List<Proxy> sqlFindProxyUser(int id) {
/* 285 */     Session session = null;
/* 286 */     List<Proxy> obj = new ArrayList();
/*     */     try {
/* 288 */       session = getSession();
/* 289 */       Query query = session.createSQLQuery("SELECT p.* FROM  proxy p where p.pid = " + id).addEntity(Proxy.class);
/* 290 */       obj = query.list();
/*     */     } catch (Exception ex) {
/* 292 */       System.out.println("获取对象出现错误！");
/* 293 */       ex.printStackTrace();
/*     */     } finally {
/* 295 */       if (session != null) {
/* 296 */         session.clear();
/* 297 */         session.close();
/*     */       }
/*     */     }
/* 300 */     return obj;
/*     */   }
/*     */   
/*     */   public List<Users> sqlFindSelfUserId(Integer id) {
/* 304 */     Session session = null;
/* 305 */     List<Users> obj = new ArrayList();
/*     */     try {
/* 307 */       session = getSession();
/* 308 */       Query query = session.createSQLQuery("SELECT u.* FROM users u INNER JOIN proxy p ON p.uid = u.id WHERE u.status = 1 AND p.id = " + id).addEntity(Users.class);
/* 309 */       obj = query.list();
/*     */     } catch (Exception ex) {
/* 311 */       System.out.println("获取对象出现错误！");
/* 312 */       ex.printStackTrace();
/*     */     } finally {
/* 314 */       if (session != null) {
/* 315 */         session.clear();
/* 316 */         session.close();
/*     */       }
/*     */     }
/* 319 */     return obj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addSubordinateUsers(Integer id, List<Proxy> proxyList)
/*     */   {
/* 326 */     Session session = null;
/* 327 */     Transaction tx = null;
/*     */     try {
/* 329 */       session = getSession();
/* 330 */       tx = session.beginTransaction();
/* 331 */       Query query = session.createSQLQuery("insert into users_line_relation(user_id,line_user_id,create_time) values(" + id + "," + id + ", now())");
/* 332 */       int update = query.executeUpdate();
/* 333 */       for (Proxy proxy : proxyList) {
/* 334 */         query = session.createSQLQuery("insert into users_line_relation(user_id,line_user_id,create_time) values(" + proxy.getId() + "," + id + ", now())");
/* 335 */         update = query.executeUpdate();
/*     */       }
/* 337 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 339 */       System.out.println("获取对象出现错误！");
/* 340 */       ex.printStackTrace();
/* 341 */       if (tx != null) {
/* 342 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 345 */       if (session != null) {
/* 346 */         session.clear();
/* 347 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void removeSubordinateUsers(Integer id)
/*     */   {
/* 356 */     Session session = null;
/* 357 */     Transaction tx = null;
/*     */     try {
/* 359 */       session = getSession();
/* 360 */       tx = session.beginTransaction();
/* 361 */       Query query = session.createSQLQuery("delete from users_line_relation where line_user_id = " + id);
/* 362 */       int update = query.executeUpdate();
/* 363 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 365 */       System.out.println("获取对象出现错误！");
/* 366 */       ex.printStackTrace();
/* 367 */       if (tx != null) {
/* 368 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 371 */       if (session != null) {
/* 372 */         session.clear();
/* 373 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void partUpdateProxy(Integer pid, int id) {
/* 379 */     Session session = null;
/* 380 */     Transaction tx = null;
/*     */     try {
/* 382 */       session = getSession();
/* 383 */       tx = session.beginTransaction();
/* 384 */       Query query = session.createSQLQuery("update Proxy set pid=" + pid + " where pid = " + id);
/* 385 */       query.executeUpdate();
/* 386 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 388 */       System.out.println("更新对象出现错误！");
/* 389 */       ex.printStackTrace();
/* 390 */       if (tx != null) {
/* 391 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 394 */       if (session != null) {
/* 395 */         session.clear();
/* 396 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\ProxyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */