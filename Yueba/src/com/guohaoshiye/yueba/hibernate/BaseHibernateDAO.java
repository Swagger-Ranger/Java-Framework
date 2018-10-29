/*     */ package com.guohaoshiye.yueba.hibernate;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.util.List;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseHibernateDAO<T>
/*     */   implements IBaseHibernateDAO<T>
/*     */ {
/*     */   private Class<T> clazz;
/*     */   
/*     */   public BaseHibernateDAO()
/*     */   {
/*  22 */     ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
/*  23 */     this.clazz = ((Class)type.getActualTypeArguments()[0]);
/*     */   }
/*     */   
/*     */ 
/*     */   public Session getSession()
/*     */   {
/*  29 */     return HibernateSessionFactory.getSession();
/*     */   }
/*     */   
/*     */   public void save(Object entity)
/*     */   {
/*  34 */     Session session = null;
/*  35 */     Transaction tx = null;
/*     */     try {
/*  37 */       session = getSession();
/*  38 */       tx = session.beginTransaction();
/*  39 */       session.save(entity);
/*  40 */       tx.commit();
/*     */     } catch (Exception ex) {
/*  42 */       System.out.println("保存对象出现错误！");
/*  43 */       ex.printStackTrace();
/*  44 */       if (tx != null) {
/*  45 */         tx.rollback();
/*     */       }
/*     */     } finally {
/*  48 */       if (session != null) {
/*  49 */         session.clear();
/*  50 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void update(Object entity)
/*     */   {
/*  58 */     Session session = null;
/*  59 */     Transaction tx = null;
/*     */     try {
/*  61 */       session = getSession();
/*  62 */       tx = session.beginTransaction();
/*  63 */       session.update(entity);
/*  64 */       tx.commit();
/*     */     } catch (Exception ex) {
/*  66 */       System.out.println("更新对象出现错误！");
/*  67 */       ex.printStackTrace();
/*  68 */       if (tx != null) {
/*  69 */         tx.rollback();
/*     */       }
/*     */     } finally {
/*  72 */       if (session != null) {
/*  73 */         session.clear();
/*  74 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void partUpdate(int id, String[] names, Object[] values)
/*     */   {
/*  81 */     Session session = null;
/*  82 */     Transaction tx = null;
/*     */     try {
/*  84 */       session = getSession();
/*  85 */       tx = session.beginTransaction();
/*     */       
/*  87 */       String tab = this.clazz.getSimpleName();
/*  88 */       String hql = "update " + tab + " t";
/*  89 */       for (int i = 0; i < names.length; i++) {
/*  90 */         hql = hql + " set t." + names[i] + "=?";
/*     */       }
/*  92 */       hql = hql + " where t.id=" + id;
/*  93 */       Query query = session.createQuery(hql);
/*  94 */       for (int i = 0; i < values.length; i++) {
/*  95 */         query.setParameter(i, values[i]);
/*     */       }
/*  97 */       System.out.println("部分更新：" + hql);
/*  98 */       query.executeUpdate();
/*  99 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 101 */       System.out.println("更新对象部分属性出现错误！");
/* 102 */       ex.printStackTrace();
/* 103 */       if (tx != null) {
/* 104 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 107 */       if (session != null) {
/* 108 */         session.clear();
/* 109 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void delete(Serializable id)
/*     */   {
/* 117 */     T obj = findById(id);
/* 118 */     Session session = null;
/* 119 */     Transaction tx = null;
/*     */     try {
/* 121 */       session = getSession();
/* 122 */       tx = session.beginTransaction();
/* 123 */       session.delete(obj);
/* 124 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 126 */       System.out.println("删除对象出现错误！");
/* 127 */       ex.printStackTrace();
/* 128 */       if (tx != null) {
/* 129 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 132 */       if (session != null) {
/* 133 */         session.clear();
/* 134 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public T findById(Serializable id)
/*     */   {
/* 142 */     Session session = null;
/* 143 */     Transaction tx = null;
/* 144 */     T obj = null;
/*     */     try {
/* 146 */       session = getSession();
/* 147 */       tx = session.beginTransaction();
/* 148 */       obj = session.get(this.clazz, id);
/* 149 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 151 */       System.out.println("查找对象出现错误！");
/* 152 */       ex.printStackTrace();
/* 153 */       if (tx != null) {
/* 154 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 157 */       if (session != null) {
/* 158 */         session.clear();
/* 159 */         session.close();
/*     */       }
/*     */     }
/* 162 */     return obj;
/*     */   }
/*     */   
/*     */   public List<T> findByHQL(String hql, Object... params)
/*     */   {
/* 167 */     List<T> list = null;
/* 168 */     Session session = null;
/* 169 */     Transaction tx = null;
/*     */     try {
/* 171 */       session = getSession();
/* 172 */       tx = session.beginTransaction();
/*     */       
/* 174 */       Query query = session.createQuery(hql);
/* 175 */       for (int i = 0; (params != null) && (i < params.length); i++) {
/* 176 */         query.setParameter(i, params[i]);
/*     */       }
/*     */       
/* 179 */       list = query.list();
/*     */       
/* 181 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 183 */       System.out.println("执行HQL查找对象出现错误！");
/* 184 */       ex.printStackTrace();
/* 185 */       if (tx != null) {
/* 186 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 189 */       if (session != null) {
/* 190 */         session.clear();
/* 191 */         session.close();
/*     */       }
/*     */     }
/* 194 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<T> queryPage(String hql, int pageNo, int pageSize)
/*     */   {
/* 200 */     List<T> list = null;
/* 201 */     Session session = null;
/* 202 */     Transaction tx = null;
/*     */     try {
/* 204 */       session = getSession();
/* 205 */       tx = session.beginTransaction();
/*     */       
/* 207 */       Query query = session.createQuery(hql);
/*     */       
/*     */ 
/* 210 */       list = query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
/*     */       
/* 212 */       tx.commit();
/*     */     } catch (Exception ex) {
/* 214 */       System.out.println("分页查询出现错误出现错误！");
/* 215 */       ex.printStackTrace();
/* 216 */       if (tx != null) {
/* 217 */         tx.rollback();
/*     */       }
/*     */     } finally {
/* 220 */       if (session != null) {
/* 221 */         session.clear();
/* 222 */         session.close();
/*     */       }
/*     */     }
/* 225 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\hibernate\BaseHibernateDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */