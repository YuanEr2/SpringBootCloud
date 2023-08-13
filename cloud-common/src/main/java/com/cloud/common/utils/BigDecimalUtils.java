package com.cloud.common.utils;

import java.math.BigDecimal;

/**
 * BigDecimal计算工具类
 * @BelongsProject: SpringCloudHomeWork
 * @BelongsPackage: com.cloud.common.utils
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-03  08:07
 * @Description: //TODO BigDecimal计算工具类
 * @Version: 1.0
 */
public class BigDecimalUtils {
    /**
     * bigDecimal1 大于 bigDecimal2
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static  boolean gt(BigDecimal bigDecimal1, BigDecimal bigDecimal2){
        return bigDecimal1.compareTo(bigDecimal2) > 0;
    }

    /**
     * bigDecimal1 大于等于 bigDecimal2
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static  boolean gte(BigDecimal bigDecimal1,BigDecimal bigDecimal2){
        return bigDecimal1.compareTo(bigDecimal2) >= 0;
    }

    /**
     * bigDecimal1 等于 bigDecimal2
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static  boolean eq(BigDecimal bigDecimal1,BigDecimal bigDecimal2){
        return bigDecimal1.compareTo(bigDecimal2) == 0;
    }

    /**
     * bigDecimal1 小于 bigDecimal2
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static  boolean lt(BigDecimal bigDecimal1,BigDecimal bigDecimal2){
        return bigDecimal1.compareTo(bigDecimal2) < 0;
    }

    /**
     * bigDecimal1 小于等于 bigDecimal2
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static  boolean lte(BigDecimal bigDecimal1,BigDecimal bigDecimal2){
        return bigDecimal1.compareTo(bigDecimal2) <= 0;
    }

}
