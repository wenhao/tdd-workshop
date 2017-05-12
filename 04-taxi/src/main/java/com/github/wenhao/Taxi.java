package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

public class Taxi
{
    private static final BigDecimal DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final int BASE_DISTANCE = 3;
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

        BigDecimal baseFare = getBaseFare(ride, DAY_BASE_FEE);
        total = total.add(baseFare);

        BigDecimal additionalFee = getAdditionalFee(ride, PRICE_PER_MILE);
        total = total.add(additionalFee);
        return total;
    }

    private BigDecimal getNightCharge(final Ride ride)
    {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal baseFare = getBaseFare(ride, NIGHT_BASE_FEE);
        total = total.add(baseFare);

        BigDecimal additionalFee = getAdditionalFee(ride, NIGHT_PRICE_PER_MILE);
        total = total.add(additionalFee);
        return total;
    }

    private BigDecimal getAdditionalFee(final Ride ride, final BigDecimal pricePerMile)
    {
        if (ride.getDistance() <= BASE_DISTANCE) {
            return ZERO.setScale(2, ROUND_UP);
        }
        return BigDecimal.valueOf(ride.getDistance() - BASE_DISTANCE).multiply(pricePerMile);
    }

    private BigDecimal getBaseFare(final Ride ride, final BigDecimal baseFare)
    {
        return Double.compare(ride.getDistance(), 0) == 0 ? ZERO.setScale(2, ROUND_UP) : baseFare;
    }
}
