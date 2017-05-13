package com.github.wenhao;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

public class TaxiChargeFactory
{
    private static final BigDecimal NORMAL_DAY_BASE_FEE = BigDecimal.valueOf(11).setScale(2, ROUND_UP);
    private static final BigDecimal NORMAL_DAY_PRICE_PER_MILE = BigDecimal.valueOf(1.6D);
    private static final BigDecimal NORMAL_NIGHT_BASE_FEE = BigDecimal.valueOf(13).setScale(2, ROUND_UP);
    private static final BigDecimal NORMAL_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(2.4D);

    private static final BigDecimal SHANGHAI_OUTER_DAY_BASE_FEE = BigDecimal.valueOf(14);
    private static final BigDecimal SHANGHAI_OUTER_DAY_PRICE_PER_MILE = BigDecimal.valueOf(2.5);
    private static final BigDecimal SHANGHAI_OUTER_NIGHT_BASE_FEE = BigDecimal.valueOf(18);
    private static final BigDecimal SHANGHAI_OUTER_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(3);

    private static final BigDecimal SHANGHAI_INNER_DAY_BASE_FEE = BigDecimal.valueOf(14);
    private static final BigDecimal SHANGHAI_INNER_DAY_PRICE_PER_MILE = BigDecimal.valueOf(2.5);
    private static final BigDecimal SHANGHAI_INNER_DAY_SECOND_PRICE_PER_MILE = BigDecimal.valueOf(3.5);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_BASE_FEE = BigDecimal.valueOf(18);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_PRICE_PER_MILE = BigDecimal.valueOf(3);
    private static final BigDecimal SHANGHAI_INNER_NIGHT_SECOND_PRICE_PER_MILE = BigDecimal.valueOf(4.7);

    public TaxiCharge getTaxiCharge(final String taxiType)
    {
        TaxiCharge dayCharge = null;
        TaxiCharge nightCharge = null;
        if (taxiType.equals("normal")) {
            dayCharge = new CompositeTaxiCharge().withBaseFee(NORMAL_DAY_BASE_FEE).withAdditionalFee(3D, NORMAL_DAY_PRICE_PER_MILE);
            nightCharge = new CompositeTaxiCharge().withBaseFee(NORMAL_NIGHT_BASE_FEE).withAdditionalFee(3D, NORMAL_NIGHT_PRICE_PER_MILE);
        }
        if (taxiType.equals("shangHaiOuter")) {
            dayCharge = new CompositeTaxiCharge().withBaseFee(SHANGHAI_OUTER_DAY_BASE_FEE).withAdditionalFee(3D, SHANGHAI_OUTER_DAY_PRICE_PER_MILE);
            nightCharge = new CompositeTaxiCharge().withBaseFee(SHANGHAI_OUTER_NIGHT_BASE_FEE).withAdditionalFee(3D, SHANGHAI_OUTER_NIGHT_PRICE_PER_MILE);
        }
        if (taxiType.equals("shangHaiInner")) {
            dayCharge = new CompositeTaxiCharge().withBaseFee(SHANGHAI_INNER_DAY_BASE_FEE)
                    .withAdditionalFee(3D, 10D, SHANGHAI_INNER_DAY_PRICE_PER_MILE)
                    .withAdditionalFee(10D, SHANGHAI_INNER_DAY_SECOND_PRICE_PER_MILE);
            nightCharge = new CompositeTaxiCharge().withBaseFee(SHANGHAI_INNER_NIGHT_BASE_FEE)
                    .withAdditionalFee(3D, 10D, SHANGHAI_INNER_NIGHT_PRICE_PER_MILE)
                    .withAdditionalFee(10D, SHANGHAI_INNER_NIGHT_SECOND_PRICE_PER_MILE);
        }
        return new TimeTaxiCharge(dayCharge, nightCharge);
    }

}
