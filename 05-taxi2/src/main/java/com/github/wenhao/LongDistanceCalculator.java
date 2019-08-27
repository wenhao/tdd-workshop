package com.github.wenhao;

import java.math.BigDecimal;

public class LongDistanceCalculator implements FeeCalculator{

    private static final int LONG_DISTANCE = 8;
    private static final double EXTRA_FEE = 0.5;
    private static final double PRICE_PER_MILE = 0.8;

    public LongDistanceCalculator() {
    }

    public BigDecimal charge(final Trip trip) {
        if (trip.getDistance() <= LONG_DISTANCE) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf((trip.getDistance() - LONG_DISTANCE) * PRICE_PER_MILE * EXTRA_FEE);
    }
}