package com.github.wenhao;

import java.math.BigDecimal;

public class AdditionalFeeCalculator implements FeeCalculator {

    private static final double PRICE_PER_MILE = 0.8;
    private static final int BASE_MILE = 2;

    public AdditionalFeeCalculator() {
    }

    @Override
    public BigDecimal charge(final Trip trip) {
        if (trip.getDistance() <= 2) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(PRICE_PER_MILE * (trip.getDistance() - BASE_MILE));
    }
}