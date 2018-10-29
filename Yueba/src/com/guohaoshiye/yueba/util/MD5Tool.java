/*     */ package com.aiwan.util;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MD5Tool
/*     */ {
/*     */   private static final int ASCII_0 = 48;
/*     */   private static final int ASCII_9 = 57;
/*     */   private static final int ASCII_A = 65;
/*     */   private static final int ASCII_F = 70;
/*     */   private static final int ASCII_a = 97;
/*     */   private static final int ASCII_f = 102;
/*  24 */   private static final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */   
/*     */ 
/*     */   private static final String HASH_MD5 = "MD5";
/*     */   
/*  29 */   private static Logger log = LoggerFactory.getLogger(MD5Tool.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String encoding(byte[] bs)
/*     */   {
/*  39 */     String encodingStr = null;
/*     */     try {
/*  41 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/*  42 */       mdTemp.update(bs);
/*     */       
/*  44 */       return toHexString(mdTemp.digest());
/*     */     }
/*     */     catch (Exception e) {
/*  47 */       log.error(e.getMessage());
/*     */     }
/*     */     
/*  50 */     return encodingStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String encoding(String text)
/*     */   {
/*  60 */     if (text == null) {
/*  61 */       return null;
/*     */     }
/*     */     try {
/*  64 */       return encoding(text.getBytes("UTF-8"));
/*     */     } catch (UnsupportedEncodingException e) {
/*  66 */       log.error(e.getMessage());
/*     */     }
/*  68 */     return null;
/*     */   }
/*     */   
/*     */   public static final String encodeTwice(String text) {
/*  72 */     if (text == null) {
/*  73 */       return null;
/*     */     }
/*     */     try {
/*  76 */       String md5Once = encoding(text.getBytes("UTF-8"));
/*  77 */       return encoding(md5Once.getBytes("UTF-8"));
/*     */     } catch (UnsupportedEncodingException e) {
/*  79 */       log.error(e.getMessage());
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String encodingFile(String filePath)
/*     */   {
/*  91 */     InputStream fis = null;
/*     */     try {
/*  93 */       fis = new FileInputStream(filePath);
/*  94 */       return encoding(fis);
/*     */     } catch (Exception ee) {
/*  96 */       return null;
/*     */     } finally {
/*  98 */       if (fis != null) {
/*     */         try {
/* 100 */           fis.close();
/*     */         }
/*     */         catch (Exception localException3) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String encoding(InputStream fis)
/*     */     throws Exception
/*     */   {
/* 115 */     byte[] buffer = new byte['Ѐ'];
/* 116 */     MessageDigest md5 = MessageDigest.getInstance("MD5");
/* 117 */     int numRead = 0;
/* 118 */     while ((numRead = fis.read(buffer)) > 0) {
/* 119 */       md5.update(buffer, 0, numRead);
/*     */     }
/* 121 */     return toHexString(md5.digest());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String toHexString(byte[] b)
/*     */   {
/* 131 */     StringBuilder sb = new StringBuilder(b.length * 2);
/* 132 */     for (int i = 0; i < b.length; i++) {
/* 133 */       sb.append(hexChar[((b[i] & 0xF0) >>> 4)]);
/* 134 */       sb.append(hexChar[(b[i] & 0xF)]);
/*     */     }
/* 136 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean validate(String md5Str)
/*     */   {
/* 146 */     if ((md5Str == null) || (md5Str.length() != 32)) {
/* 147 */       return false;
/*     */     }
/* 149 */     byte[] by = md5Str.getBytes();
/* 150 */     for (int i = 0; i < by.length; i++) {
/* 151 */       int asciiValue = by[i];
/* 152 */       if ((asciiValue < 48) || ((asciiValue > 57) && (asciiValue < 65)) || ((asciiValue > 70) && (asciiValue < 97)) || (asciiValue > 102))
/*     */       {
/*     */ 
/*     */ 
/* 156 */         return false;
/*     */       }
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\util\MD5Tool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */