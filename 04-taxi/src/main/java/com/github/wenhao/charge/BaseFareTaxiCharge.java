package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

public class BaseFareTaxiCharge implements TaxiCharge
{
    private BigDecimal baseFee;

    public BaseFareTaxiCharge(final BigDecimal baseFee)
    {
        this.baseFee = baseFee;
    }

    @Override
    public BigDecimal chargeFee(final Ride ride)
    {
        return Double.compare(ride.getDistance(), 0) == 0 ? ZERO.setScale(2, ROUND_UP) : baseFee.setScale(2, ROUND_UP);
    }
}