package com.cloud.common.utils;

import java.util.Random;

/**
 * @author RuanChaoChao
 * @description: 生成验证码工具类
 * @Date 2023-5-11 上午 10:09
 */
public class GenCodeUtils {

    /**
     * 数字类型
     */
    private static final String NUMBER_STR = "0123456789";
    /**
     * 字母类型
     */
    private static final String LETTERS_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 短信验证码长度
     */
    private static final Integer SMS_CODE_LENGTH = 4;

    /**
     * 生成短信四位验证码
     * @return 验证码
     */
    public static String genLetterStrSms(){
        return genCode(LETTERS_STR, SMS_CODE_LENGTH);
    }

    /**
     * 生成短信四位验证码
     * @return 验证码
     */
    public static String genNumberCodeSms(){
        return genCode(NUMBER_STR, SMS_CODE_LENGTH);
    }

    /**
     * 生成验证码
     * @param codeLength 验证码长度
     * @return 验证码
     */
    public static String genLetterStr(int codeLength){
        return genCode(LETTERS_STR, codeLength);
    }

    /**
     * 生成验证码
     * @param codeLength 验证码长度
     * @return 验证码
     */
    public static String genNumberCode( int codeLength){
        return genCode(NUMBER_STR, codeLength);
    }

    /**
     * 生成验证码
     * @param str 验证码字符串
     * @param codeLength 验证码长度
     * @return 验证码
     */
    public static String genCode (String str, int codeLength){
        //将字符串转换为一个新的字符数组。
        char[] verificationCodeArray = str.toCharArray();
        Random random = new Random();
        //计数器
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            //随机生成一个随机数
            int index = random.nextInt(verificationCodeArray.length);
            char c = verificationCodeArray[index];
            //限制四位不重复数字
            if (stringBuilder.indexOf(String.valueOf(c)) == -1) {
                stringBuilder.append(c);
                //计数器加1
                count++;
            }
            //当count等于4时结束，随机生成四位数的验证码
        } while (count != codeLength);
        return stringBuilder.toString();
    }
}
