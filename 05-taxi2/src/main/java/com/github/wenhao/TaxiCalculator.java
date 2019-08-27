package com.github.wenhao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TaxiCalculator {
    private final List<FeeCalculator> calculators = Arrays.asList(new StartingFeeCalculator(),
            new AdditionalFeeCalculator(),
            new LongDistanceCalculator(),
            new WaitingTimeCalculator());

    public BigDecimal calculate(final Trip trip) {
        return calculators.stream()
                .map(calculator -> calculator.charge(trip))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
