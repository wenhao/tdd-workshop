package com.github.wenhao;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TaxiChargeFactory
{

    public TaxiCharge getTaxiCharge(final String taxiType)
    {
        List<TaxiChargeProcess> taxiChargeProcesses = newArrayList(new NormalTaxiCharge(), new ShangHaiOuterTaxiCharge(), new ShangHaiInnerTaxiCharge());
        TaxiChargeProcess chargeProcess = taxiChargeProcesses.stream()
                .filter(taxiChargeProcess -> taxiChargeProcess.isApplicable(taxiType))
                .findFirst()
                .get();

        TaxiCharge dayCharge = chargeProcess.getDayCharge();
        TaxiCharge nightCharge = chargeProcess.getNightCharge();
        return new TimeTaxiCharge(dayCharge, nightCharge);
    }

}
