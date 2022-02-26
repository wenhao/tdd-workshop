package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class AdditionalFeeTaxiChargeTest {

    private AdditionalFeeTaxiCharge taxiCharge;

    @Before
    public void setUp() {
        taxiCharge = new AdditionalFeeTaxiCharge(3D, BigDecimal.valueOf(1.6));
    }

    @Test
    public void should_get_zero_when_distance_less_than_base_distance() {
        // given

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(2, 12));

        // then
        assertThat(fee).isEqualTo(ZERO.setScale(2, ROUND_UP));
    }

    @Test
    public void should_get_additional_fee_when_distance_more_than_base_distance() {
        // given

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(4, 12));

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(1.6).setScale(2, ROUND_UP));
    }
}
