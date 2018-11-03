/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: NiuniugameLog
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
@Table(name = "niuniugame_log", schema = "yueba", catalog = "")
public class NiuniugameLog {
    private int id;
    private int roomId;
    private int tableId;
    private int tableNo;
    private String cards;
    private Integer fangzhuId;
    private int bankerId;
    private Timestamp createTime;
    private Integer difen;
    private int turn;
    private Integer zhuangbeishu;
    private Integer userid;
    private Integer win;
    private String userpai;
    private Integer useryabei;
    private Integer chanyu;
    private String kaifangshijian;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roomId")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "tableId")
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "tableNo")
    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
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
    @Column(name = "fangzhuId")
    public Integer getFangzhuId() {
        return fangzhuId;
    }

    public void setFangzhuId(Integer fangzhuId) {
        this.fangzhuId = fangzhuId;
    }

    @Basic
    @Column(name = "bankerId")
    public int getBankerId() {
        return bankerId;
    }

    public void setBankerId(int bankerId) {
        this.bankerId = bankerId;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "difen")
    public Integer getDifen() {
        return difen;
    }

    public void setDifen(Integer difen) {
        this.difen = difen;
    }

    @Basic
    @Column(name = "turn")
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    @Basic
    @Column(name = "zhuangbeishu")
    public Integer getZhuangbeishu() {
        return zhuangbeishu;
    }

    public void setZhuangbeishu(Integer zhuangbeishu) {
        this.zhuangbeishu = zhuangbeishu;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "win")
    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    @Basic
    @Column(name = "userpai")
    public String getUserpai() {
        return userpai;
    }

    public void setUserpai(String userpai) {
        this.userpai = userpai;
    }

    @Basic
    @Column(name = "useryabei")
    public Integer getUseryabei() {
        return useryabei;
    }

    public void setUseryabei(Integer useryabei) {
        this.useryabei = useryabei;
    }

    @Basic
    @Column(name = "chanyu")
    public Integer getChanyu() {
        return chanyu;
    }

    public void setChanyu(Integer chanyu) {
        this.chanyu = chanyu;
    }

    @Basic
    @Column(name = "kaifangshijian")
    public String getKaifangshijian() {
        return kaifangshijian;
    }

    public void setKaifangshijian(String kaifangshijian) {
        this.kaifangshijian = kaifangshijian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NiuniugameLog that = (NiuniugameLog) o;
        return id == that.id &&
                roomId == that.roomId &&
                tableId == that.tableId &&
                tableNo == that.tableNo &&
                bankerId == that.bankerId &&
                turn == that.turn &&
                Objects.equals(cards, that.cards) &&
                Objects.equals(fangzhuId, that.fangzhuId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(difen, that.difen) &&
                Objects.equals(zhuangbeishu, that.zhuangbeishu) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(win, that.win) &&
                Objects.equals(userpai, that.userpai) &&
                Objects.equals(useryabei, that.useryabei) &&
                Objects.equals(chanyu, that.chanyu) &&
                Objects.equals(kaifangshijian, that.kaifangshijian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, tableId, tableNo, cards, fangzhuId, bankerId, createTime, difen, turn, zhuangbeishu, userid, win, userpai, useryabei, chanyu, kaifangshijian);
    }
}
