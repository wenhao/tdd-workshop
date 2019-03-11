package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;

import java.math.BigDecimal;

public interface TaxiCharge {
    BigDecimal chargeFee(Ride ride);
}
