package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

public class BaseFareTaxiCharge
{
    private BigDecimal baseFee;

    public BaseFareTaxiCharge(final BigDecimal baseFee)
    {
        this.baseFee = baseFee;
    }

    public BigDecimal chargeFee(final Ride ride)
    {
        return Double.compare(ride.getDistance(), 0) == 0 ? ZERO.setScale(2, ROUND_UP) : baseFee;
    }
}