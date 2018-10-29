/*    */ package com.aiwan.util;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UtilDate
/*    */ {
/*    */   public static final String dtLong = "yyyyMMddHHmmss";
/*    */   public static final String simple = "yyyy-MM-dd HH:mm:ss";
/*    */   public static final String dtShort = "yyyyMMdd";
/*    */   
/*    */   public static String getdtlongNum()
/*    */   {
/* 20 */     Date date = new Date();
/* 21 */     DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
/* 22 */     return df.format(date);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getDateFormatter()
/*    */   {
/* 31 */     Date date = new Date();
/* 32 */     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 33 */     return df.format(date);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getDate()
/*    */   {
/* 42 */     Date date = new Date();
/* 43 */     DateFormat df = new SimpleDateFormat("yyyyMMdd");
/* 44 */     return df.format(date);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getThree()
/*    */   {
/* 53 */     Random rad = new Random();
/* 54 */     return rad.nextInt(1000) + "";
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\util\UtilDate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */