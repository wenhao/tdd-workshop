package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class NormalTaxiCharge implements TaxiChargeProcess
{
    private static final BigDecimal NORMAL_DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal NORMAL_DAY_PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final BigDecimal NORMAL_NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP);
    private static final BigDecimal NORMAL_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    @Override
    public boolean isApplicable(final String taxiType)
    {
        return taxiType.equals("normal");
    }

    @Override
    public TaxiCharge getNightCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(NORMAL_NIGHT_BASE_FEE).withAdditionalFee(3D, NORMAL_NIGHT_PRICE_PER_MILE);
    }

    @Override
    public TaxiCharge getDayCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(NORMAL_DAY_BASE_FEE).withAdditionalFee(3D, NORMAL_DAY_PRICE_PER_MILE);
    }
}