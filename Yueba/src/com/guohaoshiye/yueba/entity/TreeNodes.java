package com.guohaoshiye.yueba.entity;

import java.util.List;



public class TreeNodes
{
  private int code;
  private int parentCode;
  private String icon;
  private String name;
  private List<TreeNodes> child;

  public TreeNodes() {}

  public TreeNodes(int code, int parentCode, String icon, String name, List<TreeNodes> child)
  {
    this.code = code;
    this.parentCode = parentCode;
    this.icon = icon;
    this.name = name;
    this.child = child;
  }

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getParentCode() {
    return this.parentCode;
  }

  public void setParentCode(int parentCode) {
    this.parentCode = parentCode;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TreeNodes> getChild() {
    return this.child;
  }

  public void setChild(List<TreeNodes> child) {
    this.child = child;
  }

  public String toString()
  {
    return "{\"code\":\"" + this.code + "\", \"parentCode\":\"" + this.parentCode + "\", \"icon\":\"" + this.icon + "\", \"name\":\"" + this.name + "\", \"child\":" + this.child + "}";
  }
}

