/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Gamelog
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
public class Gamelog {
    private int id;
    private int roomNumber;
    private int playtype;
    private int gamechang;
    private int userid;
    private int score;
    private String playback;
    private Timestamp creattime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roomNumber")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "playtype")
    public int getPlaytype() {
        return playtype;
    }

    public void setPlaytype(int playtype) {
        this.playtype = playtype;
    }

    @Basic
    @Column(name = "gamechang")
    public int getGamechang() {
        return gamechang;
    }

    public void setGamechang(int gamechang) {
        this.gamechang = gamechang;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "playback")
    public String getPlayback() {
        return playback;
    }

    public void setPlayback(String playback) {
        this.playback = playback;
    }

    @Basic
    @Column(name = "creattime")
    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamelog gamelog = (Gamelog) o;
        return id == gamelog.id &&
                roomNumber == gamelog.roomNumber &&
                playtype == gamelog.playtype &&
                gamechang == gamelog.gamechang &&
                userid == gamelog.userid &&
                score == gamelog.score &&
                Objects.equals(playback, gamelog.playback) &&
                Objects.equals(creattime, gamelog.creattime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, playtype, gamechang, userid, score, playback, creattime);
    }
}
