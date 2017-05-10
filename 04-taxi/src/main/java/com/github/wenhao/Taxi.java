package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class Taxi
{
    private static final BigDecimal BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final int BASE_DISTANCE = 3;

    public BigDecimal chargeFee(final double distance)
    {
        double adjustDistance = Math.ceil(distance);
        if (adjustDistance <= BASE_DISTANCE) {
            return BASE_FEE;
        }
        final double additionalDistance = adjustDistance - BASE_DISTANCE;
        return BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(PRICE_PER_MILE));
    }
}
