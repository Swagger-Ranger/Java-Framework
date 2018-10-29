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
/*     */ public class TixianLog
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer pid;
/*     */   private String cash;
/*     */   private String ingots;
/*     */   private Integer status;
/*     */   private Timestamp createTime;
/*     */   private Integer auditPeople;
/*     */   private Timestamp auditTime;
/*     */   private String denyReason;
/*     */   private Integer type;
/*     */   private String content;
/*     */   private String tax;
/*     */   private String txhz;
/*     */   
/*     */   public TixianLog() {}
/*     */   
/*     */   public TixianLog(Integer pid, String cash, String ingots, Integer status, Timestamp createTime, Integer auditPeople, Timestamp auditTime, String denyReason, Integer type, String content, String tax, String txhz)
/*     */   {
/*  39 */     this.pid = pid;
/*  40 */     this.cash = cash;
/*  41 */     this.ingots = ingots;
/*  42 */     this.status = status;
/*  43 */     this.createTime = createTime;
/*  44 */     this.auditPeople = auditPeople;
/*  45 */     this.auditTime = auditTime;
/*  46 */     this.denyReason = denyReason;
/*  47 */     this.type = type;
/*  48 */     this.content = content;
/*  49 */     this.tax = tax;
/*  50 */     this.txhz = txhz;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  56 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  60 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getPid() {
/*  64 */     return this.pid;
/*     */   }
/*     */   
/*     */   public void setPid(Integer pid) {
/*  68 */     this.pid = pid;
/*     */   }
/*     */   
/*     */   public String getCash() {
/*  72 */     return this.cash;
/*     */   }
/*     */   
/*     */   public void setCash(String cash) {
/*  76 */     this.cash = cash;
/*     */   }
/*     */   
/*     */   public String getIngots() {
/*  80 */     return this.ingots;
/*     */   }
/*     */   
/*     */   public void setIngots(String ingots) {
/*  84 */     this.ingots = ingots;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/*  88 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  92 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Timestamp getCreateTime() {
/*  96 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Timestamp createTime) {
/* 100 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Integer getAuditPeople() {
/* 104 */     return this.auditPeople;
/*     */   }
/*     */   
/*     */   public void setAuditPeople(Integer auditPeople) {
/* 108 */     this.auditPeople = auditPeople;
/*     */   }
/*     */   
/*     */   public Timestamp getAuditTime() {
/* 112 */     return this.auditTime;
/*     */   }
/*     */   
/*     */   public void setAuditTime(Timestamp auditTime) {
/* 116 */     this.auditTime = auditTime;
/*     */   }
/*     */   
/*     */   public String getDenyReason() {
/* 120 */     return this.denyReason;
/*     */   }
/*     */   
/*     */   public void setDenyReason(String denyReason) {
/* 124 */     this.denyReason = denyReason;
/*     */   }
/*     */   
/*     */   public Integer getType() {
/* 128 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/* 132 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getContent() {
/* 136 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/* 140 */     this.content = content;
/*     */   }
/*     */   
/*     */   public String getTax() {
/* 144 */     return this.tax;
/*     */   }
/*     */   
/*     */   public void setTax(String tax) {
/* 148 */     this.tax = tax;
/*     */   }
/*     */   
/*     */   public String getTxhz() {
/* 152 */     return this.txhz;
/*     */   }
/*     */   
/*     */   public void setTxhz(String txhz) {
/* 156 */     this.txhz = txhz;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\TixianLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */