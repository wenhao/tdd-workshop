package com.github.wenhao;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class RideTest
{
    @Test
    public void should_get_same_distance_when_given_distance_is_integer()
    {
        // given
        Ride ride = new Ride(2, 12);

        // when
        double distance = ride.getDistance();

        // then
        assertThat(distance, equalTo(2D));
    }

    @Test
    public void should_round_up_when_given_distance_has_decimals()
    {
        // given
        Ride ride = new Ride(2.3, 12);

        // when
        double distance = ride.getDistance();

        // then
        assertThat(distance, equalTo(3D));
    }
}