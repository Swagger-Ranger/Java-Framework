package com.guohaoshiye.yueba.entity;

import java.io.Serializable;

public class AdminRole
  implements Serializable
{
  private Integer id;
  private AdminMenu adminMenu;
  private Admin admin;
  private String op;

  public AdminRole() {}

  public AdminRole(AdminMenu adminMenu, Admin admin, String op)
  {
    this.adminMenu = adminMenu;
    this.admin = admin;
    this.op = op;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AdminMenu getAdminMenu() {
    return this.adminMenu;
  }

  public void setAdminMenu(AdminMenu adminMenu) {
    this.adminMenu = adminMenu;
  }

  public Admin getAdmin() {
    return this.admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public String getOp() {
    return this.op;
  }

  public void setOp(String op) {
    this.op = op;
  }
}

