/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: GameAlllog
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
@Table(name = "game_alllog", schema = "yueba", catalog = "")
public class GameAlllog {
    private int id;
    private int roomNumber;
    private int playtype;
    private int gamechang;
    private int bankerid;
    private String alluserid;
    private String player;
    private String playback;
    private String cards;
    private Timestamp creattime;
    private String haomiao;

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
    @Column(name = "bankerid")
    public int getBankerid() {
        return bankerid;
    }

    public void setBankerid(int bankerid) {
        this.bankerid = bankerid;
    }

    @Basic
    @Column(name = "alluserid")
    public String getAlluserid() {
        return alluserid;
    }

    public void setAlluserid(String alluserid) {
        this.alluserid = alluserid;
    }

    @Basic
    @Column(name = "player")
    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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
    @Column(name = "cards")
    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    @Basic
    @Column(name = "creattime")
    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    @Basic
    @Column(name = "haomiao")
    public String getHaomiao() {
        return haomiao;
    }

    public void setHaomiao(String haomiao) {
        this.haomiao = haomiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameAlllog that = (GameAlllog) o;
        return id == that.id &&
                roomNumber == that.roomNumber &&
                playtype == that.playtype &&
                gamechang == that.gamechang &&
                bankerid == that.bankerid &&
                Objects.equals(alluserid, that.alluserid) &&
                Objects.equals(player, that.player) &&
                Objects.equals(playback, that.playback) &&
                Objects.equals(cards, that.cards) &&
                Objects.equals(creattime, that.creattime) &&
                Objects.equals(haomiao, that.haomiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, playtype, gamechang, bankerid, alluserid, player, playback, cards, creattime, haomiao);
    }
}
