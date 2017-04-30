package com.github.wenhao.length;

public class Quantity
{
    private int amount;
    private String unit;

    public Quantity(final int amount, final String unit)
    {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmount()
    {
        return amount;
    }

    private String getUnit()
    {
        return unit;
    }

    @Override
    public boolean equals(final Object obj)
    {
        Quantity quantity = (Quantity) obj;
        return amount == quantity.getAmount() && unit.equals(quantity.getUnit());
    }

    @Override
    public int hashCode()
    {
        int result = amount;
        result = 31 * result + unit.hashCode();
        return result;
    }
}
