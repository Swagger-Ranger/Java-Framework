package com.guohaoshiye.yueba.entity;

import java.util.Date;

public class UsersLineRelation {
  private Integer id;
  private String userId;
  private String lineUserId;
  private Date creatTime;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getLineUserId() {
    return this.lineUserId;
  }

  public void setLineUserId(String lineUserId) {
    this.lineUserId = lineUserId;
  }

  public Date getCreatTime() {
    return this.creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }
}

