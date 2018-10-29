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
/*    */ public class Hallslidingdrawing
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String url;
/*    */   private Integer state;
/*    */   private Timestamp createtime;
/*    */   
/*    */   public Hallslidingdrawing() {}
/*    */   
/*    */   public Hallslidingdrawing(String url, Integer state, Timestamp createtime)
/*    */   {
/* 27 */     this.url = url;
/* 28 */     this.state = state;
/* 29 */     this.createtime = createtime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 35 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 39 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 43 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 47 */     this.url = url;
/*    */   }
/*    */   
/*    */   public Integer getState() {
/* 51 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(Integer state) {
/* 55 */     this.state = state;
/*    */   }
/*    */   
/*    */   public Timestamp getCreatetime() {
/* 59 */     return this.createtime;
/*    */   }
/*    */   
/*    */   public void setCreatetime(Timestamp createtime) {
/* 63 */     this.createtime = createtime;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Hallslidingdrawing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */