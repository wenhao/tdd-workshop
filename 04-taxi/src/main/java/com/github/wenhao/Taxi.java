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

    public BigDecimal chargeFee(final Ride ride)
    {
        if (ride.getDistance() <= BASE_DISTANCE) {
            boolean isNightChargeTime = !((ride.getTime().isAfter(LocalTime.of(6, 0)) || ride.getTime().equals(LocalTime.of(6, 0))) && ride.getTime().isBefore(LocalTime.of(23, 0)));
            if (isNightChargeTime) {
                return NIGHT_BASE_FEE;
            }
            return DAY_BASE_FEE;
        }
        final double additionalDistance = ride.getDistance() - BASE_DISTANCE;
        return DAY_BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(PRICE_PER_MILE));
    }
}
