package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;











public class AdminRechargeLog
  implements Serializable
{
  private Integer id;
  private String money;
  private Integer uid;
  private Integer rtype;
  private Integer aid;
  private Timestamp createTime;

  public AdminRechargeLog() {}

  public AdminRechargeLog(String money, Integer uid, Integer rtype, Integer aid, Timestamp createTime)
  {
    this.money = money;
    this.uid = uid;
    this.rtype = rtype;
    this.aid = aid;
    this.createTime = createTime;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMoney() {
    return this.money;
  }

  public void setMoney(String money) {
    this.money = money;
  }

  public Integer getUid() {
    return this.uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getRtype() {
    return this.rtype;
  }

  public void setRtype(Integer rtype) {
    this.rtype = rtype;
  }

  public Integer getAid() {
    return this.aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}

