package com.github.wenhao;

import java.math.BigDecimal;

public class ShangHaiInnerTaxiCharge implements TaxiChargeProcess
{
    private static final BigDecimal SHANGHAI_INNER_DAY_BASE_FEE = BigDecimal.valueOf(14);
    private static final BigDecimal SHANGHAI_INNER_DAY_PRICE_PER_MILE = BigDecimal.valueOf(2.5);
    private static final BigDecimal SHANGHAI_INNER_DAY_SECOND_PRICE_PER_MILE = BigDecimal.valueOf(3.5);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_BASE_FEE = BigDecimal.valueOf(18);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(3);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_SECOND_PRICE_PER_MILE = BigDecimal.valueOf(4.7);


    @Override
    public boolean isApplicable(final String taxiType)
    {
        return taxiType.equals("shangHaiInner");
    }

    @Override
    public TaxiCharge getNightCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(SHANGHAI_INNER_DAY_BASE_FEE)
                .withAdditionalFee(3D, 10D, SHANGHAI_INNER_DAY_PRICE_PER_MILE)
                .withAdditionalFee(10D, SHANGHAI_INNER_DAY_SECOND_PRICE_PER_MILE);
    }

    @Override
    public TaxiCharge getDayCharge()
    {
        return new CompositeTaxiCharge().withBaseFee(SHANGHAI_INNER_NIGHT_BASE_FEE)
                .withAdditionalFee(3D, 10D, SHANGHAI_INNER_NIGHT_PRICE_PER_MILE)
                .withAdditionalFee(10D, SHANGHAI_INNER_NIGHT_SECOND_PRICE_PER_MILE);
    }
}