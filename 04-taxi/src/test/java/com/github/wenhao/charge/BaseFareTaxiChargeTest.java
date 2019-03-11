package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;
import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class BaseFareTaxiChargeTest {

    private BaseFareTaxiCharge taxiCharge;

    @BeforeEach
    public void setUp() {
        taxiCharge = new BaseFareTaxiCharge(BigDecimal.valueOf(11));
    }

    @Test
    public void should_get_zero_when_distance_is_zero() {
        // given

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(0, 12));

        // then
        assertThat(fee).isEqualTo(ZERO.setScale(2, ROUND_UP));
    }

    @Test
    public void should_get_base_fee_when_distance_not_zero() {
        // given

        // when
        BigDecimal fee = taxiCharge.chargeFee(new Ride(1, 12));

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(11).setScale(2, ROUND_UP));
    }
}