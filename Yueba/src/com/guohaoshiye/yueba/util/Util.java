/*     */ package com.aiwan.util;
/*     */ 
/*     */ import com.aiwan.entity.AdminRole;
/*     */ import com.aiwan.entity.TreeNodes;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Util
/*     */ {
/*     */   public static String Md5(String plainText)
/*     */   {
/*  41 */     StringBuffer buf = null;
/*     */     try {
/*  43 */       MessageDigest md = MessageDigest.getInstance("MD5");
/*  44 */       md.update(plainText.getBytes());
/*  45 */       byte[] b = md.digest();
/*     */       
/*  47 */       buf = new StringBuffer("");
/*  48 */       for (int offset = 0; offset < b.length; offset++) {
/*  49 */         int i = b[offset];
/*  50 */         if (i < 0) i += 256;
/*  51 */         if (i < 16)
/*  52 */           buf.append("0");
/*  53 */         buf.append(Integer.toHexString(i));
/*     */       }
/*     */     } catch (NoSuchAlgorithmException e) {
/*  56 */       e.printStackTrace();
/*     */     }
/*  58 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public void test()
/*     */   {
/*  63 */     System.out.println(StringReplace("游客10001"));
/*     */   }
/*     */   
/*     */   public static boolean isChineseChar(String str) {
/*  67 */     boolean temp = false;
/*  68 */     Pattern p = Pattern.compile("[一-龥]{2,4}");
/*  69 */     Matcher m = p.matcher(str);
/*  70 */     if (m.matches()) {
/*  71 */       temp = true;
/*     */     }
/*  73 */     return temp;
/*     */   }
/*     */   
/*     */   public static boolean isEngAndNumber(String str) {
/*  77 */     boolean temp = false;
/*  78 */     Pattern p = Pattern.compile("^\\w+");
/*  79 */     Matcher m = p.matcher(str);
/*  80 */     if (m.matches()) {
/*  81 */       temp = true;
/*     */     }
/*  83 */     return temp;
/*     */   }
/*     */   
/*     */   public static boolean checkPhone(String str) {
/*  87 */     boolean temp = false;
/*  88 */     Pattern p = Pattern.compile("^1\\d{10}$");
/*  89 */     Matcher m = p.matcher(str);
/*  90 */     if (m.matches()) {
/*  91 */       temp = true;
/*     */     }
/*  93 */     return temp;
/*     */   }
/*     */   
/*     */   public static String StringReplace(String str)
/*     */   {
/*  98 */     if (str.length() < 3)
/*     */     {
/* 100 */       return str + "***";
/*     */     }
/* 102 */     Pattern p = Pattern.compile("(\\S{2})(\\S+)(\\S{1})");
/* 103 */     Matcher m = p.matcher(str);
/* 104 */     str = m.replaceAll("$1***$3");
/* 105 */     return str;
/*     */   }
/*     */   
/*     */   public static boolean isValidDate(String str)
/*     */   {
/* 110 */     boolean convertSuccess = true;
/* 111 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/*     */     try {
/* 113 */       format.setLenient(false);
/* 114 */       format.parse(str);
/*     */     }
/*     */     catch (ParseException e)
/*     */     {
/* 118 */       convertSuccess = false;
/*     */     }
/* 120 */     return convertSuccess;
/*     */   }
/*     */   
/*     */   public static Set<AdminRole> sortByValue(Set<AdminRole> set) {
/* 124 */     List<AdminRole> setList = new ArrayList(set);
/* 125 */     Collections.sort(setList, new Util.1());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     set = new LinkedHashSet(setList);
/* 134 */     return set;
/*     */   }
/*     */   
/*     */   public static boolean writeFile(String filePath, String sets) {
/* 138 */     try { PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
/* 139 */       out.write(sets);
/* 140 */       out.println();
/* 141 */       out.close();
/* 142 */       return true;
/*     */     } catch (IOException e) {
/* 144 */       e.printStackTrace(); }
/* 145 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getImgWidth(File file)
/*     */   {
/* 156 */     InputStream is = null;
/* 157 */     BufferedImage src = null;
/* 158 */     int ret = -1;
/*     */     try {
/* 160 */       is = new FileInputStream(file);
/* 161 */       src = ImageIO.read(is);
/* 162 */       ret = src.getWidth(null);
/* 163 */       is.close();
/*     */     } catch (Exception e) {
/* 165 */       e.printStackTrace();
/*     */     }
/* 167 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getImgHeight(File file)
/*     */   {
/* 177 */     InputStream is = null;
/* 178 */     BufferedImage src = null;
/* 179 */     int ret = -1;
/*     */     try {
/* 181 */       is = new FileInputStream(file);
/* 182 */       src = ImageIO.read(is);
/* 183 */       ret = src.getHeight(null);
/* 184 */       is.close();
/*     */     } catch (Exception e) {
/* 186 */       e.printStackTrace();
/*     */     }
/* 188 */     return ret;
/*     */   }
/*     */   
/*     */   public static void cutFile(File file1, File file2)
/*     */   {
/* 193 */     FileOutputStream fileOutputStream = null;
/* 194 */     InputStream inputStream = null;
/* 195 */     byte[] bytes = new byte['Ѐ'];
/* 196 */     int temp = 0;
/*     */     try {
/* 198 */       inputStream = new FileInputStream(file1);
/* 199 */       fileOutputStream = new FileOutputStream(file2);
/* 200 */       while ((temp = inputStream.read(bytes)) != -1) {
/* 201 */         fileOutputStream.write(bytes, 0, temp);
/* 202 */         fileOutputStream.flush();
/*     */       }
/*     */       return;
/* 205 */     } catch (FileNotFoundException e) { e.printStackTrace();
/*     */     } catch (IOException e) {
/* 207 */       e.printStackTrace();
/*     */     } finally {
/* 209 */       if (inputStream != null) {
/*     */         try {
/* 211 */           inputStream.close();
/*     */         } catch (IOException e) {
/* 213 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 216 */       if (fileOutputStream != null) {
/*     */         try {
/* 218 */           fileOutputStream.close();
/*     */         } catch (IOException e) {
/* 220 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<TreeNodes> buildByRecursive(List<TreeNodes> treeNodes, int pid)
/*     */   {
/* 233 */     List<TreeNodes> trees = new ArrayList();
/* 234 */     for (TreeNodes treeNode : treeNodes) {
/* 235 */       if (pid == treeNode.getCode()) {
/* 236 */         trees.add(findChildren(treeNode, treeNodes));
/*     */       }
/*     */     }
/* 239 */     return trees;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TreeNodes findChildren(TreeNodes treeNode, List<TreeNodes> treeNodes)
/*     */   {
/* 248 */     for (TreeNodes it : treeNodes) {
/* 249 */       if (treeNode.getCode() == it.getParentCode()) {
/* 250 */         if (treeNode.getChild() == null) {
/* 251 */           treeNode.setChild(new ArrayList());
/*     */         }
/* 253 */         treeNode.getChild().add(findChildren(it, treeNodes));
/*     */       }
/*     */     }
/* 256 */     return treeNode;
/*     */   }
/*     */   
/*     */   public static String getIpAddress(HttpServletRequest request)
/*     */   {
/* 261 */     String ip = request.getHeader("x-forwarded-for");
/* 262 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 263 */       ip = request.getHeader("Proxy-Client-IP");
/*     */     }
/* 265 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 266 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/* 268 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 269 */       ip = request.getHeader("HTTP_CLIENT_IP");
/*     */     }
/* 271 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 272 */       ip = request.getHeader("HTTP_X_FORWARDED_FOR");
/*     */     }
/* 274 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 275 */       ip = request.getRemoteAddr();
/*     */     }
/* 277 */     return ip;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\util\Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */