/*     */ package com.game.server.web;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="Give", propOrder={"arg0", "arg1", "arg2"})
/*     */ public class Give
/*     */ {
/*     */   @XmlElement(nillable=true)
/*     */   protected List<Integer> arg0;
/*     */   protected int arg1;
/*     */   protected int arg2;
/*     */   
/*     */   public List<Integer> getArg0()
/*     */   {
/*  65 */     if (this.arg0 == null) {
/*  66 */       this.arg0 = new ArrayList();
/*     */     }
/*  68 */     return this.arg0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getArg1()
/*     */   {
/*  76 */     return this.arg1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setArg1(int value)
/*     */   {
/*  84 */     this.arg1 = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getArg2()
/*     */   {
/*  92 */     return this.arg2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setArg2(int value)
/*     */   {
/* 100 */     this.arg2 = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\Give.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */