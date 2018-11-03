/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: ProxyNum
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "proxy_num", schema = "yueba", catalog = "")
public class ProxyNum {
    private int id;
    private int yiji;
    private int erji;
    private int sanji;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "yiji")
    public int getYiji() {
        return yiji;
    }

    public void setYiji(int yiji) {
        this.yiji = yiji;
    }

    @Basic
    @Column(name = "erji")
    public int getErji() {
        return erji;
    }

    public void setErji(int erji) {
        this.erji = erji;
    }

    @Basic
    @Column(name = "sanji")
    public int getSanji() {
        return sanji;
    }

    public void setSanji(int sanji) {
        this.sanji = sanji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyNum proxyNum = (ProxyNum) o;
        return id == proxyNum.id &&
                yiji == proxyNum.yiji &&
                erji == proxyNum.erji &&
                sanji == proxyNum.sanji;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yiji, erji, sanji);
    }
}
