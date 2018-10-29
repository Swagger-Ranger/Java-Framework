/*    */ package com.aiwan.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.sql.Timestamp;
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
/*    */ public class CommoditypurchaseLog
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String commodityName;
/*    */   private Integer commodityNumber;
/*    */   private Integer commodityTotalPrice;
/*    */   private Integer purchaseUserid;
/*    */   private Timestamp createTime;
/*    */   
/*    */   public CommoditypurchaseLog() {}
/*    */   
/*    */   public CommoditypurchaseLog(String commodityName, Integer commodityNumber, Integer commodityTotalPrice, Integer purchaseUserid, Timestamp createTime)
/*    */   {
/* 31 */     this.commodityName = commodityName;
/* 32 */     this.commodityNumber = commodityNumber;
/* 33 */     this.commodityTotalPrice = commodityTotalPrice;
/* 34 */     this.purchaseUserid = purchaseUserid;
/* 35 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 41 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 45 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getCommodityName() {
/* 49 */     return this.commodityName;
/*    */   }
/*    */   
/*    */   public void setCommodityName(String commodityName) {
/* 53 */     this.commodityName = commodityName;
/*    */   }
/*    */   
/*    */   public Integer getCommodityNumber() {
/* 57 */     return this.commodityNumber;
/*    */   }
/*    */   
/*    */   public void setCommodityNumber(Integer commodityNumber) {
/* 61 */     this.commodityNumber = commodityNumber;
/*    */   }
/*    */   
/*    */   public Integer getCommodityTotalPrice() {
/* 65 */     return this.commodityTotalPrice;
/*    */   }
/*    */   
/*    */   public void setCommodityTotalPrice(Integer commodityTotalPrice) {
/* 69 */     this.commodityTotalPrice = commodityTotalPrice;
/*    */   }
/*    */   
/*    */   public Integer getPurchaseUserid() {
/* 73 */     return this.purchaseUserid;
/*    */   }
/*    */   
/*    */   public void setPurchaseUserid(Integer purchaseUserid) {
/* 77 */     this.purchaseUserid = purchaseUserid;
/*    */   }
/*    */   
/*    */   public Timestamp getCreateTime() {
/* 81 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Timestamp createTime) {
/* 85 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\CommoditypurchaseLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */