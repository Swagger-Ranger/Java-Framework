package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class AdminopLog
  implements Serializable
{
  private Integer id;
  private Integer aid;
  private String description;
  private Timestamp createTime;

  public AdminopLog() {}

  public AdminopLog(Integer aid)
  {
    this.aid = aid;
  }

  public AdminopLog(Integer aid, String description, Timestamp createTime)
  {
    this.aid = aid;
    this.description = description;
    this.createTime = createTime;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAid() {
    return this.aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}

