package com.github.wenhao;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class TaxiCalculatorTest {

    private final TaxiCalculator taxiCalculator = new TaxiCalculator();

    @Test
    public void should_charge_basic_fee_if_trip_has_one_mile() {
        // given


        // when
        final BigDecimal fee = taxiCalculator.calculate(new Trip(1, 0));


        // then
        assertThat(fee.compareTo(BigDecimal.valueOf(6))).isEqualTo(0);
    }

    @Test
    public void should_charge_fee_if_trip_has_extra_mile() {
        // given


        // when
        final BigDecimal fee = taxiCalculator.calculate(new Trip(3, 0));


        // then
        assertThat(fee.compareTo(BigDecimal.valueOf(6.8))).isEqualTo(0);
    }

    @Test
    public void should_charge_fee_if_trip_has_extra_eight_mile() {
        // given


        // when
        final BigDecimal fee = taxiCalculator.calculate(new Trip(10, 0));


        // then
        assertThat(fee.compareTo(BigDecimal.valueOf(13.2))).isEqualTo(0);
    }

    @Test
    public void should_charge_waiting_fee_if_trip_has_waiting_time() {
        // given


        // when
        final BigDecimal fee = taxiCalculator.calculate(new Trip(2, 4));


        // then
        assertThat(fee.compareTo(BigDecimal.valueOf(7))).isEqualTo(0);
    }
}
