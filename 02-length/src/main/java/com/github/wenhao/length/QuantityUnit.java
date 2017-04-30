package com.github.wenhao.length;

public enum QuantityUnit
{
    BASE(1),
    MILE(1760),
    YARD(1);

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
