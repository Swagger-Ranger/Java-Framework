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
/*    */ public class Robotrecharge
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer rid;
/*    */   private Integer gold;
/*    */   private Timestamp time;
/*    */   private Integer aid;
/*    */   
/*    */   public Robotrecharge() {}
/*    */   
/*    */   public Robotrecharge(Integer rid, Integer gold, Timestamp time, Integer aid)
/*    */   {
/* 28 */     this.rid = rid;
/* 29 */     this.gold = gold;
/* 30 */     this.time = time;
/* 31 */     this.aid = aid;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 37 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 41 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getRid() {
/* 45 */     return this.rid;
/*    */   }
/*    */   
/*    */   public void setRid(Integer rid) {
/* 49 */     this.rid = rid;
/*    */   }
/*    */   
/*    */   public Integer getGold() {
/* 53 */     return this.gold;
/*    */   }
/*    */   
/*    */   public void setGold(Integer gold) {
/* 57 */     this.gold = gold;
/*    */   }
/*    */   
/*    */   public Timestamp getTime() {
/* 61 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Timestamp time) {
/* 65 */     this.time = time;
/*    */   }
/*    */   
/*    */   public Integer getAid() {
/* 69 */     return this.aid;
/*    */   }
/*    */   
/*    */   public void setAid(Integer aid) {
/* 73 */     this.aid = aid;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Robotrecharge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */