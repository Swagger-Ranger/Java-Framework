/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Complete
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
public class Complete {
    private int id;
    private int completecondition;
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
    @Column(name = "completecondition")
    public int getCompletecondition() {
        return completecondition;
    }

    public void setCompletecondition(int completecondition) {
        this.completecondition = completecondition;
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
        Complete complete = (Complete) o;
        return id == complete.id &&
                completecondition == complete.completecondition &&
                Objects.equals(otherconditions, complete.otherconditions) &&
                Objects.equals(describe, complete.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, completecondition, otherconditions, describe);
    }
}
