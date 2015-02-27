package com.github.wenhao.tdd.pos.promotion;


import java.util.Map;

import com.github.wenhao.tdd.pos.domain.Goods;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.google.common.collect.ImmutableMap;

public class DiscountPromotion implements Promotion
{
    private static final Map<String, Double> DISCOUNT_PROMOTIONS = ImmutableMap.<String, Double>builder()
            .put("ITEM000001", 0.75)
            .put("ITEM000005", 0.90)
            .build();

    @Override
    public boolean isApplicable(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        return DISCOUNT_PROMOTIONS.containsKey(goods.getName());
    }

    @Override
    public Double getDiscount(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        if (isApplicable(shoppingItem)) {
            return goods.getPrice() * (1 - DISCOUNT_PROMOTIONS.get(goods.getName()));
        }
        return 0d;
    }
}
