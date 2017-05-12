package com.github.wenhao;

import java.math.BigDecimal;

import static com.google.common.collect.Lists.newArrayList;
import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

public class Taxi
{
    private static final BigDecimal DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final BigDecimal NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP);
    private static final BigDecimal NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    public BigDecimal chargeFee(final Ride ride)
    {
        final boolean isDayChargeTime = ride.getHourOfDay() >= 6 && ride.getHourOfDay() < 23;

        if (!isDayChargeTime) {
            return getNightCharge(ride);
        }
        return getDayCharge(ride);
    }

    private BigDecimal getDayCharge(final Ride ride)
    {
        BigDecimal total = newArrayList(new BaseFareTaxiCharge(DAY_BASE_FEE), new AdditionalFeeTaxiCharge(PRICE_PER_MILE)).stream()
                .map(taxiCharge -> taxiCharge.chargeFee(ride))
                .reduce(ZERO, BigDecimal::add);
        return total.setScale(2, ROUND_UP);
    }

    private BigDecimal getNightCharge(final Ride ride)
    {
        BigDecimal total = newArrayList(new BaseFareTaxiCharge(NIGHT_BASE_FEE), new AdditionalFeeTaxiCharge(NIGHT_PRICE_PER_MILE)).stream()
                .map(taxiCharge -> taxiCharge.chargeFee(ride))
                .reduce(ZERO, BigDecimal::add);
        return total.setScale(2, ROUND_UP);
    }

}
