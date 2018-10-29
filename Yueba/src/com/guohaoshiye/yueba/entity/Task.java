/*     */ package com.aiwan.entity;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class Task
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer acceptid;
/*     */   private Integer completeid;
/*     */   private String reward;
/*     */   private Integer type;
/*     */   private Integer state;
/*     */   private String describe;
/*     */   
/*     */   public Task() {}
/*     */   
/*     */   public Task(Integer acceptid, Integer completeid, String reward, Integer state)
/*     */   {
/*  29 */     this.acceptid = acceptid;
/*  30 */     this.completeid = completeid;
/*  31 */     this.reward = reward;
/*  32 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */   public Task(Integer acceptid, Integer completeid, String reward, Integer type, Integer state, String describe)
/*     */   {
/*  38 */     this.acceptid = acceptid;
/*  39 */     this.completeid = completeid;
/*  40 */     this.reward = reward;
/*  41 */     this.type = type;
/*  42 */     this.state = state;
/*  43 */     this.describe = describe;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  53 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getAcceptid() {
/*  57 */     return this.acceptid;
/*     */   }
/*     */   
/*     */   public void setAcceptid(Integer acceptid) {
/*  61 */     this.acceptid = acceptid;
/*     */   }
/*     */   
/*     */   public Integer getCompleteid() {
/*  65 */     return this.completeid;
/*     */   }
/*     */   
/*     */   public void setCompleteid(Integer completeid) {
/*  69 */     this.completeid = completeid;
/*     */   }
/*     */   
/*     */   public String getReward() {
/*  73 */     return this.reward;
/*     */   }
/*     */   
/*     */   public void setReward(String reward) {
/*  77 */     this.reward = reward;
/*     */   }
/*     */   
/*     */   public Integer getType() {
/*  81 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/*  85 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Integer getState() {
/*  89 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(Integer state) {
/*  93 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getDescribe() {
/*  97 */     return this.describe;
/*     */   }
/*     */   
/*     */   public void setDescribe(String describe) {
/* 101 */     this.describe = describe;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Task.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */