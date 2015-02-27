package com.github.wenhao.tdd.pos.domain;

import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.Promotion;

public class ShoppingItem
{
    private final Goods goods;
    private Integer amount;
    private Promotion promotion;

    public ShoppingItem(Goods goods, Integer amount)
    {
        this.goods = goods;
        this.amount = amount;
        this.promotion = new DiscountPromotion();
    }

    public Double getPrice()
    {
        return promotion.getPrice(this);
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
