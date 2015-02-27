package com.github.wenhao.tdd.pos.domain;

public class ShoppingItem
{
    private final Good good;
    private Integer amount;

    public ShoppingItem(Good good, Integer amount)
    {
        this.good = good;
        this.amount = amount;
    }

    public Double getPrice()
    {
        return this.good.getPrice() * amount;
    }

}
