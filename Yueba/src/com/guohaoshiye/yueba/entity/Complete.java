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
/*    */ public class Complete
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private Integer completecondition;
/*    */   private String otherconditions;
/*    */   private String describe;
/*    */   
/*    */   public Complete() {}
/*    */   
/*    */   public Complete(Integer completecondition)
/*    */   {
/* 25 */     this.completecondition = completecondition;
/*    */   }
/*    */   
/*    */ 
/*    */   public Complete(Integer completecondition, String otherconditions, String describe)
/*    */   {
/* 31 */     this.completecondition = completecondition;
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
/*    */   public Integer getCompletecondition() {
/* 47 */     return this.completecondition;
/*    */   }
/*    */   
/*    */   public void setCompletecondition(Integer completecondition) {
/* 51 */     this.completecondition = completecondition;
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


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Complete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */