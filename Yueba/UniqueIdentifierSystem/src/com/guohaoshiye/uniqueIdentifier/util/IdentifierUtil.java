package com.guohaoshiye.uniqueIdentifier.util;

import com.guohaoshiye.uniqueIdentifier.identifier.Alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: IdentifierUtil
 * Author:   liufei32@outlook.com
 * Date:     2018/11/7 0:10
 * Description: 标识码工具类
 * Aha-eureka:
 *******************************************************************************/

public class IdentifierUtil {

    /**
     * 根据字符集基码来获得校验码--这里直接使用每项求和然后求质数61的模
     * */
    public static String getCheckCode(Alphabet alphabet,String str) {
        int count = 0;
        int[] a = alphabet.toIndices(str);
        for (int i = a.length - 1; i > 0; i--) {
            count += a[i];
        }
        return String.valueOf(alphabet.toChar(count % 61));
    }

    /**
     * 根据标识码的生成规则和当前的标识码去获得上一个标识码,这里使用2-6-6-3-1的默认标识码规则
     * */
    public static String getPreCode(int businessLength,int baseLength,int reverseLength,String str) {
//        StringBuilder preCode=str.substring()

        return "";

    }

    //将所有的标识码读入到SET中
    public static Set<String> generateIDHashSet(BufferedReader in) throws IOException {
        String Identifiers = in.readLine();
        Set IDsets = new HashSet<String>();
        IDsets.add(Identifiers);
        return IDsets;
    }


    /**
     * 对标识码作排序
     * */
    public static void sortIdentifiers() {

    }


}
