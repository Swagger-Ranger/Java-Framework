/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: EmailType
 * Author:   liufei32@outlook.com
 * Date:     2018/11/1 16:06
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package com.guohaoshiye.yueba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "email_type", schema = "yueba", catalog = "")
public class EmailType {
    private int id;
    private Integer mailTypeId;
    private Integer mailTime;
    private Integer isSame;
    private Integer isTop;
    private Integer canDelete;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mail_type_id")
    public Integer getMailTypeId() {
        return mailTypeId;
    }

    public void setMailTypeId(Integer mailTypeId) {
        this.mailTypeId = mailTypeId;
    }

    @Basic
    @Column(name = "mail_time")
    public Integer getMailTime() {
        return mailTime;
    }

    public void setMailTime(Integer mailTime) {
        this.mailTime = mailTime;
    }

    @Basic
    @Column(name = "is_same")
    public Integer getIsSame() {
        return isSame;
    }

    public void setIsSame(Integer isSame) {
        this.isSame = isSame;
    }

    @Basic
    @Column(name = "is_top")
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    @Basic
    @Column(name = "can_delete")
    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailType emailType = (EmailType) o;
        return id == emailType.id &&
                Objects.equals(mailTypeId, emailType.mailTypeId) &&
                Objects.equals(mailTime, emailType.mailTime) &&
                Objects.equals(isSame, emailType.isSame) &&
                Objects.equals(isTop, emailType.isTop) &&
                Objects.equals(canDelete, emailType.canDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailTypeId, mailTime, isSame, isTop, canDelete);
    }
}
