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
/*     */ public class ProxytoexamineLog
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer uid;
/*     */   private String clientname;
/*     */   private String weixinhao;
/*     */   private String chalouname;
/*     */   private String applydescription;
/*     */   private String phone;
/*     */   private Integer servicecharge;
/*     */   private Integer state;
/*     */   private Timestamp creatrtime;
/*     */   private Integer auditid;
/*     */   private Timestamp auditTime;
/*     */   private String denyReason;
/*     */   private Integer pid;
/*     */   private Integer currentDiamonds;
/*     */   private Integer currentIntegral;
/*     */   
/*     */   public ProxytoexamineLog() {}
/*     */   
/*     */   public ProxytoexamineLog(Integer uid, String clientname, String weixinhao, String chalouname, String phone, Integer state)
/*     */   {
/*  40 */     this.uid = uid;
/*  41 */     this.clientname = clientname;
/*  42 */     this.weixinhao = weixinhao;
/*  43 */     this.chalouname = chalouname;
/*  44 */     this.phone = phone;
/*  45 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ProxytoexamineLog(Integer uid, String clientname, String weixinhao, String chalouname, String applydescription, String phone, Integer servicecharge, Integer state, Timestamp creatrtime, Integer auditid, Timestamp auditTime, String denyReason, Integer pid, Integer currentDiamonds, Integer currentIntegral)
/*     */   {
/*  54 */     this.uid = uid;
/*  55 */     this.clientname = clientname;
/*  56 */     this.weixinhao = weixinhao;
/*  57 */     this.chalouname = chalouname;
/*  58 */     this.applydescription = applydescription;
/*  59 */     this.phone = phone;
/*  60 */     this.servicecharge = servicecharge;
/*  61 */     this.state = state;
/*  62 */     this.creatrtime = creatrtime;
/*  63 */     this.auditid = auditid;
/*  64 */     this.auditTime = auditTime;
/*  65 */     this.denyReason = denyReason;
/*  66 */     this.pid = pid;
/*  67 */     this.currentDiamonds = currentDiamonds;
/*  68 */     this.currentIntegral = currentIntegral;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  74 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  78 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getUid() {
/*  82 */     return this.uid;
/*     */   }
/*     */   
/*     */   public void setUid(Integer uid) {
/*  86 */     this.uid = uid;
/*     */   }
/*     */   
/*     */   public String getClientname() {
/*  90 */     return this.clientname;
/*     */   }
/*     */   
/*     */   public void setClientname(String clientname) {
/*  94 */     this.clientname = clientname;
/*     */   }
/*     */   
/*     */   public String getWeixinhao() {
/*  98 */     return this.weixinhao;
/*     */   }
/*     */   
/*     */   public void setWeixinhao(String weixinhao) {
/* 102 */     this.weixinhao = weixinhao;
/*     */   }
/*     */   
/*     */   public String getChalouname() {
/* 106 */     return this.chalouname;
/*     */   }
/*     */   
/*     */   public void setChalouname(String chalouname) {
/* 110 */     this.chalouname = chalouname;
/*     */   }
/*     */   
/*     */   public String getApplydescription() {
/* 114 */     return this.applydescription;
/*     */   }
/*     */   
/*     */   public void setApplydescription(String applydescription) {
/* 118 */     this.applydescription = applydescription;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 122 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 126 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public Integer getServicecharge() {
/* 130 */     return this.servicecharge;
/*     */   }
/*     */   
/*     */   public void setServicecharge(Integer servicecharge) {
/* 134 */     this.servicecharge = servicecharge;
/*     */   }
/*     */   
/*     */   public Integer getState() {
/* 138 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(Integer state) {
/* 142 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatrtime() {
/* 146 */     return this.creatrtime;
/*     */   }
/*     */   
/*     */   public void setCreatrtime(Timestamp creatrtime) {
/* 150 */     this.creatrtime = creatrtime;
/*     */   }
/*     */   
/*     */   public Integer getAuditid() {
/* 154 */     return this.auditid;
/*     */   }
/*     */   
/*     */   public void setAuditid(Integer auditid) {
/* 158 */     this.auditid = auditid;
/*     */   }
/*     */   
/*     */   public Timestamp getAuditTime() {
/* 162 */     return this.auditTime;
/*     */   }
/*     */   
/*     */   public void setAuditTime(Timestamp auditTime) {
/* 166 */     this.auditTime = auditTime;
/*     */   }
/*     */   
/*     */   public String getDenyReason() {
/* 170 */     return this.denyReason;
/*     */   }
/*     */   
/*     */   public void setDenyReason(String denyReason) {
/* 174 */     this.denyReason = denyReason;
/*     */   }
/*     */   
/*     */   public Integer getPid() {
/* 178 */     return this.pid;
/*     */   }
/*     */   
/*     */   public void setPid(Integer pid) {
/* 182 */     this.pid = pid;
/*     */   }
/*     */   
/*     */   public Integer getCurrentDiamonds() {
/* 186 */     return this.currentDiamonds;
/*     */   }
/*     */   
/*     */   public void setCurrentDiamonds(Integer currentDiamonds) {
/* 190 */     this.currentDiamonds = currentDiamonds;
/*     */   }
/*     */   
/*     */   public Integer getCurrentIntegral() {
/* 194 */     return this.currentIntegral;
/*     */   }
/*     */   
/*     */   public void setCurrentIntegral(Integer currentIntegral) {
/* 198 */     this.currentIntegral = currentIntegral;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\ProxytoexamineLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */