package com.github.wenhao;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class MultipleTaxiChargeFactory implements TaxiChargeProcess
{
    private TaxiConfig taxiConfig;

    public MultipleTaxiChargeFactory(final TaxiConfig taxiConfig)
    {
        this.taxiConfig = taxiConfig;
    }

    @Override
    public TaxiCharge getDayCharge(final String taxiType)
    {
        return withCharges(taxiType, "day");
    }

    @Override
    public TaxiCharge getNightCharge(final String taxiType)
    {
        return withCharges(taxiType, "night");
    }

    private CompositeTaxiCharge withCharges(final String taxiType, final String time)
    {
        CompositeTaxiCharge taxiCharge = new CompositeTaxiCharge();
        taxiCharge.withBaseFee(new BigDecimal(taxiConfig.get(taxiType, time, "baseFee")));

        List<Integer> ranges = Pattern.compile(",")
                .splitAsStream(taxiConfig.get(taxiType, time, "range"))
                .map(Integer::valueOf)
                .collect(toList());
        for (int i = 0; i < ranges.size(); i++) {
            Integer minMeter = ranges.get(i);
            Integer maxMeter = ranges.size() - 1 == i ? Integer.MAX_VALUE : ranges.get(i + 1);
            String pricePerMile = taxiConfig.get(taxiType, time, String.format("%s.%s", "pricePerMile", minMeter));
            taxiCharge.withAdditionalFee(minMeter, maxMeter, new BigDecimal(pricePerMile));
        }
        return taxiCharge;
    }
}