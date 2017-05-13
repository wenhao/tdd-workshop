package com.github.wenhao.charge;

import com.github.wenhao.charge.CompositeTaxiCharge;
import com.github.wenhao.domain.Ride;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CompositeTaxiChargeTest
{

    @Test
    public void should_get_all_taxi_charged_fee()
    {
        // given
        CompositeTaxiCharge taxiCharge = new CompositeTaxiCharge()
                .withBaseFee(BigDecimal.valueOf(11))
                .withAdditionalFee(3D, BigDecimal.valueOf(1.6));

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(4, 12));

        // then
        assertThat(fee, equalTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP)));
    }
}