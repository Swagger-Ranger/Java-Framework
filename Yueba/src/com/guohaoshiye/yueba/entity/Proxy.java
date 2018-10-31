 package com.guohaoshiye.yueba.entity;

 import java.io.Serializable;
 import java.sql.Timestamp;
 import java.util.ArrayList;
 import java.util.List;





 public class Proxy
   implements Serializable
 {
   private Integer id;
   private String account;
   private String password;
   private Integer pid;
   private Double integral;
   private String nickname;
   private String contactWay;
   private Integer proxyType;
   private Integer status;
   private Double ratio;
   private Timestamp logintime;
   private Timestamp createTime;
   private String trueName;
   private String phone;
   private Integer uid;
   private String erweimaUrl;
   private String promotionmapUrl;
   private Timestamp bindTime;
   private String head;
   private Integer yiji;
   private Integer erji;
   private Integer sanji;
   private Integer right;
   private Integer kg;
   private Integer isDisable;

   public Integer getIsDisable()
   {
     return this.isDisable;
   }

   public void setIsDisable(Integer isDisable) { this.isDisable = isDisable; }

   public Integer getKg()
   {
     return this.kg;
   }

   public void setKg(Integer kg) {
     this.kg = kg;
   }

   private List<Users> users = new ArrayList();




   public Proxy() {}



   public Proxy(String account, String password, Integer yiji, Integer erji, Integer sanji, Integer right)
   {
     this.account = account;
     this.password = password;
     this.yiji = yiji;
     this.erji = erji;
     this.sanji = sanji;
     this.right = right;
   }







   public Proxy(String account, String password, Integer pid, Double integral, String nickname, String contactWay, Integer proxyType, Integer status, Double ratio, Timestamp logintime, Timestamp createTime, String trueName, String phone, Integer uid, String erweimaUrl, String promotionmapUrl, Timestamp bindTime, String head, Integer yiji, Integer erji, Integer sanji, Integer right)
   {
     this.account = account;
     this.password = password;
     this.pid = pid;
     this.integral = integral;
     this.nickname = nickname;
     this.contactWay = contactWay;
     this.proxyType = proxyType;
     this.status = status;
     this.ratio = ratio;
     this.logintime = logintime;
     this.createTime = createTime;
     this.trueName = trueName;
     this.phone = phone;
     this.uid = uid;
     this.erweimaUrl = erweimaUrl;
     this.promotionmapUrl = promotionmapUrl;
     this.bindTime = bindTime;
     this.head = head;
     this.yiji = yiji;
     this.erji = erji;
     this.sanji = sanji;
     this.right = right;
   }





   public Proxy(String account, String password, Integer pid, Double integral, String nickname, String contactWay, Integer proxyType, Integer status, Double ratio, Timestamp logintime, Timestamp createTime, String trueName, String phone, Integer uid, String erweimaUrl, String promotionmapUrl, Timestamp bindTime, String head, Integer yiji, Integer erji, Integer sanji, Integer right, Integer isDisable)
   {
     this.account = account;
     this.password = password;
     this.pid = pid;
     this.integral = integral;
     this.nickname = nickname;
     this.contactWay = contactWay;
     this.proxyType = proxyType;
     this.status = status;
     this.ratio = ratio;
     this.logintime = logintime;
     this.createTime = createTime;
     this.trueName = trueName;
     this.phone = phone;
     this.uid = uid;
     this.erweimaUrl = erweimaUrl;
     this.promotionmapUrl = promotionmapUrl;
     this.bindTime = bindTime;
     this.head = head;
     this.yiji = yiji;
     this.erji = erji;
     this.sanji = sanji;
     this.right = right;
     this.isDisable = isDisable;
   }

   public Integer getId()
   {
     return this.id;
   }

   public void setId(Integer id) {
     this.id = id;
   }

   public String getAccount() {
     return this.account;
   }

   public void setAccount(String account) {
     this.account = account;
   }

   public String getPassword() {
     return this.password;
   }

   public void setPassword(String password) {
     this.password = password;
   }

   public Integer getPid() {
     return this.pid;
   }

   public void setPid(Integer pid) {
     this.pid = pid;
   }

   public Double getIntegral() {
     return this.integral;
   }

   public void setIntegral(Double integral) {
     this.integral = integral;
   }

   public String getNickname() {
     return this.nickname;
   }

   public void setNickname(String nickname) {
     this.nickname = nickname;
   }

   public String getContactWay() {
     return this.contactWay;
   }

   public void setContactWay(String contactWay) {
     this.contactWay = contactWay;
   }

   public Integer getProxyType() {
     return this.proxyType;
   }

   public void setProxyType(Integer proxyType) {
     this.proxyType = proxyType;
   }

   public Integer getStatus() {
     return this.status;
   }

   public void setStatus(Integer status) {
     this.status = status;
   }

   public Double getRatio() {
     return this.ratio;
   }

   public void setRatio(Double ratio) {
     this.ratio = ratio;
   }

   public Timestamp getLogintime() {
     return this.logintime;
   }

   public void setLogintime(Timestamp logintime) {
     this.logintime = logintime;
   }

   public Timestamp getCreateTime() {
     return this.createTime;
   }

   public void setCreateTime(Timestamp createTime) {
     this.createTime = createTime;
   }

   public String getTrueName() {
     return this.trueName;
   }

   public void setTrueName(String trueName) {
     this.trueName = trueName;
   }

   public String getPhone() {
     return this.phone;
   }

   public void setPhone(String phone) {
     this.phone = phone;
   }

   public Integer getUid() {
     return this.uid;
   }

   public void setUid(Integer uid) {
     this.uid = uid;
   }

   public String getErweimaUrl() {
     return this.erweimaUrl;
   }

   public void setErweimaUrl(String erweimaUrl) {
     this.erweimaUrl = erweimaUrl;
   }

   public String getPromotionmapUrl() {
     return this.promotionmapUrl;
   }

   public void setPromotionmapUrl(String promotionmapUrl) {
     this.promotionmapUrl = promotionmapUrl;
   }

   public Timestamp getBindTime() {
     return this.bindTime;
   }

   public void setBindTime(Timestamp bindTime) {
     this.bindTime = bindTime;
   }

   public String getHead() {
     return this.head;
   }

   public void setHead(String head) {
     this.head = head;
   }

   public Integer getYiji() {
     return this.yiji;
   }

   public void setYiji(Integer yiji) {
     this.yiji = yiji;
   }

   public Integer getErji() {
     return this.erji;
   }

   public void setErji(Integer erji) {
     this.erji = erji;
   }

   public Integer getSanji() {
     return this.sanji;
   }

   public void setSanji(Integer sanji) {
     this.sanji = sanji;
   }

   public Integer getRight() {
     return this.right;
   }

   public void setRight(Integer right) {
     this.right = right;
   }

   public List<Users> getUsers() {
     return this.users;
   }

   public void setUsers(List<Users> users) {
     this.users = users;
   }
 }

