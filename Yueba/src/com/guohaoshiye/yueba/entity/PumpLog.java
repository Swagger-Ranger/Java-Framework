package com.guohaoshiye.yueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PumpLog
  implements Serializable
{
  private Integer id;
  private Integer uid;
  private Integer tableid;
  private Integer tabletype;
  private Integer gamechang;
  private Integer isbanker;
  private String allpump;
  private String pingtaipump;
  private Integer oneproxyid;
  private String oneproxypump;
  private String pingtaione;
  private Integer twoproxyid;
  private String twoproxypump;
  private String pingtaitwo;
  private Integer threeproxyid;
  private String threeproxypump;
  private String pingtaithree;
  private Timestamp createtime;
  private String haomiao;

  public PumpLog() {}

  public PumpLog(Integer uid, String allpump, String pingtaipump)
  {
    this.uid = uid;
    this.allpump = allpump;
    this.pingtaipump = pingtaipump;
  }






  public PumpLog(Integer uid, Integer tableid, Integer tabletype, Integer gamechang, Integer isbanker, String allpump, String pingtaipump, Integer oneproxyid, String oneproxypump, String pingtaione, Integer twoproxyid, String twoproxypump, String pingtaitwo, Integer threeproxyid, String threeproxypump, String pingtaithree, Timestamp createtime, String haomiao)
  {
    this.uid = uid;
    this.tableid = tableid;
    this.tabletype = tabletype;
    this.gamechang = gamechang;
    this.isbanker = isbanker;
    this.allpump = allpump;
    this.pingtaipump = pingtaipump;
    this.oneproxyid = oneproxyid;
    this.oneproxypump = oneproxypump;
    this.pingtaione = pingtaione;
    this.twoproxyid = twoproxyid;
    this.twoproxypump = twoproxypump;
    this.pingtaitwo = pingtaitwo;
    this.threeproxyid = threeproxyid;
    this.threeproxypump = threeproxypump;
    this.pingtaithree = pingtaithree;
    this.createtime = createtime;
    this.haomiao = haomiao;
  }


  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return this.uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getTableid() {
    return this.tableid;
  }

  public void setTableid(Integer tableid) {
    this.tableid = tableid;
  }

  public Integer getTabletype() {
    return this.tabletype;
  }

  public void setTabletype(Integer tabletype) {
    this.tabletype = tabletype;
  }

  public Integer getGamechang() {
    return this.gamechang;
  }

  public void setGamechang(Integer gamechang) {
    this.gamechang = gamechang;
  }

  public Integer getIsbanker() {
    return this.isbanker;
  }

  public void setIsbanker(Integer isbanker) {
    this.isbanker = isbanker;
  }

  public String getAllpump() {
    return this.allpump;
  }

  public void setAllpump(String allpump) {
    this.allpump = allpump;
  }

  public String getPingtaipump() {
    return this.pingtaipump;
  }

  public void setPingtaipump(String pingtaipump) {
    this.pingtaipump = pingtaipump;
  }

  public Integer getOneproxyid() {
    return this.oneproxyid;
  }

  public void setOneproxyid(Integer oneproxyid) {
    this.oneproxyid = oneproxyid;
  }

  public String getOneproxypump() {
    return this.oneproxypump;
  }

  public void setOneproxypump(String oneproxypump) {
    this.oneproxypump = oneproxypump;
  }

  public String getPingtaione() {
    return this.pingtaione;
  }

  public void setPingtaione(String pingtaione) {
    this.pingtaione = pingtaione;
  }

  public Integer getTwoproxyid() {
    return this.twoproxyid;
  }

  public void setTwoproxyid(Integer twoproxyid) {
    this.twoproxyid = twoproxyid;
  }

  public String getTwoproxypump() {
    return this.twoproxypump;
  }

  public void setTwoproxypump(String twoproxypump) {
    this.twoproxypump = twoproxypump;
  }

  public String getPingtaitwo() {
    return this.pingtaitwo;
  }

  public void setPingtaitwo(String pingtaitwo) {
    this.pingtaitwo = pingtaitwo;
  }

  public Integer getThreeproxyid() {
    return this.threeproxyid;
  }

  public void setThreeproxyid(Integer threeproxyid) {
    this.threeproxyid = threeproxyid;
  }

  public String getThreeproxypump() {
    return this.threeproxypump;
  }

  public void setThreeproxypump(String threeproxypump) {
    this.threeproxypump = threeproxypump;
  }

  public String getPingtaithree() {
    return this.pingtaithree;
  }

  public void setPingtaithree(String pingtaithree) {
    this.pingtaithree = pingtaithree;
  }

  public Timestamp getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public String getHaomiao() {
    return this.haomiao;
  }

  public void setHaomiao(String haomiao) {
    this.haomiao = haomiao;
  }
}

