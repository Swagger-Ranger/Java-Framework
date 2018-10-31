package com.guohaoshiye.yueba.hibernate;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

public abstract interface IBaseHibernateDAO<T>
{
  public abstract Session getSession();
  
  public abstract void save(T paramT);
  
  public abstract void update(T paramT);
  
  public abstract void partUpdate(int paramInt, String[] paramArrayOfString, Object[] paramArrayOfObject);
  
  public abstract void delete(Serializable paramSerializable);
  
  public abstract T findById(Serializable paramSerializable);
  
  public abstract List<T> findByHQL(String paramString, Object... paramVarArgs);
  
  public abstract List<T> queryPage(String paramString, int paramInt1, int paramInt2);
}

