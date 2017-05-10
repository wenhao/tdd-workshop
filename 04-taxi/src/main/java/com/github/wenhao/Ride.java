package com.github.wenhao;

import java.time.LocalTime;

public class Ride
{
    private final double distance;
    private final LocalTime time;

    public Ride(final double distance, final LocalTime time)
    {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance()
    {
        return Math.ceil(distance);
    }

    public LocalTime getTime()
    {
        return time;
    }
}
