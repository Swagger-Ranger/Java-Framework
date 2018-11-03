/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: RewardLog
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
@Table(name = "reward_log", schema = "yueba", catalog = "")
public class RewardLog {
    private int id;
    private String userId;
    private Integer gold;
    private Integer diamonds;
    private Integer integral;
    private String reward;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "gold")
    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Basic
    @Column(name = "diamonds")
    public Integer getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(Integer diamonds) {
        this.diamonds = diamonds;
    }

    @Basic
    @Column(name = "integral")
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "reward")
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardLog rewardLog = (RewardLog) o;
        return id == rewardLog.id &&
                Objects.equals(userId, rewardLog.userId) &&
                Objects.equals(gold, rewardLog.gold) &&
                Objects.equals(diamonds, rewardLog.diamonds) &&
                Objects.equals(integral, rewardLog.integral) &&
                Objects.equals(reward, rewardLog.reward) &&
                Objects.equals(createTime, rewardLog.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, gold, diamonds, integral, reward, createTime);
    }
}
