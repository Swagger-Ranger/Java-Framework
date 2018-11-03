/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Users
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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Users {
    private int id;
    private String account;
    private String password;
    private String nickname;
    private byte type;
    private byte sex;
    private String head;
    private byte headType;
    private int gold;
    private int diamonds;
    private int integral;
    private byte status;
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
    private int warehouseDiamonds;
    private int warehouseIntegral;
    private String freeProps;

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
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sex")
    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
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
    @Column(name = "headType")
    public byte getHeadType() {
        return headType;
    }

    public void setHeadType(byte headType) {
        this.headType = headType;
    }

    @Basic
    @Column(name = "gold")
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Basic
    @Column(name = "diamonds")
    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    @Basic
    @Column(name = "integral")
    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "everydaysign")
    public Integer getEverydaysign() {
        return everydaysign;
    }

    public void setEverydaysign(Integer everydaysign) {
        this.everydaysign = everydaysign;
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
    @Column(name = "autograph")
    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    @Basic
    @Column(name = "charm")
    public Integer getCharm() {
        return charm;
    }

    public void setCharm(Integer charm) {
        this.charm = charm;
    }

    @Basic
    @Column(name = "victorycount")
    public Integer getVictorycount() {
        return victorycount;
    }

    public void setVictorycount(Integer victorycount) {
        this.victorycount = victorycount;
    }

    @Basic
    @Column(name = "prop")
    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    @Basic
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Basic
    @Column(name = "idNumber")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "realName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "warehouseDiamonds")
    public int getWarehouseDiamonds() {
        return warehouseDiamonds;
    }

    public void setWarehouseDiamonds(int warehouseDiamonds) {
        this.warehouseDiamonds = warehouseDiamonds;
    }

    @Basic
    @Column(name = "warehouseIntegral")
    public int getWarehouseIntegral() {
        return warehouseIntegral;
    }

    public void setWarehouseIntegral(int warehouseIntegral) {
        this.warehouseIntegral = warehouseIntegral;
    }

    @Basic
    @Column(name = "freeProps")
    public String getFreeProps() {
        return freeProps;
    }

    public void setFreeProps(String freeProps) {
        this.freeProps = freeProps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                type == users.type &&
                sex == users.sex &&
                headType == users.headType &&
                gold == users.gold &&
                diamonds == users.diamonds &&
                integral == users.integral &&
                status == users.status &&
                warehouseDiamonds == users.warehouseDiamonds &&
                warehouseIntegral == users.warehouseIntegral &&
                Objects.equals(account, users.account) &&
                Objects.equals(password, users.password) &&
                Objects.equals(nickname, users.nickname) &&
                Objects.equals(head, users.head) &&
                Objects.equals(ip, users.ip) &&
                Objects.equals(logintime, users.logintime) &&
                Objects.equals(createtime, users.createtime) &&
                Objects.equals(everydaysign, users.everydaysign) &&
                Objects.equals(pid, users.pid) &&
                Objects.equals(autograph, users.autograph) &&
                Objects.equals(charm, users.charm) &&
                Objects.equals(victorycount, users.victorycount) &&
                Objects.equals(prop, users.prop) &&
                Objects.equals(task, users.task) &&
                Objects.equals(idNumber, users.idNumber) &&
                Objects.equals(realName, users.realName) &&
                Objects.equals(freeProps, users.freeProps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, nickname, type, sex, head, headType, gold, diamonds, integral, status, ip, logintime, createtime, everydaysign, pid, autograph, charm, victorycount, prop, task, idNumber, realName, warehouseDiamonds, warehouseIntegral, freeProps);
    }
}
