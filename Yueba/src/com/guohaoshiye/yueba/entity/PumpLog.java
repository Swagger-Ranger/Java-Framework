/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: PumpLog
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
@Table(name = "pump_log", schema = "yueba", catalog = "")
public class PumpLog {
    private int id;
    private int uid;
    private Integer tableid;
    private Integer tabletype;
    private Integer gamechang;
    private Integer isbanker;
    private String allpump;
    private String pingtaipump;
    private Integer oneproxyid;
    private String oneproxypump;
    private String pingtaione;
    private Integer twoproxyid;
    private String twoproxypump;
    private String pingtaitwo;
    private Integer threeproxyid;
    private String threeproxypump;
    private String pingtaithree;
    private Timestamp createtime;
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
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "tableid")
    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    @Basic
    @Column(name = "tabletype")
    public Integer getTabletype() {
        return tabletype;
    }

    public void setTabletype(Integer tabletype) {
        this.tabletype = tabletype;
    }

    @Basic
    @Column(name = "gamechang")
    public Integer getGamechang() {
        return gamechang;
    }

    public void setGamechang(Integer gamechang) {
        this.gamechang = gamechang;
    }

    @Basic
    @Column(name = "isbanker")
    public Integer getIsbanker() {
        return isbanker;
    }

    public void setIsbanker(Integer isbanker) {
        this.isbanker = isbanker;
    }

    @Basic
    @Column(name = "allpump")
    public String getAllpump() {
        return allpump;
    }

    public void setAllpump(String allpump) {
        this.allpump = allpump;
    }

    @Basic
    @Column(name = "pingtaipump")
    public String getPingtaipump() {
        return pingtaipump;
    }

    public void setPingtaipump(String pingtaipump) {
        this.pingtaipump = pingtaipump;
    }

    @Basic
    @Column(name = "oneproxyid")
    public Integer getOneproxyid() {
        return oneproxyid;
    }

    public void setOneproxyid(Integer oneproxyid) {
        this.oneproxyid = oneproxyid;
    }

    @Basic
    @Column(name = "oneproxypump")
    public String getOneproxypump() {
        return oneproxypump;
    }

    public void setOneproxypump(String oneproxypump) {
        this.oneproxypump = oneproxypump;
    }

    @Basic
    @Column(name = "pingtaione")
    public String getPingtaione() {
        return pingtaione;
    }

    public void setPingtaione(String pingtaione) {
        this.pingtaione = pingtaione;
    }

    @Basic
    @Column(name = "twoproxyid")
    public Integer getTwoproxyid() {
        return twoproxyid;
    }

    public void setTwoproxyid(Integer twoproxyid) {
        this.twoproxyid = twoproxyid;
    }

    @Basic
    @Column(name = "twoproxypump")
    public String getTwoproxypump() {
        return twoproxypump;
    }

    public void setTwoproxypump(String twoproxypump) {
        this.twoproxypump = twoproxypump;
    }

    @Basic
    @Column(name = "pingtaitwo")
    public String getPingtaitwo() {
        return pingtaitwo;
    }

    public void setPingtaitwo(String pingtaitwo) {
        this.pingtaitwo = pingtaitwo;
    }

    @Basic
    @Column(name = "threeproxyid")
    public Integer getThreeproxyid() {
        return threeproxyid;
    }

    public void setThreeproxyid(Integer threeproxyid) {
        this.threeproxyid = threeproxyid;
    }

    @Basic
    @Column(name = "threeproxypump")
    public String getThreeproxypump() {
        return threeproxypump;
    }

    public void setThreeproxypump(String threeproxypump) {
        this.threeproxypump = threeproxypump;
    }

    @Basic
    @Column(name = "pingtaithree")
    public String getPingtaithree() {
        return pingtaithree;
    }

    public void setPingtaithree(String pingtaithree) {
        this.pingtaithree = pingtaithree;
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
        PumpLog pumpLog = (PumpLog) o;
        return id == pumpLog.id &&
                uid == pumpLog.uid &&
                Objects.equals(tableid, pumpLog.tableid) &&
                Objects.equals(tabletype, pumpLog.tabletype) &&
                Objects.equals(gamechang, pumpLog.gamechang) &&
                Objects.equals(isbanker, pumpLog.isbanker) &&
                Objects.equals(allpump, pumpLog.allpump) &&
                Objects.equals(pingtaipump, pumpLog.pingtaipump) &&
                Objects.equals(oneproxyid, pumpLog.oneproxyid) &&
                Objects.equals(oneproxypump, pumpLog.oneproxypump) &&
                Objects.equals(pingtaione, pumpLog.pingtaione) &&
                Objects.equals(twoproxyid, pumpLog.twoproxyid) &&
                Objects.equals(twoproxypump, pumpLog.twoproxypump) &&
                Objects.equals(pingtaitwo, pumpLog.pingtaitwo) &&
                Objects.equals(threeproxyid, pumpLog.threeproxyid) &&
                Objects.equals(threeproxypump, pumpLog.threeproxypump) &&
                Objects.equals(pingtaithree, pumpLog.pingtaithree) &&
                Objects.equals(createtime, pumpLog.createtime) &&
                Objects.equals(haomiao, pumpLog.haomiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, tableid, tabletype, gamechang, isbanker, allpump, pingtaipump, oneproxyid, oneproxypump, pingtaione, twoproxyid, twoproxypump, pingtaitwo, threeproxyid, threeproxypump, pingtaithree, createtime, haomiao);
    }
}
