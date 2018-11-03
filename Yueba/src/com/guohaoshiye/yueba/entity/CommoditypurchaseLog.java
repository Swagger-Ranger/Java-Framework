/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: CommoditypurchaseLog
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "commoditypurchase_log", schema = "yueba", catalog = "")
public class CommoditypurchaseLog {
    private int id;
    private String commodityName;
    private int commodityNumber;
    private int commodityTotalPrice;
    private int purchaseUserid;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CommodityName")
    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    @Basic
    @Column(name = "CommodityNumber")
    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    @Basic
    @Column(name = "CommodityTotalPrice")
    public int getCommodityTotalPrice() {
        return commodityTotalPrice;
    }

    public void setCommodityTotalPrice(int commodityTotalPrice) {
        this.commodityTotalPrice = commodityTotalPrice;
    }

    @Basic
    @Column(name = "PurchaseUserid")
    public int getPurchaseUserid() {
        return purchaseUserid;
    }

    public void setPurchaseUserid(int purchaseUserid) {
        this.purchaseUserid = purchaseUserid;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommoditypurchaseLog that = (CommoditypurchaseLog) o;
        return id == that.id &&
                commodityNumber == that.commodityNumber &&
                commodityTotalPrice == that.commodityTotalPrice &&
                purchaseUserid == that.purchaseUserid &&
                Objects.equals(commodityName, that.commodityName) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commodityName, commodityNumber, commodityTotalPrice, purchaseUserid, createTime);
    }
}
