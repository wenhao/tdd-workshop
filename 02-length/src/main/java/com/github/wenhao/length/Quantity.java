package com.github.wenhao.length;

import static com.github.wenhao.length.QuantityUnit.INCH;

public class Quantity {
    private int amount;
    private QuantityUnit unit;

    public Quantity(final int amount, final QuantityUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmount() {
        return amount;
    }

    private QuantityUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(final Object obj) {
        Quantity quantity = (Quantity) obj;
        int myBasicAmount = amount * unit.getRate();
        int otherBasicAmount = quantity.getAmount() * quantity.getUnit().getRate();
        return myBasicAmount == otherBasicAmount;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + unit.hashCode();
        return result;
    }

    public Quantity plus(final Quantity quantity) {
        int plusAmount = amount * unit.getRate() + quantity.getAmount() * quantity.getUnit().getRate();
        return new Quantity(plusAmount, INCH);
    }
}
