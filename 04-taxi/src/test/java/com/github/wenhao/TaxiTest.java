package com.github.wenhao;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TaxiTest
{
    @Test
    public void should_charge_starting_fare_when_travel_distance_less_than_base_distance()
    {
        // given
        Taxi taxi = new Taxi();

        // when
        BigDecimal fee = taxi.chargeFee();

        // then
        assertThat(fee, equalTo(BigDecimal.valueOf(11)));
    }
}
