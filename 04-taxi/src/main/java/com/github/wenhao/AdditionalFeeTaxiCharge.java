package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

public class AdditionalFeeTaxiCharge
{
    private static final int BASE_DISTANCE = 3;
    private BigDecimal pricePerMile;

    public AdditionalFeeTaxiCharge(final BigDecimal pricePerMile)
    {
        this.pricePerMile = pricePerMile;
    }

    public BigDecimal chargeFee(final Ride ride)
    {
        if (ride.getDistance() <= BASE_DISTANCE) {
            return ZERO.setScale(2, ROUND_UP);
        }
        return BigDecimal.valueOf(ride.getDistance() - BASE_DISTANCE).multiply(pricePerMile);
    }
}