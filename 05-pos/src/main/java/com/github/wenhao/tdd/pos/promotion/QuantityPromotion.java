package com.github.wenhao.tdd.pos.promotion;

import java.util.List;

import com.github.wenhao.tdd.pos.domain.Goods;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.google.common.collect.ImmutableList;

public class QuantityPromotion implements Promotion
{
    private static final List<String> QUANTITY_PROMOTIONS = ImmutableList.of("ITEM000001", "ITEM000003");
    private int quantity;
    private Double rate;

    public QuantityPromotion()
    {
        this.quantity = 2;
        this.rate = 0.5;
    }

    @Override
    public boolean isApplicable(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        return QUANTITY_PROMOTIONS.contains(goods.getName()) && shoppingItem.getAmount() >= quantity;
    }

    @Override
    public Double getDiscount(ShoppingItem shoppingItem)
    {
        Goods goods = shoppingItem.getGoods();
        if (isApplicable(shoppingItem)) {
            return goods.getPrice() * (1 - rate);
        }
        return 0d;
    }
}
