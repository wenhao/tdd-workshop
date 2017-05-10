package com.github.wenhao;

import java.math.BigDecimal;

public class Taxi
{
    private static final BigDecimal BASE_FEE = BigDecimal.valueOf(11);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final int BASE_DISTANCE = 3;

    public BigDecimal chargeFee(final double distance)
    {
        if (distance <= BASE_DISTANCE) {
            return BASE_FEE;
        }
        final double additionalDistance = distance - BASE_DISTANCE;
        return BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(PRICE_PER_MILE));
    }
}
