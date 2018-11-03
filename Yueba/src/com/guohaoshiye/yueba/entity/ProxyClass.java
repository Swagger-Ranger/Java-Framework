/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: ProxyClass
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "proxy_class", schema = "yueba", catalog = "")
public class ProxyClass {
    private int id;
    private int pid;
    private int clazz;
    private long times;
    private int yikai;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "clazz")
    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "times")
    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    @Basic
    @Column(name = "yikai")
    public int getYikai() {
        return yikai;
    }

    public void setYikai(int yikai) {
        this.yikai = yikai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyClass that = (ProxyClass) o;
        return id == that.id &&
                pid == that.pid &&
                clazz == that.clazz &&
                times == that.times &&
                yikai == that.yikai;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, clazz, times, yikai);
    }
}
