/*     */ package com.aiwan.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Robot
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String account;
/*     */   private String password;
/*     */   private String nickname;
/*     */   private Short type;
/*     */   private Short sex;
/*     */   private String head;
/*     */   private Short headType;
/*     */   private Integer gold;
/*     */   private Integer diamonds;
/*     */   private Integer integral;
/*     */   private Short status;
/*     */   private String ip;
/*     */   private Timestamp logintime;
/*     */   private Timestamp createtime;
/*     */   private Integer everydaysign;
/*     */   private Integer pid;
/*     */   private String autograph;
/*     */   
/*     */   public Robot() {}
/*     */   
/*     */   public Robot(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, String ip, Timestamp logintime, Timestamp createtime, Integer everydaysign, Integer pid, String autograph)
/*     */   {
/*  45 */     this.account = account;
/*  46 */     this.password = password;
/*  47 */     this.nickname = nickname;
/*  48 */     this.type = type;
/*  49 */     this.sex = sex;
/*  50 */     this.head = head;
/*  51 */     this.headType = headType;
/*  52 */     this.gold = gold;
/*  53 */     this.diamonds = diamonds;
/*  54 */     this.integral = integral;
/*  55 */     this.status = status;
/*  56 */     this.ip = ip;
/*  57 */     this.logintime = logintime;
/*  58 */     this.createtime = createtime;
/*  59 */     this.everydaysign = everydaysign;
/*  60 */     this.pid = pid;
/*  61 */     this.autograph = autograph;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  67 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/*  75 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/*  79 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  83 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  87 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getNickname() {
/*  91 */     return this.nickname;
/*     */   }
/*     */   
/*     */   public void setNickname(String nickname) {
/*  95 */     this.nickname = nickname;
/*     */   }
/*     */   
/*     */   public Short getType() {
/*  99 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Short type) {
/* 103 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Short getSex() {
/* 107 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(Short sex) {
/* 111 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getHead() {
/* 115 */     return this.head;
/*     */   }
/*     */   
/*     */   public void setHead(String head) {
/* 119 */     this.head = head;
/*     */   }
/*     */   
/*     */   public Short getHeadType() {
/* 123 */     return this.headType;
/*     */   }
/*     */   
/*     */   public void setHeadType(Short headType) {
/* 127 */     this.headType = headType;
/*     */   }
/*     */   
/*     */   public Integer getGold() {
/* 131 */     return this.gold;
/*     */   }
/*     */   
/*     */   public void setGold(Integer gold) {
/* 135 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   public Integer getDiamonds() {
/* 139 */     return this.diamonds;
/*     */   }
/*     */   
/*     */   public void setDiamonds(Integer diamonds) {
/* 143 */     this.diamonds = diamonds;
/*     */   }
/*     */   
/*     */   public Integer getIntegral() {
/* 147 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Integer integral) {
/* 151 */     this.integral = integral;
/*     */   }
/*     */   
/*     */   public Short getStatus() {
/* 155 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Short status) {
/* 159 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getIp() {
/* 163 */     return this.ip;
/*     */   }
/*     */   
/*     */   public void setIp(String ip) {
/* 167 */     this.ip = ip;
/*     */   }
/*     */   
/*     */   public Timestamp getLogintime() {
/* 171 */     return this.logintime;
/*     */   }
/*     */   
/*     */   public void setLogintime(Timestamp logintime) {
/* 175 */     this.logintime = logintime;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatetime() {
/* 179 */     return this.createtime;
/*     */   }
/*     */   
/*     */   public void setCreatetime(Timestamp createtime) {
/* 183 */     this.createtime = createtime;
/*     */   }
/*     */   
/*     */   public Integer getEverydaysign() {
/* 187 */     return this.everydaysign;
/*     */   }
/*     */   
/*     */   public void setEverydaysign(Integer everydaysign) {
/* 191 */     this.everydaysign = everydaysign;
/*     */   }
/*     */   
/*     */   public Integer getPid() {
/* 195 */     return this.pid;
/*     */   }
/*     */   
/*     */   public void setPid(Integer pid) {
/* 199 */     this.pid = pid;
/*     */   }
/*     */   
/*     */   public String getAutograph() {
/* 203 */     return this.autograph;
/*     */   }
/*     */   
/*     */   public void setAutograph(String autograph) {
/* 207 */     this.autograph = autograph;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Robot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */