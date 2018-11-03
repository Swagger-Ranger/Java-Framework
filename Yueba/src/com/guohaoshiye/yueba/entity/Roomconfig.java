/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Roomconfig
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
public class Roomconfig {
    private int roomid;
    private Integer playerlimit;
    private String name;
    private Integer roomtype;

    @Id
    @Column(name = "roomid")
    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    @Basic
    @Column(name = "playerlimit")
    public Integer getPlayerlimit() {
        return playerlimit;
    }

    public void setPlayerlimit(Integer playerlimit) {
        this.playerlimit = playerlimit;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "roomtype")
    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roomconfig that = (Roomconfig) o;
        return roomid == that.roomid &&
                Objects.equals(playerlimit, that.playerlimit) &&
                Objects.equals(name, that.name) &&
                Objects.equals(roomtype, that.roomtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomid, playerlimit, name, roomtype);
    }
}
