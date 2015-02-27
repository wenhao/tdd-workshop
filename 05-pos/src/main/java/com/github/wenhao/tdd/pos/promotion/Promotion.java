package com.github.wenhao.tdd.pos.promotion;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public interface Promotion
{
    boolean isApplicable(ShoppingItem shoppingItem);

    Double getDiscount(ShoppingItem shoppingItem);
}
