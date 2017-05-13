package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class ShangHaiOuterTaxiCharge implements TaxiChargeProcess
{
    private static final BigDecimal SHANGHAI_OUTER_DAY_BASE_FEE = BigDecimal.valueOf(14);
    private static final BigDecimal SHANGHAI_OUTER_DAY_PRICE_PER_MILE = BigDecimal.valueOf(2.5);
    private static final BigDecimal SHANGHAI_OUTER_NIGHT_BASE_FEE = BigDecimal.valueOf(18);
    private static final BigDecimal SHANGHAI_OUTER_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(3);

    @Override
    public boolean isApplicable(final String taxiType)
    {
        return taxiType.equals("shangHaiOuter");
    }

    @Override
    public TaxiCharge getNightCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(SHANGHAI_OUTER_DAY_BASE_FEE).withAdditionalFee(3D, SHANGHAI_OUTER_DAY_PRICE_PER_MILE);
    }

    @Override
    public TaxiCharge getDayCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(SHANGHAI_OUTER_NIGHT_BASE_FEE).withAdditionalFee(3D, SHANGHAI_OUTER_NIGHT_PRICE_PER_MILE);
    }
}