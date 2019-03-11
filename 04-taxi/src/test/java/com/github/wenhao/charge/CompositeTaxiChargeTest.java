package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;
import static java.math.BigDecimal.ROUND_UP;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CompositeTaxiChargeTest {

    @Test
    public void should_get_all_taxi_charged_fee() {
        // given
        CompositeTaxiCharge taxiCharge = new CompositeTaxiCharge()
                .withBaseFee(BigDecimal.valueOf(11))
                .withAdditionalFee(3D, BigDecimal.valueOf(1.6));

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(4, 12));

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));
    }
}