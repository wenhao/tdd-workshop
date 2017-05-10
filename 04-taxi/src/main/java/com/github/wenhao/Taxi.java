package com.github.wenhao;

import java.math.BigDecimal;

public class Taxi
{
    public BigDecimal chargeFee(final double distance)
    {
        if (distance <= 3) {
            return BigDecimal.valueOf(11);
        }
        return BigDecimal.valueOf(11).add(BigDecimal.valueOf((distance - 3) * 1.6));
    }
}
