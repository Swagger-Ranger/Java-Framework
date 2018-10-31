package com.guohaoshiye.yueba.entity;

import java.io.Serializable;

public class Accept
  implements Serializable
{
  private Integer id;
  private Integer acceptcondition;
  private String otherconditions;
  private String describe;

  public Accept() {}

  public Accept(Integer acceptcondition)
  {
    this.acceptcondition = acceptcondition;
  }


  public Accept(Integer acceptcondition, String otherconditions, String describe)
  {
    this.acceptcondition = acceptcondition;
    this.otherconditions = otherconditions;
    this.describe = describe;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAcceptcondition() {
    return this.acceptcondition;
  }

  public void setAcceptcondition(Integer acceptcondition) {
    this.acceptcondition = acceptcondition;
  }

  public String getOtherconditions() {
    return this.otherconditions;
  }

  public void setOtherconditions(String otherconditions) {
    this.otherconditions = otherconditions;
  }

  public String getDescribe() {
    return this.describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }
}

