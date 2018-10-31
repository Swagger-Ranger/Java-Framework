package com.guohaoshiye.yueba.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







public class MD5Tool
{
  private static final int ASCII_0 = 48;
  private static final int ASCII_9 = 57;
  private static final int ASCII_A = 65;
  private static final int ASCII_F = 70;
  private static final int ASCII_a = 97;
  private static final int ASCII_f = 102;
  private static final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };


  private static final String HASH_MD5 = "MD5";

  private static Logger log = LoggerFactory.getLogger(MD5Tool.class);







  public static final String encoding(byte[] bs)
  {
    String encodingStr = null;
    try {
      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
      mdTemp.update(bs);

      return toHexString(mdTemp.digest());
    }
    catch (Exception e) {
      log.error(e.getMessage());
    }

    return encodingStr;
  }






  public static final String encoding(String text)
  {
    if (text == null) {
      return null;
    }
    try {
      return encoding(text.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      log.error(e.getMessage());
    }
    return null;
  }

  public static final String encodeTwice(String text) {
    if (text == null) {
      return null;
    }
    try {
      String md5Once = encoding(text.getBytes("UTF-8"));
      return encoding(md5Once.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      log.error(e.getMessage());
    }
    return null;
  }






  public static final String encodingFile(String filePath)
  {
    InputStream fis = null;
    try {
      fis = new FileInputStream(filePath);
      return encoding(fis);
    } catch (Exception ee) {
      return null;
    } finally {
      if (fis != null) {
        try {
          fis.close();
        }
        catch (Exception localException3) {}
      }
    }
  }






  public static final String encoding(InputStream fis)
    throws Exception
  {
    byte[] buffer = new byte['Ѐ'];
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    int numRead = 0;
    while ((numRead = fis.read(buffer)) > 0) {
      md5.update(buffer, 0, numRead);
    }
    return toHexString(md5.digest());
  }






  public static String toHexString(byte[] b)
  {
    StringBuilder sb = new StringBuilder(b.length * 2);
    for (int i = 0; i < b.length; i++) {
      sb.append(hexChar[((b[i] & 0xF0) >>> 4)]);
      sb.append(hexChar[(b[i] & 0xF)]);
    }
    return sb.toString();
  }






  public static boolean validate(String md5Str)
  {
    if ((md5Str == null) || (md5Str.length() != 32)) {
      return false;
    }
    byte[] by = md5Str.getBytes();
    for (int i = 0; i < by.length; i++) {
      int asciiValue = by[i];
      if ((asciiValue < 48) || ((asciiValue > 57) && (asciiValue < 65)) || ((asciiValue > 70) && (asciiValue < 97)) || (asciiValue > 102))
      {


        return false;
      }
    }
    return true;
  }
}

