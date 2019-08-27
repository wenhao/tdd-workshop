package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class Driver {

    private final TaxiCalculator taxiCalculator;

    public Driver(TaxiCalculator taxiCalculator) {
        this.taxiCalculator = taxiCalculator;
    }

    public BigDecimal charge(final Trip trip) {
        BigDecimal totalFee = taxiCalculator.calculate(trip);
        return totalFee.setScale(0, ROUND_UP);
    }
}
