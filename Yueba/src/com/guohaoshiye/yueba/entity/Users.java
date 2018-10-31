package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;



public class Users
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
  private Integer charm;
  private Integer victorycount;
  private String prop;
  private String task;
  private String idNumber;
  private String realName;
  private Integer warehouseDiamonds;
  private Integer warehouseIntegral;

  public Users() {}

  public Users(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, Timestamp logintime, Timestamp createtime, String prop, String task, Integer warehouseDiamonds, Integer warehouseIntegral)
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
    this.logintime = logintime;
    this.createtime = createtime;
    this.prop = prop;
    this.task = task;
    this.warehouseDiamonds = warehouseDiamonds;
    this.warehouseIntegral = warehouseIntegral;
  }







  public Users(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, String ip, Timestamp logintime, Timestamp createtime, Integer everydaysign, Integer pid, String autograph, Integer charm, Integer victorycount, String prop, String task, String idNumber, String realName, Integer warehouseDiamonds, Integer warehouseIntegral)
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
    this.charm = charm;
    this.victorycount = victorycount;
    this.prop = prop;
    this.task = task;
    this.idNumber = idNumber;
    this.realName = realName;
    this.warehouseDiamonds = warehouseDiamonds;
    this.warehouseIntegral = warehouseIntegral;
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

  public Integer getCharm() {
    return this.charm;
  }

  public void setCharm(Integer charm) {
    this.charm = charm;
  }

  public Integer getVictorycount() {
    return this.victorycount;
  }

  public void setVictorycount(Integer victorycount) {
    this.victorycount = victorycount;
  }

  public String getProp() {
    return this.prop;
  }

  public void setProp(String prop) {
    this.prop = prop;
  }

  public String getTask() {
    return this.task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getIdNumber() {
    return this.idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getRealName() {
    return this.realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getWarehouseDiamonds() {
    return this.warehouseDiamonds;
  }

  public void setWarehouseDiamonds(Integer warehouseDiamonds) {
    this.warehouseDiamonds = warehouseDiamonds;
  }

  public Integer getWarehouseIntegral() {
    return this.warehouseIntegral;
  }

  public void setWarehouseIntegral(Integer warehouseIntegral) {
    this.warehouseIntegral = warehouseIntegral;
  }
}

