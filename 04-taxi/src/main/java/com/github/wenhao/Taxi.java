package com.github.wenhao;

import java.math.BigDecimal;
import java.time.LocalTime;

import static java.math.BigDecimal.ROUND_UP;

public class Taxi
{
    private static final BigDecimal DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final int BASE_DISTANCE = 3;
    private static final BigDecimal NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP);
    private static final BigDecimal NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    public BigDecimal chargeFee(final Ride ride)
    {
        boolean isNightChargeTime = !((ride.getTime().isAfter(LocalTime.of(6, 0)) || ride.getTime().equals(LocalTime.of(6, 0))) && ride.getTime().isBefore(LocalTime.of(23, 0)));
        if (ride.getDistance() <= BASE_DISTANCE) {
            if (isNightChargeTime) {
                return NIGHT_BASE_FEE;
            }
            return DAY_BASE_FEE;
        }
        final double additionalDistance = ride.getDistance() - BASE_DISTANCE;
        if (isNightChargeTime) {
            return NIGHT_BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(NIGHT_PRICE_PER_MILE));
        }
        return DAY_BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(PRICE_PER_MILE));
    }
}
