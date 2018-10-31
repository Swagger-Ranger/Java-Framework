package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class ProxytoexamineLog
  implements Serializable
{
  private Integer id;
  private Integer uid;
  private String clientname;
  private String weixinhao;
  private String chalouname;
  private String applydescription;
  private String phone;
  private Integer servicecharge;
  private Integer state;
  private Timestamp creatrtime;
  private Integer auditid;
  private Timestamp auditTime;
  private String denyReason;
  private Integer pid;
  private Integer currentDiamonds;
  private Integer currentIntegral;

  public ProxytoexamineLog() {}

  public ProxytoexamineLog(Integer uid, String clientname, String weixinhao, String chalouname, String phone, Integer state)
  {
    this.uid = uid;
    this.clientname = clientname;
    this.weixinhao = weixinhao;
    this.chalouname = chalouname;
    this.phone = phone;
    this.state = state;
  }





  public ProxytoexamineLog(Integer uid, String clientname, String weixinhao, String chalouname, String applydescription, String phone, Integer servicecharge, Integer state, Timestamp creatrtime, Integer auditid, Timestamp auditTime, String denyReason, Integer pid, Integer currentDiamonds, Integer currentIntegral)
  {
    this.uid = uid;
    this.clientname = clientname;
    this.weixinhao = weixinhao;
    this.chalouname = chalouname;
    this.applydescription = applydescription;
    this.phone = phone;
    this.servicecharge = servicecharge;
    this.state = state;
    this.creatrtime = creatrtime;
    this.auditid = auditid;
    this.auditTime = auditTime;
    this.denyReason = denyReason;
    this.pid = pid;
    this.currentDiamonds = currentDiamonds;
    this.currentIntegral = currentIntegral;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return this.uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getClientname() {
    return this.clientname;
  }

  public void setClientname(String clientname) {
    this.clientname = clientname;
  }

  public String getWeixinhao() {
    return this.weixinhao;
  }

  public void setWeixinhao(String weixinhao) {
    this.weixinhao = weixinhao;
  }

  public String getChalouname() {
    return this.chalouname;
  }

  public void setChalouname(String chalouname) {
    this.chalouname = chalouname;
  }

  public String getApplydescription() {
    return this.applydescription;
  }

  public void setApplydescription(String applydescription) {
    this.applydescription = applydescription;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getServicecharge() {
    return this.servicecharge;
  }

  public void setServicecharge(Integer servicecharge) {
    this.servicecharge = servicecharge;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Timestamp getCreatrtime() {
    return this.creatrtime;
  }

  public void setCreatrtime(Timestamp creatrtime) {
    this.creatrtime = creatrtime;
  }

  public Integer getAuditid() {
    return this.auditid;
  }

  public void setAuditid(Integer auditid) {
    this.auditid = auditid;
  }

  public Timestamp getAuditTime() {
    return this.auditTime;
  }

  public void setAuditTime(Timestamp auditTime) {
    this.auditTime = auditTime;
  }

  public String getDenyReason() {
    return this.denyReason;
  }

  public void setDenyReason(String denyReason) {
    this.denyReason = denyReason;
  }

  public Integer getPid() {
    return this.pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getCurrentDiamonds() {
    return this.currentDiamonds;
  }

  public void setCurrentDiamonds(Integer currentDiamonds) {
    this.currentDiamonds = currentDiamonds;
  }

  public Integer getCurrentIntegral() {
    return this.currentIntegral;
  }

  public void setCurrentIntegral(Integer currentIntegral) {
    this.currentIntegral = currentIntegral;
  }
}

