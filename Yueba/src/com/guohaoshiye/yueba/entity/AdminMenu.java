package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AdminMenu
  implements Serializable
{
  private Integer id;
  private String title;
  private String url;
  private String spread;
  private String icon;
  private Integer rank;
  private Set adminRoles = new HashSet(0);




  public AdminMenu() {}



  public AdminMenu(String title, String url, String spread, String icon, Integer rank, Set adminRoles)
  {
    this.title = title;
    this.url = url;
    this.spread = spread;
    this.icon = icon;
    this.rank = rank;
    this.adminRoles = adminRoles;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSpread() {
    return this.spread;
  }

  public void setSpread(String spread) {
    this.spread = spread;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Integer getRank() {
    return this.rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public Set getAdminRoles() {
    return this.adminRoles;
  }

  public void setAdminRoles(Set adminRoles) {
    this.adminRoles = adminRoles;
  }
}

