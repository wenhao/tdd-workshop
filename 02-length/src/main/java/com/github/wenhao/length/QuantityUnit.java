package com.github.wenhao.length;

public enum QuantityUnit
{
    MILE(1760 * 3),
    YARD(3),
    FEET(1);

    private int value;

    QuantityUnit(final int value)
    {
        this.value = value;
    }


    public int getValue()
    {
        return value;
    }
}
