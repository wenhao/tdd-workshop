package com.github.wenhao.length;

public enum QuantityUnit {
    MILE(1760 * 3 * 12),
    YARD(3 * 12),
    FEET(12),
    INCH(1);

    private int rate;

    QuantityUnit(final int rate) {
        this.rate = rate;
    }


    public int getRate() {
        return rate;
    }
}
