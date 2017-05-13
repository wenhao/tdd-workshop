package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;

import java.math.BigDecimal;

public class TimeTaxiCharge implements TaxiCharge
{
    private TaxiCharge dayCharge;
    private TaxiCharge nightCharge;

    public TimeTaxiCharge(final TaxiCharge dayCharge, final TaxiCharge nightCharge)
    {
        this.dayCharge = dayCharge;
        this.nightCharge = nightCharge;
    }

    @Override
    public BigDecimal chargeFee(final Ride ride)
    {
        return isDay(ride) ? dayCharge.chargeFee(ride) : nightCharge.chargeFee(ride);
    }

    public boolean isDay(final Ride ride)
    {
        return ride.getHourOfDay() >= 6 && ride.getHourOfDay() < 23;
    }
}