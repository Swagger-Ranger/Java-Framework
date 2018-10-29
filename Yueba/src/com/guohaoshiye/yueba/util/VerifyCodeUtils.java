/*     */ package com.aiwan.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerifyCodeUtils
/*     */ {
/*     */   public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
/*  26 */   private static Random random = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String generateVerifyCode(int verifySize)
/*     */   {
/*  35 */     return generateVerifyCode(verifySize, "23456789ABCDEFGHJKLMNPQRSTUVWXYZ");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String generateVerifyCode(int verifySize, String sources)
/*     */   {
/*  44 */     if ((sources == null) || (sources.length() == 0)) {
/*  45 */       sources = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
/*     */     }
/*  47 */     int codesLen = sources.length();
/*  48 */     Random rand = new Random(System.currentTimeMillis());
/*  49 */     StringBuilder verifyCode = new StringBuilder(verifySize);
/*  50 */     for (int i = 0; i < verifySize; i++) {
/*  51 */       verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
/*     */     }
/*  53 */     return verifyCode.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String outputVerifyImage(int w, int h, File outputFile, int verifySize)
/*     */     throws IOException
/*     */   {
/*  66 */     String verifyCode = generateVerifyCode(verifySize);
/*  67 */     outputImage(w, h, outputFile, verifyCode);
/*  68 */     return verifyCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String outputVerifyImage(int w, int h, OutputStream os, int verifySize)
/*     */     throws IOException
/*     */   {
/*  81 */     String verifyCode = generateVerifyCode(verifySize);
/*  82 */     outputImage(w, h, os, verifyCode);
/*  83 */     return verifyCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void outputImage(int w, int h, File outputFile, String code)
/*     */     throws IOException
/*     */   {
/*  95 */     if (outputFile == null) {
/*  96 */       return;
/*     */     }
/*  98 */     File dir = outputFile.getParentFile();
/*  99 */     if (!dir.exists()) {
/* 100 */       dir.mkdirs();
/*     */     }
/*     */     try {
/* 103 */       outputFile.createNewFile();
/* 104 */       FileOutputStream fos = new FileOutputStream(outputFile);
/* 105 */       outputImage(w, h, fos, code);
/* 106 */       fos.close();
/*     */     } catch (IOException e) {
/* 108 */       throw e;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void outputImage(int w, int h, OutputStream os, String code)
/*     */     throws IOException
/*     */   {
/* 121 */     int verifySize = code.length();
/* 122 */     BufferedImage image = new BufferedImage(w, h, 1);
/* 123 */     Random rand = new Random();
/* 124 */     Graphics2D g2 = image.createGraphics();
/* 125 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 126 */     Color[] colors = new Color[5];
/* 127 */     Color[] colorSpaces = { Color.WHITE, Color.CYAN, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW };
/*     */     
/*     */ 
/* 130 */     float[] fractions = new float[colors.length];
/* 131 */     for (int i = 0; i < colors.length; i++) {
/* 132 */       colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];
/* 133 */       fractions[i] = rand.nextFloat();
/*     */     }
/* 135 */     Arrays.sort(fractions);
/*     */     
/* 137 */     g2.setColor(Color.white);
/* 138 */     g2.fillRect(0, 0, w, h);
/*     */     
/* 140 */     Color c = getRandColor(200, 255);
/* 141 */     g2.setColor(c);
/* 142 */     g2.fillRect(0, 2, w, h - 4);
/*     */     
/*     */ 
/* 145 */     Random random = new Random();
/* 146 */     g2.setColor(getRandColor(160, 250));
/* 147 */     for (int i = 0; i < 20; i++) {
/* 148 */       int x = random.nextInt(w - 1);
/* 149 */       int y = random.nextInt(h - 1);
/* 150 */       int xl = random.nextInt(6) + 1;
/* 151 */       int yl = random.nextInt(12) + 1;
/* 152 */       g2.drawLine(x, y, x + xl + 40, y + yl + 20);
/*     */     }
/*     */     
/*     */ 
/* 156 */     float yawpRate = 0.05F;
/* 157 */     int area = (int)(yawpRate * w * h);
/* 158 */     for (int i = 0; i < area; i++) {
/* 159 */       int x = random.nextInt(w);
/* 160 */       int y = random.nextInt(h);
/* 161 */       int rgb = getRandomIntColor();
/* 162 */       image.setRGB(x, y, rgb);
/*     */     }
/*     */     
/* 165 */     shear(g2, w, h, c);
/*     */     
/* 167 */     g2.setColor(getRandColor(100, 160));
/* 168 */     int fontSize = h;
/* 169 */     Font font = new Font("Algerian", 2, fontSize);
/* 170 */     g2.setFont(font);
/* 171 */     char[] chars = code.toCharArray();
/* 172 */     for (int i = 0; i < verifySize; i++) {
/* 173 */       AffineTransform affine = new AffineTransform();
/* 174 */       affine.setToRotation(0.7853981633974483D * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), w / verifySize * i + fontSize / 2, h / 2);
/* 175 */       g2.setTransform(affine);
/* 176 */       g2.drawChars(chars, i, 1, (w - 10) / verifySize * i + 5, h / 2 + fontSize / 2 - 5);
/*     */     }
/*     */     
/* 179 */     g2.dispose();
/* 180 */     ImageIO.write(image, "jpg", os);
/*     */   }
/*     */   
/*     */   private static Color getRandColor(int fc, int bc) {
/* 184 */     if (fc > 255)
/* 185 */       fc = 255;
/* 186 */     if (bc > 255)
/* 187 */       bc = 255;
/* 188 */     int r = fc + random.nextInt(bc - fc);
/* 189 */     int g = fc + random.nextInt(bc - fc);
/* 190 */     int b = fc + random.nextInt(bc - fc);
/* 191 */     return new Color(r, g, b);
/*     */   }
/*     */   
/*     */   private static int getRandomIntColor() {
/* 195 */     int[] rgb = getRandomRgb();
/* 196 */     int color = 0;
/* 197 */     for (int c : rgb) {
/* 198 */       color <<= 8;
/* 199 */       color |= c;
/*     */     }
/* 201 */     return color;
/*     */   }
/*     */   
/*     */   private static int[] getRandomRgb() {
/* 205 */     int[] rgb = new int[3];
/* 206 */     for (int i = 0; i < 3; i++) {
/* 207 */       rgb[i] = random.nextInt(255);
/*     */     }
/* 209 */     return rgb;
/*     */   }
/*     */   
/*     */   private static void shear(Graphics g, int w1, int h1, Color color) {
/* 213 */     shearX(g, w1, h1, color);
/* 214 */     shearY(g, w1, h1, color);
/*     */   }
/*     */   
/*     */   private static void shearX(Graphics g, int w1, int h1, Color color)
/*     */   {
/* 219 */     int period = random.nextInt(2);
/*     */     
/* 221 */     boolean borderGap = true;
/* 222 */     int frames = 1;
/* 223 */     int phase = random.nextInt(2);
/*     */     
/* 225 */     for (int i = 0; i < h1; i++)
/*     */     {
/* 227 */       double d = (period >> 1) * Math.sin(i / period + 6.283185307179586D * phase / frames);
/*     */       
/*     */ 
/* 230 */       g.copyArea(0, i, w1, 1, (int)d, 0);
/* 231 */       if (borderGap) {
/* 232 */         g.setColor(color);
/* 233 */         g.drawLine((int)d, i, 0, i);
/* 234 */         g.drawLine((int)d + w1, i, w1, i);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static void shearY(Graphics g, int w1, int h1, Color color)
/*     */   {
/* 242 */     int period = random.nextInt(40) + 10;
/*     */     
/* 244 */     boolean borderGap = true;
/* 245 */     int frames = 20;
/* 246 */     int phase = 7;
/* 247 */     for (int i = 0; i < w1; i++)
/*     */     {
/* 249 */       double d = (period >> 1) * Math.sin(i / period + 6.283185307179586D * phase / frames);
/*     */       
/*     */ 
/* 252 */       g.copyArea(i, 0, 1, h1, 0, (int)d);
/* 253 */       if (borderGap) {
/* 254 */         g.setColor(color);
/* 255 */         g.drawLine(i, (int)d, i, 0);
/* 256 */         g.drawLine(i, (int)d + h1, i, h1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws IOException
/*     */   {
/* 263 */     File dir = new File("F:/verifies");
/* 264 */     int w = 200;int h = 80;
/* 265 */     for (int i = 0; i < 50; i++) {
/* 266 */       String verifyCode = generateVerifyCode(4);
/* 267 */       File file = new File(dir, verifyCode + ".jpg");
/* 268 */       outputImage(w, h, file, verifyCode);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\util\VerifyCodeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */