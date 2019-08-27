package com.github.wenhao;

public class Trip {
    private double mile;
    private int minute;

    public Trip(final int mile, final int minute) {
        this.mile = mile;
        this.minute = minute;
    }

    public double getDistance() {
        return mile;
    }

    public double getWaitingMins() {
        return minute;
    }
}
