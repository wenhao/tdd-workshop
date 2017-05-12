package com.github.wenhao;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class CompositeTaxiCharge
{
    private List<TaxiCharge> taxiCharges = newArrayList();

    public CompositeTaxiCharge withBaseFee(final BigDecimal baseFee)
    {
        return with(new BaseFareTaxiCharge(baseFee));
    }

    public CompositeTaxiCharge withAdditionalFee(final BigDecimal pricePerMile)
    {
        return with(new AdditionalFeeTaxiCharge(pricePerMile));
    }

    private CompositeTaxiCharge with(final TaxiCharge taxiCharge)
    {
        this.taxiCharges.add(taxiCharge);
        return this;
    }

    public BigDecimal chargeFee(final Ride ride)
    {
        BigDecimal total = taxiCharges.stream()
                .map(taxiCharge -> taxiCharge.chargeFee(ride))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total.setScale(2, BigDecimal.ROUND_UP);
    }
}