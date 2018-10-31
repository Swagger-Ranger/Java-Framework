package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;










public class Robotrecharge
  implements Serializable
{
  private Integer id;
  private Integer rid;
  private Integer gold;
  private Timestamp time;
  private Integer aid;

  public Robotrecharge() {}

  public Robotrecharge(Integer rid, Integer gold, Timestamp time, Integer aid)
  {
    this.rid = rid;
    this.gold = gold;
    this.time = time;
    this.aid = aid;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRid() {
    return this.rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }

  public Integer getGold() {
    return this.gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Timestamp getTime() {
    return this.time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Integer getAid() {
    return this.aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }
}

