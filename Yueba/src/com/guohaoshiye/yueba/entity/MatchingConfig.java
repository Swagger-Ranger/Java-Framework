/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: MatchingConfig
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "matching_config", schema = "yueba", catalog = "")
public class MatchingConfig {
    private int id;
    private int roomtype;
    private int ruchangfen;
    private int lichangfen;
    private int moshi;
    private int guizezuid;
    private int difen;
    private int changciid;
    private int isqiyong;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roomtype")
    public int getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    @Basic
    @Column(name = "ruchangfen")
    public int getRuchangfen() {
        return ruchangfen;
    }

    public void setRuchangfen(int ruchangfen) {
        this.ruchangfen = ruchangfen;
    }

    @Basic
    @Column(name = "lichangfen")
    public int getLichangfen() {
        return lichangfen;
    }

    public void setLichangfen(int lichangfen) {
        this.lichangfen = lichangfen;
    }

    @Basic
    @Column(name = "moshi")
    public int getMoshi() {
        return moshi;
    }

    public void setMoshi(int moshi) {
        this.moshi = moshi;
    }

    @Basic
    @Column(name = "guizezuid")
    public int getGuizezuid() {
        return guizezuid;
    }

    public void setGuizezuid(int guizezuid) {
        this.guizezuid = guizezuid;
    }

    @Basic
    @Column(name = "difen")
    public int getDifen() {
        return difen;
    }

    public void setDifen(int difen) {
        this.difen = difen;
    }

    @Basic
    @Column(name = "changciid")
    public int getChangciid() {
        return changciid;
    }

    public void setChangciid(int changciid) {
        this.changciid = changciid;
    }

    @Basic
    @Column(name = "isqiyong")
    public int getIsqiyong() {
        return isqiyong;
    }

    public void setIsqiyong(int isqiyong) {
        this.isqiyong = isqiyong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingConfig that = (MatchingConfig) o;
        return id == that.id &&
                roomtype == that.roomtype &&
                ruchangfen == that.ruchangfen &&
                lichangfen == that.lichangfen &&
                moshi == that.moshi &&
                guizezuid == that.guizezuid &&
                difen == that.difen &&
                changciid == that.changciid &&
                isqiyong == that.isqiyong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomtype, ruchangfen, lichangfen, moshi, guizezuid, difen, changciid, isqiyong);
    }
}
