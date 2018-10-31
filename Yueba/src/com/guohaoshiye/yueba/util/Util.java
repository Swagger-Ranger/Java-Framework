package com.guohaoshiye.yueba.util;

import com.guohaoshiye.yueba.entity.AdminRole;
import com.guohaoshiye.yueba.entity.TreeNodes;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;









public class Util
{
  public static String Md5(String plainText)
  {
    StringBuffer buf = null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes());
      byte[] b = md.digest();

      buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++) {
        int i = b[offset];
        if (i < 0) i += 256;
        if (i < 16)
          buf.append("0");
        buf.append(Integer.toHexString(i));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return buf.toString();
  }

  public void test()
  {
    System.out.println(StringReplace("游客10001"));
  }

  public static boolean isChineseChar(String str) {
    boolean temp = false;
    Pattern p = Pattern.compile("[一-龥]{2,4}");
    Matcher m = p.matcher(str);
    if (m.matches()) {
      temp = true;
    }
    return temp;
  }

  public static boolean isEngAndNumber(String str) {
    boolean temp = false;
    Pattern p = Pattern.compile("^\\w+");
    Matcher m = p.matcher(str);
    if (m.matches()) {
      temp = true;
    }
    return temp;
  }

  public static boolean checkPhone(String str) {
    boolean temp = false;
    Pattern p = Pattern.compile("^1\\d{10}$");
    Matcher m = p.matcher(str);
    if (m.matches()) {
      temp = true;
    }
    return temp;
  }

  public static String StringReplace(String str)
  {
    if (str.length() < 3)
    {
      return str + "***";
    }
    Pattern p = Pattern.compile("(\\S{2})(\\S+)(\\S{1})");
    Matcher m = p.matcher(str);
    str = m.replaceAll("$1***$3");
    return str;
  }

  public static boolean isValidDate(String str)
  {
    boolean convertSuccess = true;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    try {
      format.setLenient(false);
      format.parse(str);
    }
    catch (ParseException e)
    {
      convertSuccess = false;
    }
    return convertSuccess;
  }

  public static Set<AdminRole> sortByValue(Set<AdminRole> set) {
    List<AdminRole> setList = new ArrayList(set);




//    Collections.sort(setList, new Util.1());
    Collections.sort(setList, new Comparator<AdminRole>() {
      @Override
      public int compare(AdminRole o1, AdminRole o2) {
        return o1.getId().compareTo(o2.getId());
      }
    });







    set = new LinkedHashSet(setList);
    return set;
  }

  public static boolean writeFile(String filePath, String sets) {
    try { PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
      out.write(sets);
      out.println();
      out.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace(); }
    return false;
  }







  public static int getImgWidth(File file)
  {
    InputStream is = null;
    BufferedImage src = null;
    int ret = -1;
    try {
      is = new FileInputStream(file);
      src = ImageIO.read(is);
      ret = src.getWidth(null);
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }






  public static int getImgHeight(File file)
  {
    InputStream is = null;
    BufferedImage src = null;
    int ret = -1;
    try {
      is = new FileInputStream(file);
      src = ImageIO.read(is);
      ret = src.getHeight(null);
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }

  public static void cutFile(File file1, File file2)
  {
    FileOutputStream fileOutputStream = null;
    InputStream inputStream = null;
    byte[] bytes = new byte['Ѐ'];
    int temp = 0;
    try {
      inputStream = new FileInputStream(file1);
      fileOutputStream = new FileOutputStream(file2);
      while ((temp = inputStream.read(bytes)) != -1) {
        fileOutputStream.write(bytes, 0, temp);
        fileOutputStream.flush();
      }
      return;
    } catch (FileNotFoundException e) { e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileOutputStream != null) {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }






  public static List<TreeNodes> buildByRecursive(List<TreeNodes> treeNodes, int pid)
  {
    List<TreeNodes> trees = new ArrayList();
    for (TreeNodes treeNode : treeNodes) {
      if (pid == treeNode.getCode()) {
        trees.add(findChildren(treeNode, treeNodes));
      }
    }
    return trees;
  }





  public static TreeNodes findChildren(TreeNodes treeNode, List<TreeNodes> treeNodes)
  {
    for (TreeNodes it : treeNodes) {
      if (treeNode.getCode() == it.getParentCode()) {
        if (treeNode.getChild() == null) {
          treeNode.setChild(new ArrayList());
        }
        treeNode.getChild().add(findChildren(it, treeNodes));
      }
    }
    return treeNode;
  }

  public static String getIpAddress(HttpServletRequest request)
  {
    String ip = request.getHeader("x-forwarded-for");
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("HTTP_CLIENT_IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
}

