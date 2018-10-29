/*    */ package com.game.server.web;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="message", propOrder={"arg0", "arg1"})
/*    */ public class Message
/*    */ {
/*    */   protected String arg0;
/*    */   protected int arg1;
/*    */   
/*    */   public String getArg0()
/*    */   {
/* 45 */     return this.arg0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setArg0(String value)
/*    */   {
/* 57 */     this.arg0 = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getArg1()
/*    */   {
/* 65 */     return this.arg1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setArg1(int value)
/*    */   {
/* 73 */     this.arg1 = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */