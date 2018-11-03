/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Robot
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
public class Robot {
    private int id;
    private String account;
    private String password;
    private String nickname;
    private Byte type;
    private Byte sex;
    private String head;
    private Byte headType;
    private Integer gold;
    private Integer diamonds;
    private Integer integral;
    private Byte status;
    private String ip;
    private Timestamp logintime;
    private Timestamp createtime;
    private Integer everydaysign;
    private Integer pid;
    private String autograph;
    private String task;
    private String prop;

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
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
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
    public Byte getHeadType() {
        return headType;
    }

    public void setHeadType(Byte headType) {
        this.headType = headType;
    }

    @Basic
    @Column(name = "gold")
    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Basic
    @Column(name = "diamonds")
    public Integer getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(Integer diamonds) {
        this.diamonds = diamonds;
    }

    @Basic
    @Column(name = "integral")
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Basic
    @Column(name = "prop")
    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return id == robot.id &&
                Objects.equals(account, robot.account) &&
                Objects.equals(password, robot.password) &&
                Objects.equals(nickname, robot.nickname) &&
                Objects.equals(type, robot.type) &&
                Objects.equals(sex, robot.sex) &&
                Objects.equals(head, robot.head) &&
                Objects.equals(headType, robot.headType) &&
                Objects.equals(gold, robot.gold) &&
                Objects.equals(diamonds, robot.diamonds) &&
                Objects.equals(integral, robot.integral) &&
                Objects.equals(status, robot.status) &&
                Objects.equals(ip, robot.ip) &&
                Objects.equals(logintime, robot.logintime) &&
                Objects.equals(createtime, robot.createtime) &&
                Objects.equals(everydaysign, robot.everydaysign) &&
                Objects.equals(pid, robot.pid) &&
                Objects.equals(autograph, robot.autograph) &&
                Objects.equals(task, robot.task) &&
                Objects.equals(prop, robot.prop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, nickname, type, sex, head, headType, gold, diamonds, integral, status, ip, logintime, createtime, everydaysign, pid, autograph, task, prop);
    }
}
