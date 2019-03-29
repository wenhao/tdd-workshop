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

package com.github.wenhao.factory;

import com.github.wenhao.charge.CompositeTaxiCharge;
import com.github.wenhao.charge.TaxiCharge;
import com.github.wenhao.config.TaxiConfig;
import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

public class MultipleTaxiChargeFactory {
    private static final String DAY = "day";
    private static final String NIGHT = "night";
    private static final String BASE_FEE = "baseFee";
    private static final String RANGE = "range";
    private static final String PRICE_PER_MILE = "pricePerMile";
    private TaxiConfig taxiConfig;

    public MultipleTaxiChargeFactory(final TaxiConfig taxiConfig) {
        this.taxiConfig = taxiConfig;
    }

    public TaxiCharge getDayCharge(final String taxiType) {
        return withCharges(taxiType, DAY);
    }

    public TaxiCharge getNightCharge(final String taxiType) {
        return withCharges(taxiType, NIGHT);
    }

    private CompositeTaxiCharge withCharges(final String taxiType, final String time) {
        CompositeTaxiCharge taxiCharge = new CompositeTaxiCharge();
        taxiCharge.withBaseFee(new BigDecimal(taxiConfig.get(taxiType, time, BASE_FEE)));

        List<Integer> ranges = Pattern.compile(",")
                .splitAsStream(taxiConfig.get(taxiType, time, RANGE))
                .map(Integer::valueOf)
                .collect(toList());
        for (int i = 0; i < ranges.size(); i++) {
            Integer minMeter = ranges.get(i);
            Integer maxMeter = ranges.size() - 1 == i ? Integer.MAX_VALUE : ranges.get(i + 1);
            String pricePerMile = taxiConfig.get(taxiType, time, String.format("%s.%s", PRICE_PER_MILE, minMeter));
            taxiCharge.withAdditionalFee(minMeter, maxMeter, new BigDecimal(pricePerMile));
        }
        return taxiCharge;
    }
}
