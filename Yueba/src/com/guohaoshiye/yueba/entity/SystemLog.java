package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;











public class SystemLog
  implements Serializable
{
  private Integer id;
  private Integer aid;
  private String content;
  private Timestamp createTime;
  private String operating;

  public SystemLog() {}

  public SystemLog(Integer aid, String content, Timestamp createTime, String operating)
  {
    this.aid = aid;
    this.content = content;
    this.createTime = createTime;
    this.operating = operating;
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

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public String getOperating() {
    return this.operating;
  }

  public void setOperating(String operating) {
    this.operating = operating;
  }
}

