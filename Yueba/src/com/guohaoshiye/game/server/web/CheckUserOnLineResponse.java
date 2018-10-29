/*    */ package com.game.server.web;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="checkUserOnLineResponse", propOrder={"_return"})
/*    */ public class CheckUserOnLineResponse
/*    */ {
/*    */   @XmlElement(name="return")
/*    */   protected String _return;
/*    */   
/*    */   public String getReturn()
/*    */   {
/* 45 */     return this._return;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setReturn(String value)
/*    */   {
/* 57 */     this._return = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\CheckUserOnLineResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */