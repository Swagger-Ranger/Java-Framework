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
/*    */ public class SystemLog
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer aid;
/*    */   private String content;
/*    */   private Timestamp createTime;
/*    */   private String operating;
/*    */   
/*    */   public SystemLog() {}
/*    */   
/*    */   public SystemLog(Integer aid, String content, Timestamp createTime, String operating)
/*    */   {
/* 29 */     this.aid = aid;
/* 30 */     this.content = content;
/* 31 */     this.createTime = createTime;
/* 32 */     this.operating = operating;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 38 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 42 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getAid() {
/* 46 */     return this.aid;
/*    */   }
/*    */   
/*    */   public void setAid(Integer aid) {
/* 50 */     this.aid = aid;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 54 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 58 */     this.content = content;
/*    */   }
/*    */   
/*    */   public Timestamp getCreateTime() {
/* 62 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Timestamp createTime) {
/* 66 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public String getOperating() {
/* 70 */     return this.operating;
/*    */   }
/*    */   
/*    */   public void setOperating(String operating) {
/* 74 */     this.operating = operating;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\SystemLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */