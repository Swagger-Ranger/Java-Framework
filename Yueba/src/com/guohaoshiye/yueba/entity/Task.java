package com.guohaoshiye.yueba.entity;

import java.io.Serializable;










public class Task
  implements Serializable
{
  private Integer id;
  private Integer acceptid;
  private Integer completeid;
  private String reward;
  private Integer type;
  private Integer state;
  private String describe;

  public Task() {}

  public Task(Integer acceptid, Integer completeid, String reward, Integer state)
  {
    this.acceptid = acceptid;
    this.completeid = completeid;
    this.reward = reward;
    this.state = state;
  }


  public Task(Integer acceptid, Integer completeid, String reward, Integer type, Integer state, String describe)
  {
    this.acceptid = acceptid;
    this.completeid = completeid;
    this.reward = reward;
    this.type = type;
    this.state = state;
    this.describe = describe;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAcceptid() {
    return this.acceptid;
  }

  public void setAcceptid(Integer acceptid) {
    this.acceptid = acceptid;
  }

  public Integer getCompleteid() {
    return this.completeid;
  }

  public void setCompleteid(Integer completeid) {
    this.completeid = completeid;
  }

  public String getReward() {
    return this.reward;
  }

  public void setReward(String reward) {
    this.reward = reward;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public String getDescribe() {
    return this.describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }
}

