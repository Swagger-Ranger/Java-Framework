package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;



public class Robot
  implements Serializable
{
  private Integer id;
  private String account;
  private String password;
  private String nickname;
  private Short type;
  private Short sex;
  private String head;
  private Short headType;
  private Integer gold;
  private Integer diamonds;
  private Integer integral;
  private Short status;
  private String ip;
  private Timestamp logintime;
  private Timestamp createtime;
  private Integer everydaysign;
  private Integer pid;
  private String autograph;

  public Robot() {}

  public Robot(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, String ip, Timestamp logintime, Timestamp createtime, Integer everydaysign, Integer pid, String autograph)
  {
    this.account = account;
    this.password = password;
    this.nickname = nickname;
    this.type = type;
    this.sex = sex;
    this.head = head;
    this.headType = headType;
    this.gold = gold;
    this.diamonds = diamonds;
    this.integral = integral;
    this.status = status;
    this.ip = ip;
    this.logintime = logintime;
    this.createtime = createtime;
    this.everydaysign = everydaysign;
    this.pid = pid;
    this.autograph = autograph;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Short getType() {
    return this.type;
  }

  public void setType(Short type) {
    this.type = type;
  }

  public Short getSex() {
    return this.sex;
  }

  public void setSex(Short sex) {
    this.sex = sex;
  }

  public String getHead() {
    return this.head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public Short getHeadType() {
    return this.headType;
  }

  public void setHeadType(Short headType) {
    this.headType = headType;
  }

  public Integer getGold() {
    return this.gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Integer getDiamonds() {
    return this.diamonds;
  }

  public void setDiamonds(Integer diamonds) {
    this.diamonds = diamonds;
  }

  public Integer getIntegral() {
    return this.integral;
  }

  public void setIntegral(Integer integral) {
    this.integral = integral;
  }

  public Short getStatus() {
    return this.status;
  }

  public void setStatus(Short status) {
    this.status = status;
  }

  public String getIp() {
    return this.ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
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

  public Integer getEverydaysign() {
    return this.everydaysign;
  }

  public void setEverydaysign(Integer everydaysign) {
    this.everydaysign = everydaysign;
  }

  public Integer getPid() {
    return this.pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getAutograph() {
    return this.autograph;
  }

  public void setAutograph(String autograph) {
    this.autograph = autograph;
  }
}

