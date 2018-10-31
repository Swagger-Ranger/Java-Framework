package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;












public class CommoditypurchaseLog
  implements Serializable
{
  private Integer id;
  private String commodityName;
  private Integer commodityNumber;
  private Integer commodityTotalPrice;
  private Integer purchaseUserid;
  private Timestamp createTime;

  public CommoditypurchaseLog() {}

  public CommoditypurchaseLog(String commodityName, Integer commodityNumber, Integer commodityTotalPrice, Integer purchaseUserid, Timestamp createTime)
  {
    this.commodityName = commodityName;
    this.commodityNumber = commodityNumber;
    this.commodityTotalPrice = commodityTotalPrice;
    this.purchaseUserid = purchaseUserid;
    this.createTime = createTime;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCommodityName() {
    return this.commodityName;
  }

  public void setCommodityName(String commodityName) {
    this.commodityName = commodityName;
  }

  public Integer getCommodityNumber() {
    return this.commodityNumber;
  }

  public void setCommodityNumber(Integer commodityNumber) {
    this.commodityNumber = commodityNumber;
  }

  public Integer getCommodityTotalPrice() {
    return this.commodityTotalPrice;
  }

  public void setCommodityTotalPrice(Integer commodityTotalPrice) {
    this.commodityTotalPrice = commodityTotalPrice;
  }

  public Integer getPurchaseUserid() {
    return this.purchaseUserid;
  }

  public void setPurchaseUserid(Integer purchaseUserid) {
    this.purchaseUserid = purchaseUserid;
  }

  public Timestamp getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}

