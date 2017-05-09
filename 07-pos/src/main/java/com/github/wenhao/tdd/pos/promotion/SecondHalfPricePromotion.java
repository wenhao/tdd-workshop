package com.github.wenhao.tdd.pos.promotion;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public class SecondHalfPricePromotion extends Promotion
{
    public SecondHalfPricePromotion(ShoppingItem shoppingItem)
    {
        super(shoppingItem);
    }

    @Override
    public Double cost()
    {
        double amount = super.getAmount() - super.getAmount() / 2 * 0.5;
        return super.cost() / super.getAmount() * amount;
    }

}
