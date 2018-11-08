package com.guohaoshiye.uniqueIdentifier.identifier;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Identifier
 * Author:   liufei32@outlook.com
 * Date:     2018/11/7 9:47
 * Description: 标识码类;继承IdentifierGenerator的标识码生成规则
 * Aha-eureka:
 *******************************************************************************/

public class Identifier extends IdentifierGenerator {

    String businessCode;
    String reserveCode;

    //给定字符集构造初始的标识码
    public Identifier(Alphabet alphabet, int businessLength, int baseLength, int reserveLength,String businessCode,String baseCode,String reserveCode) {
        super(alphabet, businessLength, baseLength, reserveLength);
        this.businessCode = businessCode;
        this.reserveCode = reserveCode;

        if (baseCode.length() != baseLength || reserveCode.length() != reserveLength) {
            throw new IllegalArgumentException("there is a argument error,businessCode or reserveCode that's length is not equals to input!");
        } else {
            this.businessCode = baseCode;
            this.reserveCode = reserveCode;
        }

    }

    //使用默认的字符集构造标识码
    public Identifier(int businessLength, int baseLength, int reserveLength,String businessCode,String baseCode,String reserveCode) {

        super(businessLength, baseLength, reserveLength);
        this.businessCode = businessCode;
        this.reserveCode = reserveCode;

        if (baseCode.length() != baseLength || reserveCode.length() != reserveLength) {
            throw new IllegalArgumentException("there is a argument error,businessCode or reserveCode that's length is not equals to input!");
        } else {
            this.businessCode = businessCode;
            this.reserveCode = reserveCode;
        }

    }

//    public Identifier(Alphabet alphabet, String businessCode, String baseCode, String reserveCode) {
//        super(alphabet, super.businessLength=businessCode.length(), baseLength, reserveLength);
//
//    }

    //从一个标识码生成另一个标识码
    public String generateIdentifier(String preID) {
        checkIdentifier(preID);

        //根据上一个ID的基础码生成新用户的基础码
        String preBasecode = preID.substring(businessLength, businessLength + baseLength);
        String newBasecode = alphabetOperate.increase(preBasecode);

        //默认原有的业务码和备用码
        StringBuilder newID = new StringBuilder(businessCode);
//        System.out.println("erlr newID: "+ newID);
//        System.out.println(preBasecode);
//        newID.append(newBasecode).append(preBasecode).append(preID.substring(businessLength + baseLength * 2, reserveLength));
        newID.append(newBasecode).append(preBasecode).append(reserveCode);
//        System.out.println(newID);
        String checkcode = getCheckCode(newID.toString());

        return newID.toString() + checkcode;
    }

//    public String trackIdentifier()

    public static void main(String[] args) {

        Identifier id = new Identifier(2, 6, 3, "00", "123456", "qwe");
//        System.out.println(id.getCheckCode("00123456000000qwe"));

        System.out.println(id.generateIdentifier("00123456000000qwen"));
    }

}
