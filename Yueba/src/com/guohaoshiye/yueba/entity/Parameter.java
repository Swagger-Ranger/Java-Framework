package com.guohaoshiye.yueba.entity;

import java.io.Serializable;









public class Parameter
  implements Serializable
{
  private Integer id;
  private String name;
  private String value;
  private String explain;
  private Integer type;

  public Parameter() {}

  public Parameter(String name, String value, String explain)
  {
    this.name = name;
    this.value = value;
    this.explain = explain;
  }

  public Parameter(String name, String value, String explain, Integer type)
  {
    this.name = name;
    this.value = value;
    this.explain = explain;
    this.type = type;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getExplain() {
    return this.explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}

