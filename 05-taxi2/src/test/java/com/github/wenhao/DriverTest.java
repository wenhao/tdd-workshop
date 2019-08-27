package com.github.wenhao;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    @Test
    public void should_driver_charge_fee_with_round_up() {
        // given


        // when
        final BigDecimal fee = new Driver(new TaxiCalculator()).charge(new Trip(2, 3));


        // then
        assertThat(fee.compareTo(BigDecimal.valueOf(7))).isEqualTo(0);
    }
}
