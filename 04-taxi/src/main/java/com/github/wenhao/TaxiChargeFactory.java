package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class TaxiChargeFactory
{
    private static final BigDecimal DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final BigDecimal NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP);
    private static final BigDecimal NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    public TaxiCharge getTaxiCharge()
    {
        final TaxiCharge dayCharge = new CompositeTaxiCharge().withBaseFee(DAY_BASE_FEE).withAdditionalFee(PRICE_PER_MILE);
        final TaxiCharge nightCharge = new CompositeTaxiCharge().withBaseFee(NIGHT_BASE_FEE).withAdditionalFee(NIGHT_PRICE_PER_MILE);
        return new TimeTaxiCharge(dayCharge, nightCharge);
    }

}
