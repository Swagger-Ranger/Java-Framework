/*    */ package com.aiwan.entity;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TreeNodes
/*    */ {
/*    */   private int code;
/*    */   private int parentCode;
/*    */   private String icon;
/*    */   private String name;
/*    */   private List<TreeNodes> child;
/*    */   
/*    */   public TreeNodes() {}
/*    */   
/*    */   public TreeNodes(int code, int parentCode, String icon, String name, List<TreeNodes> child)
/*    */   {
/* 19 */     this.code = code;
/* 20 */     this.parentCode = parentCode;
/* 21 */     this.icon = icon;
/* 22 */     this.name = name;
/* 23 */     this.child = child;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 27 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(int code) {
/* 31 */     this.code = code;
/*    */   }
/*    */   
/*    */   public int getParentCode() {
/* 35 */     return this.parentCode;
/*    */   }
/*    */   
/*    */   public void setParentCode(int parentCode) {
/* 39 */     this.parentCode = parentCode;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 43 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 47 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 51 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 55 */     this.name = name;
/*    */   }
/*    */   
/*    */   public List<TreeNodes> getChild() {
/* 59 */     return this.child;
/*    */   }
/*    */   
/*    */   public void setChild(List<TreeNodes> child) {
/* 63 */     this.child = child;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 68 */     return "{\"code\":\"" + this.code + "\", \"parentCode\":\"" + this.parentCode + "\", \"icon\":\"" + this.icon + "\", \"name\":\"" + this.name + "\", \"child\":" + this.child + "}";
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\TreeNodes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */