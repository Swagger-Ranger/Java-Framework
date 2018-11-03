/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: GiveIntegralSettings
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
@Table(name = "give_integral_settings", schema = "yueba", catalog = "")
public class GiveIntegralSettings {
    private int id;
    private int number;
    private int amount;
    private int haveNumber;
    private int serial;
    private Timestamp start;
    private Timestamp end;
    private byte isOn;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "have_number")
    public int getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(int haveNumber) {
        this.haveNumber = haveNumber;
    }

    @Basic
    @Column(name = "serial")
    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "start")
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end")
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Basic
    @Column(name = "is_on")
    public byte getIsOn() {
        return isOn;
    }

    public void setIsOn(byte isOn) {
        this.isOn = isOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiveIntegralSettings that = (GiveIntegralSettings) o;
        return id == that.id &&
                number == that.number &&
                amount == that.amount &&
                haveNumber == that.haveNumber &&
                serial == that.serial &&
                isOn == that.isOn &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, amount, haveNumber, serial, start, end, isOn);
    }
}
