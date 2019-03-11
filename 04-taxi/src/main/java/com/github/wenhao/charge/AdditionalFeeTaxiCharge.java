/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
