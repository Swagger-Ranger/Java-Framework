/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Accept
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
import java.util.Objects;

@Entity
public class Accept {
    private int id;
    private int acceptcondition;
    private String otherconditions;
    private String describe;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acceptcondition")
    public int getAcceptcondition() {
        return acceptcondition;
    }

    public void setAcceptcondition(int acceptcondition) {
        this.acceptcondition = acceptcondition;
    }

    @Basic
    @Column(name = "otherconditions")
    public String getOtherconditions() {
        return otherconditions;
    }

    public void setOtherconditions(String otherconditions) {
        this.otherconditions = otherconditions;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accept accept = (Accept) o;
        return id == accept.id &&
                acceptcondition == accept.acceptcondition &&
                Objects.equals(otherconditions, accept.otherconditions) &&
                Objects.equals(describe, accept.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acceptcondition, otherconditions, describe);
    }
}
