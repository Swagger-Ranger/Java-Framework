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
/*    */ public class Parameter
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String value;
/*    */   private String explain;
/*    */   private Integer type;
/*    */   
/*    */   public Parameter() {}
/*    */   
/*    */   public Parameter(String name, String value, String explain)
/*    */   {
/* 26 */     this.name = name;
/* 27 */     this.value = value;
/* 28 */     this.explain = explain;
/*    */   }
/*    */   
/*    */   public Parameter(String name, String value, String explain, Integer type)
/*    */   {
/* 33 */     this.name = name;
/* 34 */     this.value = value;
/* 35 */     this.explain = explain;
/* 36 */     this.type = type;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 42 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 46 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 50 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 54 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 58 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 62 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getExplain() {
/* 66 */     return this.explain;
/*    */   }
/*    */   
/*    */   public void setExplain(String explain) {
/* 70 */     this.explain = explain;
/*    */   }
/*    */   
/*    */   public Integer getType() {
/* 74 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(Integer type) {
/* 78 */     this.type = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Parameter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */