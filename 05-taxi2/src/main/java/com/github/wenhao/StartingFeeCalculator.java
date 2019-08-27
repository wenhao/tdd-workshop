package com.github.wenhao;

import java.math.BigDecimal;

public class StartingFeeCalculator implements FeeCalculator{
    public StartingFeeCalculator() {
    }

    public BigDecimal charge(Trip trip) {
        if (trip.getDistance() <= 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(6);
    }
}