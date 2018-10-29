/*     */ package com.aiwan.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Proxy
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String account;
/*     */   private String password;
/*     */   private Integer pid;
/*     */   private Double integral;
/*     */   private String nickname;
/*     */   private String contactWay;
/*     */   private Integer proxyType;
/*     */   private Integer status;
/*     */   private Double ratio;
/*     */   private Timestamp logintime;
/*     */   private Timestamp createTime;
/*     */   private String trueName;
/*     */   private String phone;
/*     */   private Integer uid;
/*     */   private String erweimaUrl;
/*     */   private String promotionmapUrl;
/*     */   private Timestamp bindTime;
/*     */   private String head;
/*     */   private Integer yiji;
/*     */   private Integer erji;
/*     */   private Integer sanji;
/*     */   private Integer right;
/*     */   private Integer kg;
/*     */   private Integer isDisable;
/*     */   
/*     */   public Integer getIsDisable()
/*     */   {
/*  43 */     return this.isDisable;
/*     */   }
/*     */   
/*  46 */   public void setIsDisable(Integer isDisable) { this.isDisable = isDisable; }
/*     */   
/*     */   public Integer getKg()
/*     */   {
/*  50 */     return this.kg;
/*     */   }
/*     */   
/*     */   public void setKg(Integer kg) {
/*  54 */     this.kg = kg;
/*     */   }
/*     */   
/*  57 */   private List<Users> users = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Proxy() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Proxy(String account, String password, Integer yiji, Integer erji, Integer sanji, Integer right)
/*     */   {
/*  68 */     this.account = account;
/*  69 */     this.password = password;
/*  70 */     this.yiji = yiji;
/*  71 */     this.erji = erji;
/*  72 */     this.sanji = sanji;
/*  73 */     this.right = right;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Proxy(String account, String password, Integer pid, Double integral, String nickname, String contactWay, Integer proxyType, Integer status, Double ratio, Timestamp logintime, Timestamp createTime, String trueName, String phone, Integer uid, String erweimaUrl, String promotionmapUrl, Timestamp bindTime, String head, Integer yiji, Integer erji, Integer sanji, Integer right)
/*     */   {
/*  84 */     this.account = account;
/*  85 */     this.password = password;
/*  86 */     this.pid = pid;
/*  87 */     this.integral = integral;
/*  88 */     this.nickname = nickname;
/*  89 */     this.contactWay = contactWay;
/*  90 */     this.proxyType = proxyType;
/*  91 */     this.status = status;
/*  92 */     this.ratio = ratio;
/*  93 */     this.logintime = logintime;
/*  94 */     this.createTime = createTime;
/*  95 */     this.trueName = trueName;
/*  96 */     this.phone = phone;
/*  97 */     this.uid = uid;
/*  98 */     this.erweimaUrl = erweimaUrl;
/*  99 */     this.promotionmapUrl = promotionmapUrl;
/* 100 */     this.bindTime = bindTime;
/* 101 */     this.head = head;
/* 102 */     this.yiji = yiji;
/* 103 */     this.erji = erji;
/* 104 */     this.sanji = sanji;
/* 105 */     this.right = right;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Proxy(String account, String password, Integer pid, Double integral, String nickname, String contactWay, Integer proxyType, Integer status, Double ratio, Timestamp logintime, Timestamp createTime, String trueName, String phone, Integer uid, String erweimaUrl, String promotionmapUrl, Timestamp bindTime, String head, Integer yiji, Integer erji, Integer sanji, Integer right, Integer isDisable)
/*     */   {
/* 114 */     this.account = account;
/* 115 */     this.password = password;
/* 116 */     this.pid = pid;
/* 117 */     this.integral = integral;
/* 118 */     this.nickname = nickname;
/* 119 */     this.contactWay = contactWay;
/* 120 */     this.proxyType = proxyType;
/* 121 */     this.status = status;
/* 122 */     this.ratio = ratio;
/* 123 */     this.logintime = logintime;
/* 124 */     this.createTime = createTime;
/* 125 */     this.trueName = trueName;
/* 126 */     this.phone = phone;
/* 127 */     this.uid = uid;
/* 128 */     this.erweimaUrl = erweimaUrl;
/* 129 */     this.promotionmapUrl = promotionmapUrl;
/* 130 */     this.bindTime = bindTime;
/* 131 */     this.head = head;
/* 132 */     this.yiji = yiji;
/* 133 */     this.erji = erji;
/* 134 */     this.sanji = sanji;
/* 135 */     this.right = right;
/* 136 */     this.isDisable = isDisable;
/*     */   }
/*     */   
/*     */   public Integer getId()
/*     */   {
/* 141 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/* 145 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/* 149 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/* 153 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 157 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 161 */     this.password = password;
/*     */   }
/*     */   
/*     */   public Integer getPid() {
/* 165 */     return this.pid;
/*     */   }
/*     */   
/*     */   public void setPid(Integer pid) {
/* 169 */     this.pid = pid;
/*     */   }
/*     */   
/*     */   public Double getIntegral() {
/* 173 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Double integral) {
/* 177 */     this.integral = integral;
/*     */   }
/*     */   
/*     */   public String getNickname() {
/* 181 */     return this.nickname;
/*     */   }
/*     */   
/*     */   public void setNickname(String nickname) {
/* 185 */     this.nickname = nickname;
/*     */   }
/*     */   
/*     */   public String getContactWay() {
/* 189 */     return this.contactWay;
/*     */   }
/*     */   
/*     */   public void setContactWay(String contactWay) {
/* 193 */     this.contactWay = contactWay;
/*     */   }
/*     */   
/*     */   public Integer getProxyType() {
/* 197 */     return this.proxyType;
/*     */   }
/*     */   
/*     */   public void setProxyType(Integer proxyType) {
/* 201 */     this.proxyType = proxyType;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 205 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 209 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Double getRatio() {
/* 213 */     return this.ratio;
/*     */   }
/*     */   
/*     */   public void setRatio(Double ratio) {
/* 217 */     this.ratio = ratio;
/*     */   }
/*     */   
/*     */   public Timestamp getLogintime() {
/* 221 */     return this.logintime;
/*     */   }
/*     */   
/*     */   public void setLogintime(Timestamp logintime) {
/* 225 */     this.logintime = logintime;
/*     */   }
/*     */   
/*     */   public Timestamp getCreateTime() {
/* 229 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Timestamp createTime) {
/* 233 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getTrueName() {
/* 237 */     return this.trueName;
/*     */   }
/*     */   
/*     */   public void setTrueName(String trueName) {
/* 241 */     this.trueName = trueName;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 245 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 249 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public Integer getUid() {
/* 253 */     return this.uid;
/*     */   }
/*     */   
/*     */   public void setUid(Integer uid) {
/* 257 */     this.uid = uid;
/*     */   }
/*     */   
/*     */   public String getErweimaUrl() {
/* 261 */     return this.erweimaUrl;
/*     */   }
/*     */   
/*     */   public void setErweimaUrl(String erweimaUrl) {
/* 265 */     this.erweimaUrl = erweimaUrl;
/*     */   }
/*     */   
/*     */   public String getPromotionmapUrl() {
/* 269 */     return this.promotionmapUrl;
/*     */   }
/*     */   
/*     */   public void setPromotionmapUrl(String promotionmapUrl) {
/* 273 */     this.promotionmapUrl = promotionmapUrl;
/*     */   }
/*     */   
/*     */   public Timestamp getBindTime() {
/* 277 */     return this.bindTime;
/*     */   }
/*     */   
/*     */   public void setBindTime(Timestamp bindTime) {
/* 281 */     this.bindTime = bindTime;
/*     */   }
/*     */   
/*     */   public String getHead() {
/* 285 */     return this.head;
/*     */   }
/*     */   
/*     */   public void setHead(String head) {
/* 289 */     this.head = head;
/*     */   }
/*     */   
/*     */   public Integer getYiji() {
/* 293 */     return this.yiji;
/*     */   }
/*     */   
/*     */   public void setYiji(Integer yiji) {
/* 297 */     this.yiji = yiji;
/*     */   }
/*     */   
/*     */   public Integer getErji() {
/* 301 */     return this.erji;
/*     */   }
/*     */   
/*     */   public void setErji(Integer erji) {
/* 305 */     this.erji = erji;
/*     */   }
/*     */   
/*     */   public Integer getSanji() {
/* 309 */     return this.sanji;
/*     */   }
/*     */   
/*     */   public void setSanji(Integer sanji) {
/* 313 */     this.sanji = sanji;
/*     */   }
/*     */   
/*     */   public Integer getRight() {
/* 317 */     return this.right;
/*     */   }
/*     */   
/*     */   public void setRight(Integer right) {
/* 321 */     this.right = right;
/*     */   }
/*     */   
/*     */   public List<Users> getUsers() {
/* 325 */     return this.users;
/*     */   }
/*     */   
/*     */   public void setUsers(List<Users> users) {
/* 329 */     this.users = users;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Proxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */