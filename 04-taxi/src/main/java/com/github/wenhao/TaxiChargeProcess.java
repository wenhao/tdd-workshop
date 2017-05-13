package com.github.wenhao;

public interface TaxiChargeProcess
{
    boolean isApplicable(String taxiType);

    TaxiCharge getNightCharge();

    TaxiCharge getDayCharge();
}
