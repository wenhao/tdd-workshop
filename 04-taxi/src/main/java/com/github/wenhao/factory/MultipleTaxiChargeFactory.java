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
