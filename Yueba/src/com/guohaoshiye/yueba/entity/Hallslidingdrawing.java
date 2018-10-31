package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;










public class Hallslidingdrawing
  implements Serializable
{
  private Integer id;
  private String url;
  private Integer state;
  private Timestamp createtime;

  public Hallslidingdrawing() {}

  public Hallslidingdrawing(String url, Integer state, Timestamp createtime)
  {
    this.url = url;
    this.state = state;
    this.createtime = createtime;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Timestamp getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }
}

