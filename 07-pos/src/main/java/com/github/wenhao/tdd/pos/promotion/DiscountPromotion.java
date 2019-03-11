package com.github.wenhao.tdd.pos.promotion;


import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public class DiscountPromotion extends Promotion {
    private final Double discount;

    public DiscountPromotion(ShoppingItem shoppingItem, Double discount) {
        super(shoppingItem);
        this.discount = discount;
    }

    @Override
    public Double cost() {
        return super.cost() * discount / 100;
    }
}
