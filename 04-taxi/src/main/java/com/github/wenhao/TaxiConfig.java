package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class TaxiConfig
{
    public static final BigDecimal NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, BigDecimal.ROUND_UP);
    public static final BigDecimal DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    public static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    public static final int BASE_DISTANCE = 3;
    public static final BigDecimal NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    public TaxiConfig()
    {
    }
}