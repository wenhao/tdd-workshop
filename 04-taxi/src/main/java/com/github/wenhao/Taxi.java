package com.github.wenhao;

import java.math.BigDecimal;

import static com.sun.javafx.font.FontResource.ZERO;

public class Taxi
{
    public BigDecimal chargeFee(final double distance)
    {
        if (distance <= 3) {
            return BigDecimal.valueOf(11);
        }
        return BigDecimal.valueOf(ZERO);
    }
}
