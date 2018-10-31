package com.guohaoshiye.yueba.entity;

import java.io.Serializable;

public class Complete
  implements Serializable
{
  private Integer id;
  private Integer completecondition;
  private String otherconditions;
  private String describe;

  public Complete() {}

  public Complete(Integer completecondition)
  {
    this.completecondition = completecondition;
  }


  public Complete(Integer completecondition, String otherconditions, String describe)
  {
    this.completecondition = completecondition;
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

  public Integer getCompletecondition() {
    return this.completecondition;
  }

  public void setCompletecondition(Integer completecondition) {
    this.completecondition = completecondition;
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

