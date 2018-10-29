/*    */ package com.guohaoshiye.yueba.entity;
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
/*    */ public class AdminopLog
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer aid;
/*    */   private String description;
/*    */   private Timestamp createTime;
/*    */   
/*    */   public AdminopLog() {}
/*    */   
/*    */   public AdminopLog(Integer aid)
/*    */   {
/* 27 */     this.aid = aid;
/*    */   }
/*    */   
/*    */   public AdminopLog(Integer aid, String description, Timestamp createTime)
/*    */   {
/* 32 */     this.aid = aid;
/* 33 */     this.description = description;
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
/*    */   public Integer getAid() {
/* 48 */     return this.aid;
/*    */   }
/*    */   
/*    */   public void setAid(Integer aid) {
/* 52 */     this.aid = aid;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 56 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 60 */     this.description = description;
/*    */   }
/*    */   
/*    */   public Timestamp getCreateTime() {
/* 64 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Timestamp createTime) {
/* 68 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\AdminopLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */