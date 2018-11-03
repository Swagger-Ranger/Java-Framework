/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: AdminMenu
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_menu", schema = "yueba", catalog = "")
public class AdminMenu {
    private int id;
    private String title;
    private String url;
    private String spread;
    private String icon;
    private Integer rank;

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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "spread")
    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminMenu adminMenu = (AdminMenu) o;
        return id == adminMenu.id &&
                Objects.equals(title, adminMenu.title) &&
                Objects.equals(url, adminMenu.url) &&
                Objects.equals(spread, adminMenu.spread) &&
                Objects.equals(icon, adminMenu.icon) &&
                Objects.equals(rank, adminMenu.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url, spread, icon, rank);
    }
}
