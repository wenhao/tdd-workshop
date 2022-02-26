package com.github.wenhao.manager;

import com.github.wenhao.domain.CustomerType;
import com.github.wenhao.domain.Hotel;
import com.github.wenhao.domain.Reservation;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelChainManagerTest {

    @Test
    public void should_offer_hotel_when_regular_reserve_weekdays() {
        // given
        List<LocalDate> dates = ImmutableList.of(
                LocalDate.of(2009, Month.MARCH, 16),
                LocalDate.of(2009, Month.MARCH, 17),
                LocalDate.of(2009, Month.MARCH, 18));
        Reservation reservation = new Reservation(CustomerType.REGULAR, dates);

        // when
        Hotel hotel = new HotelChainManager().offer(reservation);

        // then
        assertThat(hotel.getName()).isEqualTo("Lakewood");
    }

    @Test
    public void should_offer_hotel_when_regular_customer_reserve_weekend_days() {
        // given
        List<LocalDate> dates = ImmutableList.of(
                LocalDate.of(2009, Month.MARCH, 20),
                LocalDate.of(2009, Month.MARCH, 21),
                LocalDate.of(2009, Month.MARCH, 22));
        Reservation reservation = new Reservation(CustomerType.REGULAR, dates);

        // when
        Hotel hotel = new HotelChainManager().offer(reservation);

        // then
        assertThat(hotel.getName()).isEqualTo("Bridgewood");
    }

    @Test
    public void should_offer_hotel_when_rewards_customer_reserve_weekdays_and_weekend() {
        // given
        List<LocalDate> dates = ImmutableList.of(
                LocalDate.of(2009, Month.MARCH, 26),
                LocalDate.of(2009, Month.MARCH, 27),
                LocalDate.of(2009, Month.MARCH, 28));
        Reservation reservation = new Reservation(CustomerType.REWARDS, dates);

        // when
        Hotel hotel = new HotelChainManager().offer(reservation);

        // then
        assertThat(hotel.getName()).isEqualTo("Ridgewood");
    }
}
