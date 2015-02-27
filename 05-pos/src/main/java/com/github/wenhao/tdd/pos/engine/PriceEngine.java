package com.github.wenhao.tdd.pos.engine;

import java.util.List;

import com.github.wenhao.tdd.pos.domain.Goods;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.Promotion;
import com.github.wenhao.tdd.pos.promotion.QuantityPromotion;
import com.google.common.collect.ImmutableList;

public class PriceEngine
{
    private List<Promotion> promotions;

    public PriceEngine()
    {
        this.promotions = ImmutableList.of(new DiscountPromotion(), new QuantityPromotion());
    }

    public double calculate(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        Double totalPrice = goods.getPrice() * shoppingItem.getAmount();
        return totalPrice - getTotalDiscount(shoppingItem);
    }

    private Double getTotalDiscount(ShoppingItem shoppingItem)
    {
        Double totalDiscount = 0d;
        for (Promotion promotion : promotions) {
            totalDiscount += promotion.getDiscount(shoppingItem);
        }
        return totalDiscount;
    }
}
