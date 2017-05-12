package com.github.wenhao;

import java.math.BigDecimal;

public interface TaxiCharge
{
    BigDecimal chargeFee(Ride ride);
}
