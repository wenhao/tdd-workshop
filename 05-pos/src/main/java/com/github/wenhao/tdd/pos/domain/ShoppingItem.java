package com.github.wenhao.tdd.pos.domain;

import java.util.List;

import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.Promotion;
import com.github.wenhao.tdd.pos.promotion.QuantityPromotion;
import com.google.common.collect.ImmutableList;

public class ShoppingItem
{
    private final Goods goods;
    private Integer amount;
    private List<Promotion> promotions;

    public ShoppingItem(Goods goods, Integer amount)
    {
        this.goods = goods;
        this.amount = amount;
        this.promotions = ImmutableList.of(new DiscountPromotion(), new QuantityPromotion());
    }

    public Double getPrice()
    {
        Double totalPrice = goods.getPrice() * amount;
        return totalPrice - getTotalDiscount();
    }

    private Double getTotalDiscount()
    {
        Double totalDiscount = 0d;
        for (Promotion promotion : promotions) {
            totalDiscount += promotion.getDiscount(this);
        }
        return totalDiscount;
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
