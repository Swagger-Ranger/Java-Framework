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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="closeRoomResponse", propOrder={"_return"})
/*    */ public class CloseRoomResponse
/*    */ {
/*    */   @XmlElement(name="return")
/*    */   protected boolean _return;
/*    */   
/*    */   public boolean isReturn()
/*    */   {
/* 42 */     return this._return;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setReturn(boolean value)
/*    */   {
/* 50 */     this._return = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\CloseRoomResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */