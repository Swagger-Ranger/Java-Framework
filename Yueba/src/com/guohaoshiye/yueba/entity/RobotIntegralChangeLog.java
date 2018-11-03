/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: RobotIntegralChangeLog
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
@Table(name = "robot_integral_change_log", schema = "yueba", catalog = "")
public class RobotIntegralChangeLog {
    private int id;
    private int robotid;
    private int oldintegral;
    private int newintegral;
    private int changeintegral;
    private Timestamp changetime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "robotid")
    public int getRobotid() {
        return robotid;
    }

    public void setRobotid(int robotid) {
        this.robotid = robotid;
    }

    @Basic
    @Column(name = "oldintegral")
    public int getOldintegral() {
        return oldintegral;
    }

    public void setOldintegral(int oldintegral) {
        this.oldintegral = oldintegral;
    }

    @Basic
    @Column(name = "newintegral")
    public int getNewintegral() {
        return newintegral;
    }

    public void setNewintegral(int newintegral) {
        this.newintegral = newintegral;
    }

    @Basic
    @Column(name = "changeintegral")
    public int getChangeintegral() {
        return changeintegral;
    }

    public void setChangeintegral(int changeintegral) {
        this.changeintegral = changeintegral;
    }

    @Basic
    @Column(name = "changetime")
    public Timestamp getChangetime() {
        return changetime;
    }

    public void setChangetime(Timestamp changetime) {
        this.changetime = changetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotIntegralChangeLog that = (RobotIntegralChangeLog) o;
        return id == that.id &&
                robotid == that.robotid &&
                oldintegral == that.oldintegral &&
                newintegral == that.newintegral &&
                changeintegral == that.changeintegral &&
                Objects.equals(changetime, that.changetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, robotid, oldintegral, newintegral, changeintegral, changetime);
    }
}
