/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: ProxytoexamineLog
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
@Table(name = "proxytoexamine_log", schema = "yueba", catalog = "")
public class ProxytoexamineLog {
    private int id;
    private int uid;
    private String clientname;
    private String weixinhao;
    private String chalouname;
    private String applydescription;
    private String phone;
    private Integer servicecharge;
    private int state;
    private Timestamp creatrtime;
    private Integer auditid;
    private Timestamp auditTime;
    private String denyReason;
    private Integer pid;
    private Integer currentDiamonds;
    private Integer currentIntegral;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "clientname")
    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    @Basic
    @Column(name = "weixinhao")
    public String getWeixinhao() {
        return weixinhao;
    }

    public void setWeixinhao(String weixinhao) {
        this.weixinhao = weixinhao;
    }

    @Basic
    @Column(name = "chalouname")
    public String getChalouname() {
        return chalouname;
    }

    public void setChalouname(String chalouname) {
        this.chalouname = chalouname;
    }

    @Basic
    @Column(name = "applydescription")
    public String getApplydescription() {
        return applydescription;
    }

    public void setApplydescription(String applydescription) {
        this.applydescription = applydescription;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "servicecharge")
    public Integer getServicecharge() {
        return servicecharge;
    }

    public void setServicecharge(Integer servicecharge) {
        this.servicecharge = servicecharge;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "creatrtime")
    public Timestamp getCreatrtime() {
        return creatrtime;
    }

    public void setCreatrtime(Timestamp creatrtime) {
        this.creatrtime = creatrtime;
    }

    @Basic
    @Column(name = "auditid")
    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
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
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "currentDiamonds")
    public Integer getCurrentDiamonds() {
        return currentDiamonds;
    }

    public void setCurrentDiamonds(Integer currentDiamonds) {
        this.currentDiamonds = currentDiamonds;
    }

    @Basic
    @Column(name = "currentIntegral")
    public Integer getCurrentIntegral() {
        return currentIntegral;
    }

    public void setCurrentIntegral(Integer currentIntegral) {
        this.currentIntegral = currentIntegral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxytoexamineLog that = (ProxytoexamineLog) o;
        return id == that.id &&
                uid == that.uid &&
                state == that.state &&
                Objects.equals(clientname, that.clientname) &&
                Objects.equals(weixinhao, that.weixinhao) &&
                Objects.equals(chalouname, that.chalouname) &&
                Objects.equals(applydescription, that.applydescription) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(servicecharge, that.servicecharge) &&
                Objects.equals(creatrtime, that.creatrtime) &&
                Objects.equals(auditid, that.auditid) &&
                Objects.equals(auditTime, that.auditTime) &&
                Objects.equals(denyReason, that.denyReason) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(currentDiamonds, that.currentDiamonds) &&
                Objects.equals(currentIntegral, that.currentIntegral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, clientname, weixinhao, chalouname, applydescription, phone, servicecharge, state, creatrtime, auditid, auditTime, denyReason, pid, currentDiamonds, currentIntegral);
    }
}
