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
/*     */ public class Users
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
/*     */   private Integer charm;
/*     */   private Integer victorycount;
/*     */   private String prop;
/*     */   private String task;
/*     */   private String idNumber;
/*     */   private String realName;
/*     */   private Integer warehouseDiamonds;
/*     */   private Integer warehouseIntegral;
/*     */   
/*     */   public Users() {}
/*     */   
/*     */   public Users(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, Timestamp logintime, Timestamp createtime, String prop, String task, Integer warehouseDiamonds, Integer warehouseIntegral)
/*     */   {
/*  53 */     this.account = account;
/*  54 */     this.password = password;
/*  55 */     this.nickname = nickname;
/*  56 */     this.type = type;
/*  57 */     this.sex = sex;
/*  58 */     this.head = head;
/*  59 */     this.headType = headType;
/*  60 */     this.gold = gold;
/*  61 */     this.diamonds = diamonds;
/*  62 */     this.integral = integral;
/*  63 */     this.status = status;
/*  64 */     this.logintime = logintime;
/*  65 */     this.createtime = createtime;
/*  66 */     this.prop = prop;
/*  67 */     this.task = task;
/*  68 */     this.warehouseDiamonds = warehouseDiamonds;
/*  69 */     this.warehouseIntegral = warehouseIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Users(String account, String password, String nickname, Short type, Short sex, String head, Short headType, Integer gold, Integer diamonds, Integer integral, Short status, String ip, Timestamp logintime, Timestamp createtime, Integer everydaysign, Integer pid, String autograph, Integer charm, Integer victorycount, String prop, String task, String idNumber, String realName, Integer warehouseDiamonds, Integer warehouseIntegral)
/*     */   {
/*  80 */     this.account = account;
/*  81 */     this.password = password;
/*  82 */     this.nickname = nickname;
/*  83 */     this.type = type;
/*  84 */     this.sex = sex;
/*  85 */     this.head = head;
/*  86 */     this.headType = headType;
/*  87 */     this.gold = gold;
/*  88 */     this.diamonds = diamonds;
/*  89 */     this.integral = integral;
/*  90 */     this.status = status;
/*  91 */     this.ip = ip;
/*  92 */     this.logintime = logintime;
/*  93 */     this.createtime = createtime;
/*  94 */     this.everydaysign = everydaysign;
/*  95 */     this.pid = pid;
/*  96 */     this.autograph = autograph;
/*  97 */     this.charm = charm;
/*  98 */     this.victorycount = victorycount;
/*  99 */     this.prop = prop;
/* 100 */     this.task = task;
/* 101 */     this.idNumber = idNumber;
/* 102 */     this.realName = realName;
/* 103 */     this.warehouseDiamonds = warehouseDiamonds;
/* 104 */     this.warehouseIntegral = warehouseIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 110 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/* 114 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/* 118 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/* 122 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 126 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 130 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getNickname() {
/* 134 */     return this.nickname;
/*     */   }
/*     */   
/*     */   public void setNickname(String nickname) {
/* 138 */     this.nickname = nickname;
/*     */   }
/*     */   
/*     */   public Short getType() {
/* 142 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Short type) {
/* 146 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Short getSex() {
/* 150 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(Short sex) {
/* 154 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getHead() {
/* 158 */     return this.head;
/*     */   }
/*     */   
/*     */   public void setHead(String head) {
/* 162 */     this.head = head;
/*     */   }
/*     */   
/*     */   public Short getHeadType() {
/* 166 */     return this.headType;
/*     */   }
/*     */   
/*     */   public void setHeadType(Short headType) {
/* 170 */     this.headType = headType;
/*     */   }
/*     */   
/*     */   public Integer getGold() {
/* 174 */     return this.gold;
/*     */   }
/*     */   
/*     */   public void setGold(Integer gold) {
/* 178 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   public Integer getDiamonds() {
/* 182 */     return this.diamonds;
/*     */   }
/*     */   
/*     */   public void setDiamonds(Integer diamonds) {
/* 186 */     this.diamonds = diamonds;
/*     */   }
/*     */   
/*     */   public Integer getIntegral() {
/* 190 */     return this.integral;
/*     */   }
/*     */   
/*     */   public void setIntegral(Integer integral) {
/* 194 */     this.integral = integral;
/*     */   }
/*     */   
/*     */   public Short getStatus() {
/* 198 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Short status) {
/* 202 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getIp() {
/* 206 */     return this.ip;
/*     */   }
/*     */   
/*     */   public void setIp(String ip) {
/* 210 */     this.ip = ip;
/*     */   }
/*     */   
/*     */   public Timestamp getLogintime() {
/* 214 */     return this.logintime;
/*     */   }
/*     */   
/*     */   public void setLogintime(Timestamp logintime) {
/* 218 */     this.logintime = logintime;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatetime() {
/* 222 */     return this.createtime;
/*     */   }
/*     */   
/*     */   public void setCreatetime(Timestamp createtime) {
/* 226 */     this.createtime = createtime;
/*     */   }
/*     */   
/*     */   public Integer getEverydaysign() {
/* 230 */     return this.everydaysign;
/*     */   }
/*     */   
/*     */   public void setEverydaysign(Integer everydaysign) {
/* 234 */     this.everydaysign = everydaysign;
/*     */   }
/*     */   
/*     */   public Integer getPid() {
/* 238 */     return this.pid;
/*     */   }
/*     */   
/*     */   public void setPid(Integer pid) {
/* 242 */     this.pid = pid;
/*     */   }
/*     */   
/*     */   public String getAutograph() {
/* 246 */     return this.autograph;
/*     */   }
/*     */   
/*     */   public void setAutograph(String autograph) {
/* 250 */     this.autograph = autograph;
/*     */   }
/*     */   
/*     */   public Integer getCharm() {
/* 254 */     return this.charm;
/*     */   }
/*     */   
/*     */   public void setCharm(Integer charm) {
/* 258 */     this.charm = charm;
/*     */   }
/*     */   
/*     */   public Integer getVictorycount() {
/* 262 */     return this.victorycount;
/*     */   }
/*     */   
/*     */   public void setVictorycount(Integer victorycount) {
/* 266 */     this.victorycount = victorycount;
/*     */   }
/*     */   
/*     */   public String getProp() {
/* 270 */     return this.prop;
/*     */   }
/*     */   
/*     */   public void setProp(String prop) {
/* 274 */     this.prop = prop;
/*     */   }
/*     */   
/*     */   public String getTask() {
/* 278 */     return this.task;
/*     */   }
/*     */   
/*     */   public void setTask(String task) {
/* 282 */     this.task = task;
/*     */   }
/*     */   
/*     */   public String getIdNumber() {
/* 286 */     return this.idNumber;
/*     */   }
/*     */   
/*     */   public void setIdNumber(String idNumber) {
/* 290 */     this.idNumber = idNumber;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 294 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 298 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public Integer getWarehouseDiamonds() {
/* 302 */     return this.warehouseDiamonds;
/*     */   }
/*     */   
/*     */   public void setWarehouseDiamonds(Integer warehouseDiamonds) {
/* 306 */     this.warehouseDiamonds = warehouseDiamonds;
/*     */   }
/*     */   
/*     */   public Integer getWarehouseIntegral() {
/* 310 */     return this.warehouseIntegral;
/*     */   }
/*     */   
/*     */   public void setWarehouseIntegral(Integer warehouseIntegral) {
/* 314 */     this.warehouseIntegral = warehouseIntegral;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Users.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */