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
import static com.google.common.collect.Lists.newArrayList;

import java.math.BigDecimal;
import java.util.List;

public class CompositeTaxiCharge implements TaxiCharge {
    private List<TaxiCharge> taxiCharges = newArrayList();

    public CompositeTaxiCharge withBaseFee(final BigDecimal baseFee) {
        return with(new BaseFareTaxiCharge(baseFee));
    }

    public CompositeTaxiCharge withAdditionalFee(final double baseFee, final BigDecimal pricePerMile) {
        return with(new AdditionalFeeTaxiCharge(baseFee, pricePerMile));
    }

    public CompositeTaxiCharge withAdditionalFee(final double min, final double max, final BigDecimal pricePerMile) {
        return with(new AdditionalFeeTaxiCharge(min, max, pricePerMile));
    }

    private CompositeTaxiCharge with(final TaxiCharge taxiCharge) {
        this.taxiCharges.add(taxiCharge);
        return this;
    }

    @Override
    public BigDecimal chargeFee(final Ride ride) {
        BigDecimal total = taxiCharges.stream()
                .map(taxiCharge -> taxiCharge.chargeFee(ride))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total.setScale(2, BigDecimal.ROUND_UP);
    }
}
