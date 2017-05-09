package com.github.wenhao.tdd.pos.promotion;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public abstract class Promotion extends ShoppingItem
{
    private ShoppingItem shoppingItem;

    protected Promotion(ShoppingItem shoppingItem)
    {
        this.shoppingItem = shoppingItem;
    }

    @Override
    public Double getPrice()
    {
        return shoppingItem.getPrice();
    }

    @Override
    public Double getAmount()
    {
        return shoppingItem.getAmount();
    }

    @Override
    public Double cost()
    {
        return shoppingItem.cost();
    }
}
