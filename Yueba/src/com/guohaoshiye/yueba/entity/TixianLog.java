package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class TixianLog
  implements Serializable
{
  private Integer id;
  private Integer pid;
  private String cash;
  private String ingots;
  private Integer status;
  private Timestamp createTime;
  private Integer auditPeople;
  private Timestamp auditTime;
  private String denyReason;
  private Integer type;
  private String content;
  private String tax;
  private String txhz;

  public TixianLog() {}

  public TixianLog(Integer pid, String cash, String ingots, Integer status, Timestamp createTime, Integer auditPeople, Timestamp auditTime, String denyReason, Integer type, String content, String tax, String txhz)
  {
    this.pid = pid;
    this.cash = cash;
    this.ingots = ingots;
    this.status = status;
    this.createTime = createTime;
    this.auditPeople = auditPeople;
    this.auditTime = auditTime;
    this.denyReason = denyReason;
    this.type = type;
    this.content = content;
    this.tax = tax;
    this.txhz = txhz;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPid() {
    return this.pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getCash() {
    return this.cash;
  }

  public void setCash(String cash) {
    this.cash = cash;
  }

  public String getIngots() {
    return this.ingots;
  }

  public void setIngots(String ingots) {
    this.ingots = ingots;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Integer getAuditPeople() {
    return this.auditPeople;
  }

  public void setAuditPeople(Integer auditPeople) {
    this.auditPeople = auditPeople;
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

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTax() {
    return this.tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }

  public String getTxhz() {
    return this.txhz;
  }

  public void setTxhz(String txhz) {
    this.txhz = txhz;
  }
}

