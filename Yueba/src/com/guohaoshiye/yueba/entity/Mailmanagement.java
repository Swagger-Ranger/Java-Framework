package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;










public class Mailmanagement
  implements Serializable
{
  private Integer id;
  private Integer uid;
  private String content;
  private Integer state;
  private Integer type;
  private String goods;
  private Timestamp createtime;

  public Mailmanagement() {}

  public Mailmanagement(Integer uid)
  {
    this.uid = uid;
  }


  public Mailmanagement(Integer uid, String content, Integer state, Integer type, String goods, Timestamp createtime)
  {
    this.uid = uid;
    this.content = content;
    this.state = state;
    this.type = type;
    this.goods = goods;
    this.createtime = createtime;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return this.uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getGoods() {
    return this.goods;
  }

  public void setGoods(String goods) {
    this.goods = goods;
  }

  public Timestamp getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }
}

