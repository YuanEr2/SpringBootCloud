package com.cloud.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算工具类
 * @BelongsProject: MonthTest
 * @BelongsPackage: com.cloud.common.utils
 * @Author: RuanChaoChao
 * @CreateTime: 2023-07-11  09:14
 * @Description: //TODO 计算工具类
 * @Version: 1.0
 */
public class MathUtils {

    /**
     * 生成向上取值的方法
     * @param amount
     * @return
     */
    public static BigDecimal findFull (BigDecimal amount) {
        BigDecimal ten = new BigDecimal("10");
        BigDecimal roundedAmount = amount.setScale(0, RoundingMode.CEILING)
                .divideToIntegralValue(ten)
                .multiply(ten);
        return roundedAmount;
    }
}
