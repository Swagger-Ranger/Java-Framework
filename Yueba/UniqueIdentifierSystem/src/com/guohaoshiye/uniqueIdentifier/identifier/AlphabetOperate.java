package com.guohaoshiye.uniqueIdentifier.identifier;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: AlphabetOperate
 * Author:   liufei32@outlook.com
 * Date:     2018/11/3 15:58
 * Description: 字符集基码的操作类
 * Aha-eureka:
 *******************************************************************************/

public class AlphabetOperate {

    //字符集
    Alphabet alphabet;


    public AlphabetOperate(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    //字符集加法运算
    public String addition(String m,String n) {


        return "";
    }

    //进位判断,超过基数长度就需要进位
    private boolean shiftadd(int i) {
        return ++i > alphabet.getCharSet().length - 1;
    }

    //自增一
    public String increase(String a) {
        int[] operators = alphabet.toIndices(a);

        //注意溢出
        for (int i = operators.length-1; shiftadd(operators[i]++); i--){
            if (i <= 0) {
                throw new ArrayIndexOutOfBoundsException("out of the max of the number!");
            }
            operators[i] = 0;
        }
        return alphabet.toChars(operators);
    }


    /**
     * 转化成十进制数
     * */
    public long transToDecimal(String str) {
        long deci = 0;
        int[] a = alphabet.toIndices(str);
        for (int i = a.length - 1; i > 0; i--) {
            deci += (long) Math.pow(alphabet.radix(), a.length - i) * a[i];
//            System.out.println((long) Math.pow(alphabet.radix(), a.length - i));
        }
        return deci;
    }

    //字符求和
    public int count(String str) {
        int count = 0;
        int[] a = alphabet.toIndices(str);
        for (int i = a.length - 1; i > 0; i--) {
            count += a[i];
        }
        return count;
    }


    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        AlphabetOperate ao = new AlphabetOperate(alphabet);

//        System.out.println(ao.increase("8999"));
        System.out.println(ao.transToDecimal("BBBA"));
    }
}
