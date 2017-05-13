package com.github.wenhao;

public interface TaxiChargeProcess
{
    TaxiCharge getNightCharge(final String taxiType);

    TaxiCharge getDayCharge(final String taxiType);
}
