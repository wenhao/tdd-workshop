package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;
import static java.math.BigDecimal.ROUND_UP;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class AdditionalFeeTaxiCharge implements TaxiCharge {
    private double baseMeter;
    private double maxMeter;
    private BigDecimal pricePerMile;

    public AdditionalFeeTaxiCharge(final double baseMeter, final BigDecimal pricePerMile) {
        this(baseMeter, Double.MAX_VALUE, pricePerMile);
    }

    public AdditionalFeeTaxiCharge(final double minMeter, final double maxMeter, final BigDecimal pricePerMile) {
        this.baseMeter = minMeter;
        this.maxMeter = maxMeter;
        this.pricePerMile = pricePerMile;
    }

    @Override
    public BigDecimal chargeFee(final Ride ride) {
        if (ride.getDistance() <= baseMeter) {
            return ZERO.setScale(2, ROUND_UP);
        }
        double additionalDistance = Math.min(ride.getDistance(), maxMeter) - baseMeter;
        return BigDecimal.valueOf(additionalDistance).multiply(pricePerMile);
    }
}
