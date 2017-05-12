package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

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
        BigDecimal total = BigDecimal.ZERO;

        BigDecimal baseFare = new BaseFareTaxiCharge(DAY_BASE_FEE).chargeFee(ride);
        total = total.add(baseFare);

        BigDecimal additionalFee = new AdditionalFeeTaxiCharge(PRICE_PER_MILE).chargeFee(ride);
        total = total.add(additionalFee);
        return total;
    }

    private BigDecimal getNightCharge(final Ride ride)
    {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal baseFare = new BaseFareTaxiCharge(NIGHT_BASE_FEE).chargeFee(ride);
        total = total.add(baseFare);

        BigDecimal additionalFee = new AdditionalFeeTaxiCharge(NIGHT_PRICE_PER_MILE).chargeFee(ride);
        total = total.add(additionalFee);
        return total;
    }

}
