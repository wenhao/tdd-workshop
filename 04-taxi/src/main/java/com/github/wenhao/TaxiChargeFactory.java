package com.github.wenhao;

import com.github.wenhao.charge.TaxiCharge;
import com.github.wenhao.charge.TimeTaxiCharge;
import com.github.wenhao.config.TaxiConfig;
import com.github.wenhao.factory.MultipleTaxiChargeFactory;

public class TaxiChargeFactory {

    public TaxiCharge getTaxiCharge(final String taxiType) {
        TaxiConfig taxiConfig = new TaxiConfig();
        MultipleTaxiChargeFactory taxiCharge = new MultipleTaxiChargeFactory(taxiConfig);

        TaxiCharge dayCharge = taxiCharge.getDayCharge(taxiType);
        TaxiCharge nightCharge = taxiCharge.getNightCharge(taxiType);
        return new TimeTaxiCharge(dayCharge, nightCharge);
    }

}
