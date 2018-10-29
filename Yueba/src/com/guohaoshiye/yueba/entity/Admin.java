/*     */ package com.aiwan.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Admin
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String adminname;
/*     */   private String password;
/*     */   private String head;
/*     */   private Timestamp logintime;
/*     */   private Timestamp createtime;
/*     */   private String opname;
/*  24 */   private Set adminRoles = new HashSet(0);
/*     */   
/*     */   private Integer adminHomeOp1;
/*     */   
/*     */   private Integer adminHomeOp2;
/*     */   
/*     */ 
/*     */   public Admin() {}
/*     */   
/*     */   public Admin(String adminname, String password, String head, Timestamp logintime, String opname)
/*     */   {
/*  35 */     this.adminname = adminname;
/*  36 */     this.password = password;
/*  37 */     this.head = head;
/*  38 */     this.logintime = logintime;
/*  39 */     this.opname = opname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Admin(String adminname, String password, String head, Timestamp logintime, Timestamp createtime, String opname, Set adminRoles)
/*     */   {
/*  46 */     this.adminname = adminname;
/*  47 */     this.password = password;
/*  48 */     this.head = head;
/*  49 */     this.logintime = logintime;
/*  50 */     this.createtime = createtime;
/*  51 */     this.opname = opname;
/*  52 */     this.adminRoles = adminRoles;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  62 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getAdminname() {
/*  66 */     return this.adminname;
/*     */   }
/*     */   
/*     */   public void setAdminname(String adminname) {
/*  70 */     this.adminname = adminname;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  74 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  78 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getHead() {
/*  82 */     return this.head;
/*     */   }
/*     */   
/*     */   public void setHead(String head) {
/*  86 */     this.head = head;
/*     */   }
/*     */   
/*     */   public Timestamp getLogintime() {
/*  90 */     return this.logintime;
/*     */   }
/*     */   
/*     */   public void setLogintime(Timestamp logintime) {
/*  94 */     this.logintime = logintime;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatetime() {
/*  98 */     return this.createtime;
/*     */   }
/*     */   
/*     */   public void setCreatetime(Timestamp createtime) {
/* 102 */     this.createtime = createtime;
/*     */   }
/*     */   
/*     */   public Set getAdminRoles() {
/* 106 */     return this.adminRoles;
/*     */   }
/*     */   
/*     */   public void setAdminRoles(Set adminRoles) {
/* 110 */     this.adminRoles = adminRoles;
/*     */   }
/*     */   
/*     */   public String getOpname() {
/* 114 */     return this.opname;
/*     */   }
/*     */   
/*     */   public void setOpname(String opname) {
/* 118 */     this.opname = opname;
/*     */   }
/*     */   
/*     */   public Integer getAdminHomeOp1() {
/* 122 */     return this.adminHomeOp1;
/*     */   }
/*     */   
/*     */   public void setAdminHomeOp1(Integer adminHomeOp1) {
/* 126 */     this.adminHomeOp1 = adminHomeOp1;
/*     */   }
/*     */   
/*     */   public Integer getAdminHomeOp2() {
/* 130 */     return this.adminHomeOp2;
/*     */   }
/*     */   
/*     */   public void setAdminHomeOp2(Integer adminHomeOp2) {
/* 134 */     this.adminHomeOp2 = adminHomeOp2;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\Admin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */