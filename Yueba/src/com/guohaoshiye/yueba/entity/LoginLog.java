/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: LoginLog
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "login_log", schema = "yueba", catalog = "")
public class LoginLog {
    private int id;
    private Integer uid;
    private String logintime;
    private String signout;

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
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "logintime")
    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "signout")
    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLog loginLog = (LoginLog) o;
        return id == loginLog.id &&
                Objects.equals(uid, loginLog.uid) &&
                Objects.equals(logintime, loginLog.logintime) &&
                Objects.equals(signout, loginLog.signout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, logintime, signout);
    }
}
