package com.github.wenhao.tdd.pos.promotion;


import java.util.Map;

import com.github.wenhao.tdd.pos.domain.Goods;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.google.common.collect.ImmutableMap;

public class DiscountPromotion implements Promotion
{
    private static final Map<String, Double> discountPromotions = ImmutableMap.<String, Double>builder()
            .put("ITEM000001", 0.75)
            .put("ITEM000005", 0.90)
            .build();

    @Override
    public boolean isApplicable(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        return discountPromotions.containsKey(goods.getName());
    }

    @Override
    public Double getPrice(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        if (isApplicable(shoppingItem)) {
            return discountPromotions.get(goods.getName()) * goods.getPrice();
        }
        return goods.getPrice() * shoppingItem.getAmount();
    }
}
