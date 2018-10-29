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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="closeServerResponse", propOrder={"_return"})
/*    */ public class CloseServerResponse
/*    */ {
/*    */   @XmlElement(name="return")
/*    */   protected boolean _return;
/*    */   
/*    */   public boolean isReturn()
/*    */   {
/* 41 */     return this._return;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setReturn(boolean value)
/*    */   {
/* 49 */     this._return = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\CloseServerResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */