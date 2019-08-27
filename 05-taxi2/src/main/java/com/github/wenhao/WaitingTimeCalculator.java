package com.github.wenhao;

import java.math.BigDecimal;

public class WaitingTimeCalculator implements FeeCalculator{

    public static final double PRICE_PER_MIN = 0.25;

    @Override
    public BigDecimal charge(final Trip trip) {
        if(trip.getWaitingMins() <= 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(trip.getWaitingMins() * PRICE_PER_MIN);
    }
}
