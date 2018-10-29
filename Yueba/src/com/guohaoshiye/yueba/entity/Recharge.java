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
/*     */ public class Recharge
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer userId;
/*     */   private Integer money;
/*     */   private Timestamp createtime;
/*     */   private Integer status;
/*     */   private String order;
/*     */   private Integer gold;
/*     */   private Integer type;
/*     */   
/*     */   public Recharge() {}
/*     */   
/*     */   public Recharge(Integer userId, Timestamp createtime, Integer status, Integer gold)
/*     */   {
/*  32 */     this.userId = userId;
/*  33 */     this.createtime = createtime;
/*  34 */     this.status = status;
/*  35 */     this.gold = gold;
/*     */   }
/*     */   
/*     */ 
/*     */   public Recharge(Integer userId, Integer money, Timestamp createtime, Integer status, String order, Integer gold, Integer type)
/*     */   {
/*  41 */     this.userId = userId;
/*  42 */     this.money = money;
/*  43 */     this.createtime = createtime;
/*  44 */     this.status = status;
/*  45 */     this.order = order;
/*  46 */     this.gold = gold;
/*  47 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  53 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getUserId() {
/*  61 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Integer userId) {
/*  65 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Integer getMoney() {
/*  69 */     return this.money;
/*     */   }
/*     */   
/*     */   public void setMoney(Integer money) {
/*  73 */     this.money = money;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatetime() {
/*  77 */     return this.createtime;
/*     */   }
/*     */   
/*     */   public void setCreatetime(Timestamp createtime) {
/*  81 */     this.createtime = createtime;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/*  85 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  89 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getOrder() {
/*  93 */     return this.order;
/*     */   }
/*     */   
/*     */   public void setOrder(String order) {
/*  97 */     this.order = order;
/*     */   }
/*     */   
/*     */   public Integer getGold() {
/* 101 */     return this.gold;
/*     */   }
/*     */   
/*     */   public void setGold(Integer gold) {
/* 105 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   public Integer getType() {
/* 109 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/* 113 */     this.type = type;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Recharge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */