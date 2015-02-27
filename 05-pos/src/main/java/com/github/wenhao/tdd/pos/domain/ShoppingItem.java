package com.github.wenhao.tdd.pos.domain;

public class ShoppingItem
{
    private final Goods goods;
    private Integer amount;

    public ShoppingItem(Goods goods, Integer amount)
    {
        this.goods = goods;
        this.amount = amount;
    }

    public Goods getGoods()
    {
        return goods;
    }

    public Integer getAmount()
    {
        return amount;
    }
}
