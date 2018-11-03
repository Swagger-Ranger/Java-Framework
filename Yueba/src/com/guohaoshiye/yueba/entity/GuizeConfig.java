/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: GuizeConfig
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "guize_config", schema = "yueba", catalog = "")
public class GuizeConfig {
    private int id;
    private String guizename;
    private Integer roomtype;
    private Integer guezivalue;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "guizename")
    public String getGuizename() {
        return guizename;
    }

    public void setGuizename(String guizename) {
        this.guizename = guizename;
    }

    @Basic
    @Column(name = "roomtype")
    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    @Basic
    @Column(name = "guezivalue")
    public Integer getGuezivalue() {
        return guezivalue;
    }

    public void setGuezivalue(Integer guezivalue) {
        this.guezivalue = guezivalue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuizeConfig that = (GuizeConfig) o;
        return id == that.id &&
                Objects.equals(guizename, that.guizename) &&
                Objects.equals(roomtype, that.roomtype) &&
                Objects.equals(guezivalue, that.guezivalue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guizename, roomtype, guezivalue);
    }
}
