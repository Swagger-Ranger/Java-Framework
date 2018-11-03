/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Checkcode
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
public class Checkcode {
    private int id;
    private int userid;
    private String phone;
    private int checkcode;
    private Timestamp createtime;

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
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "checkcode")
    public int getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(int checkcode) {
        this.checkcode = checkcode;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkcode checkcode1 = (Checkcode) o;
        return id == checkcode1.id &&
                userid == checkcode1.userid &&
                checkcode == checkcode1.checkcode &&
                Objects.equals(phone, checkcode1.phone) &&
                Objects.equals(createtime, checkcode1.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, phone, checkcode, createtime);
    }
}
