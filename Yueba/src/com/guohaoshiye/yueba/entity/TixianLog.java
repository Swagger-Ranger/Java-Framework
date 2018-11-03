/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: TixianLog
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
@Table(name = "tixian_log", schema = "yueba", catalog = "")
public class TixianLog {
    private int id;
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
    private String zengsong;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "cash")
    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    @Basic
    @Column(name = "Ingots")
    public String getIngots() {
        return ingots;
    }

    public void setIngots(String ingots) {
        this.ingots = ingots;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "auditPeople")
    public Integer getAuditPeople() {
        return auditPeople;
    }

    public void setAuditPeople(Integer auditPeople) {
        this.auditPeople = auditPeople;
    }

    @Basic
    @Column(name = "auditTime")
    public Timestamp getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Timestamp auditTime) {
        this.auditTime = auditTime;
    }

    @Basic
    @Column(name = "denyReason")
    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "tax")
    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "txhz")
    public String getTxhz() {
        return txhz;
    }

    public void setTxhz(String txhz) {
        this.txhz = txhz;
    }

    @Basic
    @Column(name = "zengsong")
    public String getZengsong() {
        return zengsong;
    }

    public void setZengsong(String zengsong) {
        this.zengsong = zengsong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TixianLog tixianLog = (TixianLog) o;
        return id == tixianLog.id &&
                Objects.equals(pid, tixianLog.pid) &&
                Objects.equals(cash, tixianLog.cash) &&
                Objects.equals(ingots, tixianLog.ingots) &&
                Objects.equals(status, tixianLog.status) &&
                Objects.equals(createTime, tixianLog.createTime) &&
                Objects.equals(auditPeople, tixianLog.auditPeople) &&
                Objects.equals(auditTime, tixianLog.auditTime) &&
                Objects.equals(denyReason, tixianLog.denyReason) &&
                Objects.equals(type, tixianLog.type) &&
                Objects.equals(content, tixianLog.content) &&
                Objects.equals(tax, tixianLog.tax) &&
                Objects.equals(txhz, tixianLog.txhz) &&
                Objects.equals(zengsong, tixianLog.zengsong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, cash, ingots, status, createTime, auditPeople, auditTime, denyReason, type, content, tax, txhz, zengsong);
    }
}
