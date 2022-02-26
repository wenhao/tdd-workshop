package com.github.wenhao;

import com.github.wenhao.domain.Ride;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static org.assertj.core.api.Assertions.assertThat;

public class TaxiChargeFactoryTest {

    @Test
    public void should_charge_zero_when_travel_distance_is_zero() {
        // given
        final Ride ride = new Ride(0, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(0).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_starting_fare_when_travel_distance_less_than_base_distance() {
        // given
        final Ride ride = new Ride(2D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(11).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_starting_fare_when_travel_distance_equals_to_base_distance() {
        // given
        final Ride ride = new Ride(3D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(11).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_additional_fare_when_travel_distance_more_than_base_distance() {
        // given
        final Ride ride = new Ride(4D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_fare_when_travel_distance_has_decimal_number() {
        // given
        final Ride ride = new Ride(3.1D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_night_starting_fare_when_travel_at_night_and_distance_less_than_base_distance() {
        // given
        final Ride ride = new Ride(3D, 23);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(13).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_night_additional_fee_when_travel_at_night_and_distance_more_than_base_distance() {
        // given
        final Ride ride = new Ride(4D, 23);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("normal").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(15.4).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_starting_fare_for_shanghai_outer_taxi_when_travel_distance_less_than_base_distance() {
        // given
        final Ride ride = new Ride(3D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("shangHaiOuter").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(14).setScale(2, ROUND_UP));

    }

    @Test
    public void should_charge_additional_fare_for_shanghai_outer_taxi_when_travel_distance_more_than_base_distance() {
        // given
        final Ride ride = new Ride(4D, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("shangHaiOuter").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(16.5).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_night_additional_fee_for_shanghai_outer_taxi_when_travel_at_night_and_distance_more_than_base_distance() {
        // given
        final Ride ride = new Ride(4D, 23);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("shangHaiOuter").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(21).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_additional_fare_for_shanghai_inner_taxi_when_travel_distance_more_than_base_distance() {
        // given
        final Ride ride = new Ride(11, 12);

        // when
        final BigDecimal fee = new TaxiChargeFactory().getTaxiCharge("shangHaiInner").chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(35).setScale(2, ROUND_UP));
    }
}
