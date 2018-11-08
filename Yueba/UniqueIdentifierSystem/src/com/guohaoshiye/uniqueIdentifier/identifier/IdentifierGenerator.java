package com.guohaoshiye.uniqueIdentifier.identifier;

import com.guohaoshiye.uniqueIdentifier.util.IdentifierUtil;

import java.math.BigInteger;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger
 * FileName: IdentifierGenerator
 * Author:   liufei32@outlook.com
 * Date:     2018/11/3 14:23
 * Description: 生成唯一标识码的生成类--用来定义标识码的生成规则
 * Aha-eureka: 次方数                 次方和
 *             62^2 = 3844          --- 3906
 *             62^3 = 238328        --- 242234
 *             62^4 = 14776336      --- 15018570
 *             62^5 = 916132832     --- 931151402
 *             62^6 = 56800235584   --- 57731386986
 *******************************************************************************/

public abstract class IdentifierGenerator {

//    public static final Alphabet BUSINESSCODE = new Alphabet("ss");


    /***************************
     * 2-6-6-3-1
     * 2:公司业务码
     * 6:基础用户码--一旦生成就不会改变
     * 6:上一个用户的基础码，用以储存分销关系
     * 3:备用码
     * 1:校验码
     * *************************/

    public Alphabet alphabet;
    public AlphabetOperate alphabetOperate;
    int lengthOfID;
    int businessLength;
    int baseLength;
    int reserveLength;
//    String Identifier;




//
//    private IdentifierGenerator(){
//        this.lengthOfID = 18;
//
//    }



    /**
     * 按指定规则(业务码+基础码+上一级基础码+备用码+校验码1）码长生成一个新的码
     * */
    protected IdentifierGenerator(Alphabet alphabet, int businessLength, int baseLength, int reserveLength) {
        this.alphabet = alphabet;
        this.alphabetOperate = new AlphabetOperate(alphabet);

        this.businessLength = businessLength;
        this.baseLength = baseLength;
        this.reserveLength = reserveLength;
        this.lengthOfID = businessLength + baseLength * 2 + reserveLength + 1;

    }

    protected IdentifierGenerator(int businessLength, int baseLength, int reserveLength) {
        this.alphabet = new Alphabet();
        this.alphabetOperate = new AlphabetOperate(alphabet);

        this.businessLength = businessLength;
        this.baseLength = baseLength;
        this.reserveLength = reserveLength;
        this.lengthOfID = businessLength + baseLength * 2 + reserveLength + 1;
    }

    /**
     * 获取校验码
     * */
    protected String getCheckCode(String significantBit) {
        //先检查有效位长度是否正确
//        System.out.println(significantBit.length()+" lengthofID:"+lengthOfID);
        if (significantBit.length() != lengthOfID - 1) {
            throw new Error("the identifier of significant bit is wrong!");
        }
        String code = IdentifierUtil.getCheckCode(alphabet, significantBit);
        return code;
    }


    /**
     * 从给定的码生成新码，使用默认的18位方式
     * */
    protected abstract String generateIdentifier(String oldID);

    /**
     * 校验标识码是否正确
     * */
    public void checkIdentifier(String code) {
//        System.out.println("ID's length is "+ code.length());
        int[] operators = alphabet.toIndices(code);
        boolean lengthCheck = code.length() != lengthOfID;
        boolean codeCheck;
        BigInteger count;

        int checkCode = operators[operators.length - 1];

        //求和以计算模数来校验校验码
        codeCheck = getCheckCode(code.substring(0, code.length() - 1)).equals(checkCode);

        if (lengthCheck || codeCheck) {
            throw new Error("wrong Identifier,Please check your code!");
        }

    }

    public int getLengthOfID() {
        return this.lengthOfID;
    }

    public int getBusinessLength() {
        return this.businessLength;
    }

    public int getBaseLength() {
        return this.baseLength;
    }

    public int getReserveLength() {
        return this.reserveLength;
    }
}
