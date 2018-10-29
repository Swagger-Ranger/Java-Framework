/*    */ package com.aiwan.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.sql.Timestamp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminRechargeLog
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String money;
/*    */   private Integer uid;
/*    */   private Integer rtype;
/*    */   private Integer aid;
/*    */   private Timestamp createTime;
/*    */   
/*    */   public AdminRechargeLog() {}
/*    */   
/*    */   public AdminRechargeLog(String money, Integer uid, Integer rtype, Integer aid, Timestamp createTime)
/*    */   {
/* 30 */     this.money = money;
/* 31 */     this.uid = uid;
/* 32 */     this.rtype = rtype;
/* 33 */     this.aid = aid;
/* 34 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 40 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 44 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getMoney() {
/* 48 */     return this.money;
/*    */   }
/*    */   
/*    */   public void setMoney(String money) {
/* 52 */     this.money = money;
/*    */   }
/*    */   
/*    */   public Integer getUid() {
/* 56 */     return this.uid;
/*    */   }
/*    */   
/*    */   public void setUid(Integer uid) {
/* 60 */     this.uid = uid;
/*    */   }
/*    */   
/*    */   public Integer getRtype() {
/* 64 */     return this.rtype;
/*    */   }
/*    */   
/*    */   public void setRtype(Integer rtype) {
/* 68 */     this.rtype = rtype;
/*    */   }
/*    */   
/*    */   public Integer getAid() {
/* 72 */     return this.aid;
/*    */   }
/*    */   
/*    */   public void setAid(Integer aid) {
/* 76 */     this.aid = aid;
/*    */   }
/*    */   
/*    */   public Timestamp getCreateTime() {
/* 80 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Timestamp createTime) {
/* 84 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\AdminRechargeLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */