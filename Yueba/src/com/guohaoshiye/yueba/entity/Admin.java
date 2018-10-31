package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Admin
  implements Serializable
{
  private Integer id;
  private String adminname;
  private String password;
  private String head;
  private Timestamp logintime;
  private Timestamp createtime;
  private String opname;
  private Set adminRoles = new HashSet(0);

  private Integer adminHomeOp1;

  private Integer adminHomeOp2;


  public Admin() {}

  public Admin(String adminname, String password, String head, Timestamp logintime, String opname)
  {
    this.adminname = adminname;
    this.password = password;
    this.head = head;
    this.logintime = logintime;
    this.opname = opname;
  }



  public Admin(String adminname, String password, String head, Timestamp logintime, Timestamp createtime, String opname, Set adminRoles)
  {
    this.adminname = adminname;
    this.password = password;
    this.head = head;
    this.logintime = logintime;
    this.createtime = createtime;
    this.opname = opname;
    this.adminRoles = adminRoles;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAdminname() {
    return this.adminname;
  }

  public void setAdminname(String adminname) {
    this.adminname = adminname;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getHead() {
    return this.head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public Timestamp getLogintime() {
    return this.logintime;
  }

  public void setLogintime(Timestamp logintime) {
    this.logintime = logintime;
  }

  public Timestamp getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public Set getAdminRoles() {
    return this.adminRoles;
  }

  public void setAdminRoles(Set adminRoles) {
    this.adminRoles = adminRoles;
  }

  public String getOpname() {
    return this.opname;
  }

  public void setOpname(String opname) {
    this.opname = opname;
  }

  public Integer getAdminHomeOp1() {
    return this.adminHomeOp1;
  }

  public void setAdminHomeOp1(Integer adminHomeOp1) {
    this.adminHomeOp1 = adminHomeOp1;
  }

  public Integer getAdminHomeOp2() {
    return this.adminHomeOp2;
  }

  public void setAdminHomeOp2(Integer adminHomeOp2) {
    this.adminHomeOp2 = adminHomeOp2;
  }
}

