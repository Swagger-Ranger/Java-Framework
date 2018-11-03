/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: ChangciConfig
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "changci_config", schema = "yueba", catalog = "")
public class ChangciConfig {
    private int id;
    private String changchiname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "changchiname")
    public String getChangchiname() {
        return changchiname;
    }

    public void setChangchiname(String changchiname) {
        this.changchiname = changchiname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangciConfig that = (ChangciConfig) o;
        return id == that.id &&
                Objects.equals(changchiname, that.changchiname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, changchiname);
    }
}
