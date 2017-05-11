package com.github.wenhao;

public class Ride
{
    private final double distance;
    private final int hourOfDay;

    public Ride(final double distance, final int hourOfDay)
    {
        this.distance = distance;
        this.hourOfDay = hourOfDay;
    }

    public double getDistance()
    {
        return Math.ceil(distance);
    }

    public int getHourOfDay()
    {
        return hourOfDay;
    }
}
