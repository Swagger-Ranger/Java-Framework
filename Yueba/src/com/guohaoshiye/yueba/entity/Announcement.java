/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Announcement
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
public class Announcement {
    private int id;
    private String title;
    private Integer noticestate;
    private Timestamp begintime;
    private Timestamp endtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "noticestate")
    public Integer getNoticestate() {
        return noticestate;
    }

    public void setNoticestate(Integer noticestate) {
        this.noticestate = noticestate;
    }

    @Basic
    @Column(name = "begintime")
    public Timestamp getBegintime() {
        return begintime;
    }

    public void setBegintime(Timestamp begintime) {
        this.begintime = begintime;
    }

    @Basic
    @Column(name = "endtime")
    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(noticestate, that.noticestate) &&
                Objects.equals(begintime, that.begintime) &&
                Objects.equals(endtime, that.endtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, noticestate, begintime, endtime);
    }
}
