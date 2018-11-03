/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: AdminRole
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_role", schema = "yueba", catalog = "")
public class AdminRole {
    private int id;
    private int aid;
    private int caidanid;
    private String op;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "caidanid")
    public int getCaidanid() {
        return caidanid;
    }

    public void setCaidanid(int caidanid) {
        this.caidanid = caidanid;
    }

    @Basic
    @Column(name = "op")
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return id == adminRole.id &&
                aid == adminRole.aid &&
                caidanid == adminRole.caidanid &&
                Objects.equals(op, adminRole.op);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aid, caidanid, op);
    }
}
