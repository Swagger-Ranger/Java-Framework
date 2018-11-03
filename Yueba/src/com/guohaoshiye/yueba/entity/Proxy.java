/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Proxy
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Proxy {
    private int id;
    private String account;
    private String password;
    private Integer pid;
    private BigDecimal integral;
    private String nickname;
    private String contactWay;
    private Integer proxyType;
    private Integer status;
    private Double ratio;
    private Timestamp logintime;
    private Timestamp createTime;
    private String trueName;
    private String phone;
    private Integer uid;
    private String erweimaUrl;
    private String promotionmapUrl;
    private Timestamp bindTime;
    private String head;
    private Integer yiji;
    private int erji;
    private int sanji;
    private int right;
    private int isqianfei;
    private Timestamp qishishijian;
    private int kg;
    private String promotionmapUrl3;
    private String promotionmapUrl2;
    private Integer isDisable;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "integral")
    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "contactWay")
    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Basic
    @Column(name = "proxyType")
    public Integer getProxyType() {
        return proxyType;
    }

    public void setProxyType(Integer proxyType) {
        this.proxyType = proxyType;
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
    @Column(name = "ratio")
    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    @Basic
    @Column(name = "logintime")
    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
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
    @Column(name = "trueName")
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
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
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "erweimaUrl")
    public String getErweimaUrl() {
        return erweimaUrl;
    }

    public void setErweimaUrl(String erweimaUrl) {
        this.erweimaUrl = erweimaUrl;
    }

    @Basic
    @Column(name = "promotionmapUrl")
    public String getPromotionmapUrl() {
        return promotionmapUrl;
    }

    public void setPromotionmapUrl(String promotionmapUrl) {
        this.promotionmapUrl = promotionmapUrl;
    }

    @Basic
    @Column(name = "bindTime")
    public Timestamp getBindTime() {
        return bindTime;
    }

    public void setBindTime(Timestamp bindTime) {
        this.bindTime = bindTime;
    }

    @Basic
    @Column(name = "head")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Basic
    @Column(name = "yiji")
    public Integer getYiji() {
        return yiji;
    }

    public void setYiji(Integer yiji) {
        this.yiji = yiji;
    }

    @Basic
    @Column(name = "erji")
    public int getErji() {
        return erji;
    }

    public void setErji(int erji) {
        this.erji = erji;
    }

    @Basic
    @Column(name = "sanji")
    public int getSanji() {
        return sanji;
    }

    public void setSanji(int sanji) {
        this.sanji = sanji;
    }

    @Basic
    @Column(name = "right")
    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Basic
    @Column(name = "isqianfei")
    public int getIsqianfei() {
        return isqianfei;
    }

    public void setIsqianfei(int isqianfei) {
        this.isqianfei = isqianfei;
    }

    @Basic
    @Column(name = "qishishijian")
    public Timestamp getQishishijian() {
        return qishishijian;
    }

    public void setQishishijian(Timestamp qishishijian) {
        this.qishishijian = qishishijian;
    }

    @Basic
    @Column(name = "kg")
    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    @Basic
    @Column(name = "promotionmapUrl3")
    public String getPromotionmapUrl3() {
        return promotionmapUrl3;
    }

    public void setPromotionmapUrl3(String promotionmapUrl3) {
        this.promotionmapUrl3 = promotionmapUrl3;
    }

    @Basic
    @Column(name = "promotionmapUrl2")
    public String getPromotionmapUrl2() {
        return promotionmapUrl2;
    }

    public void setPromotionmapUrl2(String promotionmapUrl2) {
        this.promotionmapUrl2 = promotionmapUrl2;
    }

    @Basic
    @Column(name = "isDisable")
    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proxy proxy = (Proxy) o;
        return id == proxy.id &&
                erji == proxy.erji &&
                sanji == proxy.sanji &&
                right == proxy.right &&
                isqianfei == proxy.isqianfei &&
                kg == proxy.kg &&
                Objects.equals(account, proxy.account) &&
                Objects.equals(password, proxy.password) &&
                Objects.equals(pid, proxy.pid) &&
                Objects.equals(integral, proxy.integral) &&
                Objects.equals(nickname, proxy.nickname) &&
                Objects.equals(contactWay, proxy.contactWay) &&
                Objects.equals(proxyType, proxy.proxyType) &&
                Objects.equals(status, proxy.status) &&
                Objects.equals(ratio, proxy.ratio) &&
                Objects.equals(logintime, proxy.logintime) &&
                Objects.equals(createTime, proxy.createTime) &&
                Objects.equals(trueName, proxy.trueName) &&
                Objects.equals(phone, proxy.phone) &&
                Objects.equals(uid, proxy.uid) &&
                Objects.equals(erweimaUrl, proxy.erweimaUrl) &&
                Objects.equals(promotionmapUrl, proxy.promotionmapUrl) &&
                Objects.equals(bindTime, proxy.bindTime) &&
                Objects.equals(head, proxy.head) &&
                Objects.equals(yiji, proxy.yiji) &&
                Objects.equals(qishishijian, proxy.qishishijian) &&
                Objects.equals(promotionmapUrl3, proxy.promotionmapUrl3) &&
                Objects.equals(promotionmapUrl2, proxy.promotionmapUrl2) &&
                Objects.equals(isDisable, proxy.isDisable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, pid, integral, nickname, contactWay, proxyType, status, ratio, logintime, createTime, trueName, phone, uid, erweimaUrl, promotionmapUrl, bindTime, head, yiji, erji, sanji, right, isqianfei, qishishijian, kg, promotionmapUrl3, promotionmapUrl2, isDisable);
    }
}
