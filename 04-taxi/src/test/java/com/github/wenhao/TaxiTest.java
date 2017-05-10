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
        final Taxi taxi = new Taxi();

        // when
        final BigDecimal fee = taxi.chargeFee(2D);

        // then
        assertThat(fee, equalTo(BigDecimal.valueOf(11)));
    }

    @Test
    public void should_charge_starting_fare_when_travel_distance_equals_to_base_distance()
    {
        // given
        final Taxi taxi = new Taxi();

        // when
        final BigDecimal fee = taxi.chargeFee(3D);

        // then
        assertThat(fee, equalTo(BigDecimal.valueOf(11)));
    }

    @Test
    public void should_charge_additional_fare_when_travel_distance_more_than_base_distance()
    {
        // given
        final Taxi taxi = new Taxi();

        // when
        final BigDecimal fee = taxi.chargeFee(4D);

        // then
        assertThat(fee, equalTo(BigDecimal.valueOf(12.6)));
    }
}
