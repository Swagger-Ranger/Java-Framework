package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;











public class Recharge
  implements Serializable
{
  private Integer id;
  private Integer userId;
  private Integer money;
  private Timestamp createtime;
  private Integer status;
  private String order;
  private Integer gold;
  private Integer type;

  public Recharge() {}

  public Recharge(Integer userId, Timestamp createtime, Integer status, Integer gold)
  {
    this.userId = userId;
    this.createtime = createtime;
    this.status = status;
    this.gold = gold;
  }


  public Recharge(Integer userId, Integer money, Timestamp createtime, Integer status, String order, Integer gold, Integer type)
  {
    this.userId = userId;
    this.money = money;
    this.createtime = createtime;
    this.status = status;
    this.order = order;
    this.gold = gold;
    this.type = type;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getMoney() {
    return this.money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  public Timestamp getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getOrder() {
    return this.order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public Integer getGold() {
    return this.gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}

