/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Task
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
import java.util.Objects;

@Entity
public class Task {
    private int id;
    private int acceptid;
    private int completeid;
    private String reward;
    private Integer type;
    private int state;
    private String describe;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acceptid")
    public int getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(int acceptid) {
        this.acceptid = acceptid;
    }

    @Basic
    @Column(name = "completeid")
    public int getCompleteid() {
        return completeid;
    }

    public void setCompleteid(int completeid) {
        this.completeid = completeid;
    }

    @Basic
    @Column(name = "reward")
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
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
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                acceptid == task.acceptid &&
                completeid == task.completeid &&
                state == task.state &&
                Objects.equals(reward, task.reward) &&
                Objects.equals(type, task.type) &&
                Objects.equals(describe, task.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acceptid, completeid, reward, type, state, describe);
    }
}
