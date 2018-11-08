package com.guohaoshiye.uniqueIdentifier.identifier;

import java.util.Arrays;
/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger
 * FileName: Alphabet
 * Author:   liufei32@outlook.com
 * Date:     2018/11/3 14:08
 * Description: 字符集基表类
 * Aha-eureka:
 *******************************************************************************/

public class Alphabet {

    /**
     * 常用字符集
    public static final Alphabet BINARY = new Alphabet("01");

    public static final Alphabet OCTAL = new Alphabet("01234567");

    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    public static final Alphabet DNA = new Alphabet("ACGT");

    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    public static final Alphabet ASCII = new Alphabet(128);

    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    public static final Alphabet UNICODE16      = new Alphabet(65536);*/

    private char[] alphabet;     // the characters in the alphabet
    private int[] inverse;       // indices索引以便查询字符集是否包含某一字符
    private final int R;         // the radix of the alphabet字符集的基数

    /**
     * 按照给定的字符串来初始化一个字符集
     * 这里在检查重复元素和下标对应到字符集时使用了一个技巧：array[char]，将Unicode编码和数组大小就为Character.MAX_VALUE
     * 初始化一个unicode大小的数组 Character.MAX_VALUE=\\uFFFF 作重复元素检查，\\uFFFF 是Unicode的最大元素，\\u表示Unicode值
     * @param alpha the set of characters
     */
    public Alphabet(String alpha) {

        // check that alphabet contains no duplicate chars
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        //将对应数组初始化为-1，以便之后的包含判断contains()方法
        for (int i = 0; i < inverse.length; i++)
            inverse[i] = -1;

        // can't use char since R can be as big as 65,536
        //将下标对应到字符集中---这个是关键
        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }

    /**
     * 直接使用0-R来构造字符集
     */
    private Alphabet(int radix) {
        this.R = radix;
        alphabet = new char[R];
        inverse = new int[R];

        // can't use char since R can be as big as 65,536
        for (int i = 0; i < R; i++)
            alphabet[i] = (char) i;
        for (int i = 0; i < R; i++)
            inverse[i] = i;
    }

//    /**
//     * 使用默认的0-255个字符为编码表
//     */
//    public Alphabet() {
//        this(256);
//    }
    
    /**
     * 无参构造器初始化一个62位的英文大小写和十进制的字符集
    * */
    public Alphabet() {
        this("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }


    /**
     * 获取字符集元素组成数组
     * */
    public char[] getCharSet() {
        return alphabet;

    }



    /**
     * 判断字符编码中是否包含特定字符
     */
    public boolean contains(char c)  {
        return inverse[c] != -1;
    }

    /**
     * 返回字符集的基数数量
     */
    public int radix() {
        return R;
    }

    /**
     * 返回二进制的指数
     */
    public int lgR() {
        int lgR = 0;
        for (int t = R-1; t >= 1; t /= 2)
            lgR++;
        return lgR;
    }

    /**
     * 返回字符所在字符集的位置，没有就抛出异常
     */
    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    /**
     * 返回数组字符所在字符集对于的位置数组，是对toIndex的扩展
     */
    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target  = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }

    /**
     * toIndex的逆方法，返回数字数组对应的字符数组
     */
    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
        }
        return alphabet[index];
    }

    /**
     * toIndices的逆方法，返回数字数组对应的字符串
     */
    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++)
            s.append(toChar(indices[i]));
        return s.toString();
    }

    public static void main(String[] args) {

        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Alphabet alphabet = new Alphabet(str);
        System.out.println(Arrays.toString(alphabet.alphabet)+"\n"+alphabet.radix());

        System.out.println(Arrays.toString(alphabet.toIndices(str)));

    }
}
