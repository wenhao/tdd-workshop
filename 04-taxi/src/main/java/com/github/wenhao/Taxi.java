package com.github.wenhao;

import java.math.BigDecimal;

import static com.github.wenhao.TaxiConfig.*;

public class Taxi
{

    public BigDecimal chargeFee(final Ride ride)
    {
        final boolean isDayChargeTime = ride.getHourOfDay() >= 6 && ride.getHourOfDay() < 23;
        final double additionalDistance = ride.getDistance() - BASE_DISTANCE;

        if (ride.getDistance() <= BASE_DISTANCE) {
            if (isDayChargeTime) {
                return DAY_BASE_FEE;
            }
            return NIGHT_BASE_FEE;
        }

        if (isDayChargeTime) {
            return DAY_BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(PRICE_PER_MILE));
        }
        return NIGHT_BASE_FEE.add(BigDecimal.valueOf(additionalDistance).multiply(NIGHT_PRICE_PER_MILE));
    }
}
