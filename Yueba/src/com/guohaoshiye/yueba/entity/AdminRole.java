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
/*    */ 
/*    */ public class AdminRole
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private AdminMenu adminMenu;
/*    */   private Admin admin;
/*    */   private String op;
/*    */   
/*    */   public AdminRole() {}
/*    */   
/*    */   public AdminRole(AdminMenu adminMenu, Admin admin, String op)
/*    */   {
/* 26 */     this.adminMenu = adminMenu;
/* 27 */     this.admin = admin;
/* 28 */     this.op = op;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 34 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 38 */     this.id = id;
/*    */   }
/*    */   
/*    */   public AdminMenu getAdminMenu() {
/* 42 */     return this.adminMenu;
/*    */   }
/*    */   
/*    */   public void setAdminMenu(AdminMenu adminMenu) {
/* 46 */     this.adminMenu = adminMenu;
/*    */   }
/*    */   
/*    */   public Admin getAdmin() {
/* 50 */     return this.admin;
/*    */   }
/*    */   
/*    */   public void setAdmin(Admin admin) {
/* 54 */     this.admin = admin;
/*    */   }
/*    */   
/*    */   public String getOp() {
/* 58 */     return this.op;
/*    */   }
/*    */   
/*    */   public void setOp(String op) {
/* 62 */     this.op = op;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\AdminRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */