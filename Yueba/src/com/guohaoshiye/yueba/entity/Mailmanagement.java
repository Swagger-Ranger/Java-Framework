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
/*    */ public class Mailmanagement
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer uid;
/*    */   private String content;
/*    */   private Integer state;
/*    */   private Integer type;
/*    */   private String goods;
/*    */   private Timestamp createtime;
/*    */   
/*    */   public Mailmanagement() {}
/*    */   
/*    */   public Mailmanagement(Integer uid)
/*    */   {
/* 30 */     this.uid = uid;
/*    */   }
/*    */   
/*    */ 
/*    */   public Mailmanagement(Integer uid, String content, Integer state, Integer type, String goods, Timestamp createtime)
/*    */   {
/* 36 */     this.uid = uid;
/* 37 */     this.content = content;
/* 38 */     this.state = state;
/* 39 */     this.type = type;
/* 40 */     this.goods = goods;
/* 41 */     this.createtime = createtime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 47 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 51 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getUid() {
/* 55 */     return this.uid;
/*    */   }
/*    */   
/*    */   public void setUid(Integer uid) {
/* 59 */     this.uid = uid;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 63 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 67 */     this.content = content;
/*    */   }
/*    */   
/*    */   public Integer getState() {
/* 71 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(Integer state) {
/* 75 */     this.state = state;
/*    */   }
/*    */   
/*    */   public Integer getType() {
/* 79 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(Integer type) {
/* 83 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getGoods() {
/* 87 */     return this.goods;
/*    */   }
/*    */   
/*    */   public void setGoods(String goods) {
/* 91 */     this.goods = goods;
/*    */   }
/*    */   
/*    */   public Timestamp getCreatetime() {
/* 95 */     return this.createtime;
/*    */   }
/*    */   
/*    */   public void setCreatetime(Timestamp createtime) {
/* 99 */     this.createtime = createtime;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Mailmanagement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */