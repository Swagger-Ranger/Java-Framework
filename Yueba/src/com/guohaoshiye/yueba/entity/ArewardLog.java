/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: ArewardLog
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
@Table(name = "areward_log", schema = "yueba", catalog = "")
public class ArewardLog {
    private int id;
    private int arewardpeople;
    private int beiarewardpeople;
    private int yuanbao;
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
    @Column(name = "arewardpeople")
    public int getArewardpeople() {
        return arewardpeople;
    }

    public void setArewardpeople(int arewardpeople) {
        this.arewardpeople = arewardpeople;
    }

    @Basic
    @Column(name = "beiarewardpeople")
    public int getBeiarewardpeople() {
        return beiarewardpeople;
    }

    public void setBeiarewardpeople(int beiarewardpeople) {
        this.beiarewardpeople = beiarewardpeople;
    }

    @Basic
    @Column(name = "yuanbao")
    public int getYuanbao() {
        return yuanbao;
    }

    public void setYuanbao(int yuanbao) {
        this.yuanbao = yuanbao;
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
        ArewardLog that = (ArewardLog) o;
        return id == that.id &&
                arewardpeople == that.arewardpeople &&
                beiarewardpeople == that.beiarewardpeople &&
                yuanbao == that.yuanbao &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, arewardpeople, beiarewardpeople, yuanbao, createtime);
    }
}
