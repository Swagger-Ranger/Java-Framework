/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: DailylandingGift
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
@Table(name = "dailylanding_gift", schema = "yueba", catalog = "")
public class DailylandingGift {
    private int id;
    private Integer userid;
    private Integer shuliang;
    private Integer leixing;
    private Timestamp gifttime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "shuliang")
    public Integer getShuliang() {
        return shuliang;
    }

    public void setShuliang(Integer shuliang) {
        this.shuliang = shuliang;
    }

    @Basic
    @Column(name = "leixing")
    public Integer getLeixing() {
        return leixing;
    }

    public void setLeixing(Integer leixing) {
        this.leixing = leixing;
    }

    @Basic
    @Column(name = "gifttime")
    public Timestamp getGifttime() {
        return gifttime;
    }

    public void setGifttime(Timestamp gifttime) {
        this.gifttime = gifttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailylandingGift that = (DailylandingGift) o;
        return id == that.id &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(shuliang, that.shuliang) &&
                Objects.equals(leixing, that.leixing) &&
                Objects.equals(gifttime, that.gifttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, shuliang, leixing, gifttime);
    }
}
