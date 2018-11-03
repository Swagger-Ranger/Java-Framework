/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Guizezhu
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
public class Guizezhu {
    private int id;
    private String guizezhu;
    private int roomtype;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "guizezhu")
    public String getGuizezhu() {
        return guizezhu;
    }

    public void setGuizezhu(String guizezhu) {
        this.guizezhu = guizezhu;
    }

    @Basic
    @Column(name = "roomtype")
    public int getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guizezhu guizezhu1 = (Guizezhu) o;
        return id == guizezhu1.id &&
                roomtype == guizezhu1.roomtype &&
                Objects.equals(guizezhu, guizezhu1.guizezhu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guizezhu, roomtype);
    }
}
