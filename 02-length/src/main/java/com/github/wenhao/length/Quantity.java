package com.github.wenhao.length;

public class Quantity
{
    private int amount;
    private QuantityUnit unit;

    public Quantity(final int amount, final QuantityUnit unit)
    {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmount()
    {
        return amount;
    }

    private QuantityUnit getUnit()
    {
        return unit;
    }

    @Override
    public boolean equals(final Object obj)
    {
        Quantity quantity = (Quantity) obj;
        int myBasicAmount = amount * unit.getValue();
        int otherBasicAmount = quantity.getAmount() * quantity.getUnit().getValue();
        return myBasicAmount == otherBasicAmount;
    }

    @Override
    public int hashCode()
    {
        int result = amount;
        result = 31 * result + unit.hashCode();
        return result;
    }
}
