/*    */ package com.aiwan.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdminMenu
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String title;
/*    */   private String url;
/*    */   private String spread;
/*    */   private String icon;
/*    */   private Integer rank;
/* 21 */   private Set adminRoles = new HashSet(0);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public AdminMenu() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public AdminMenu(String title, String url, String spread, String icon, Integer rank, Set adminRoles)
/*    */   {
/* 32 */     this.title = title;
/* 33 */     this.url = url;
/* 34 */     this.spread = spread;
/* 35 */     this.icon = icon;
/* 36 */     this.rank = rank;
/* 37 */     this.adminRoles = adminRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 43 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 47 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 51 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 55 */     this.title = title;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 59 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 63 */     this.url = url;
/*    */   }
/*    */   
/*    */   public String getSpread() {
/* 67 */     return this.spread;
/*    */   }
/*    */   
/*    */   public void setSpread(String spread) {
/* 71 */     this.spread = spread;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 75 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 79 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public Integer getRank() {
/* 83 */     return this.rank;
/*    */   }
/*    */   
/*    */   public void setRank(Integer rank) {
/* 87 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   public Set getAdminRoles() {
/* 91 */     return this.adminRoles;
/*    */   }
/*    */   
/*    */   public void setAdminRoles(Set adminRoles) {
/* 95 */     this.adminRoles = adminRoles;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\AdminMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */