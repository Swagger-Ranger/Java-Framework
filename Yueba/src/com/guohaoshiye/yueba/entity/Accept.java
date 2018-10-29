/*    */ package com.aiwan.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Accept
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer acceptcondition;
/*    */   private String otherconditions;
/*    */   private String describe;
/*    */   
/*    */   public Accept() {}
/*    */   
/*    */   public Accept(Integer acceptcondition)
/*    */   {
/* 25 */     this.acceptcondition = acceptcondition;
/*    */   }
/*    */   
/*    */ 
/*    */   public Accept(Integer acceptcondition, String otherconditions, String describe)
/*    */   {
/* 31 */     this.acceptcondition = acceptcondition;
/* 32 */     this.otherconditions = otherconditions;
/* 33 */     this.describe = describe;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 39 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 43 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getAcceptcondition() {
/* 47 */     return this.acceptcondition;
/*    */   }
/*    */   
/*    */   public void setAcceptcondition(Integer acceptcondition) {
/* 51 */     this.acceptcondition = acceptcondition;
/*    */   }
/*    */   
/*    */   public String getOtherconditions() {
/* 55 */     return this.otherconditions;
/*    */   }
/*    */   
/*    */   public void setOtherconditions(String otherconditions) {
/* 59 */     this.otherconditions = otherconditions;
/*    */   }
/*    */   
/*    */   public String getDescribe() {
/* 63 */     return this.describe;
/*    */   }
/*    */   
/*    */   public void setDescribe(String describe) {
/* 67 */     this.describe = describe;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Accept.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */