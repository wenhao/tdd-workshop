package com.github.wenhao.tdd.pos;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public class Pos
{
    public Receipt checkout(ShoppingCart shoppingCart)
    {
        Double totalPrice = 0d;
        for (ShoppingItem shoppingItem : shoppingCart.getShoppingItems()) {
            totalPrice += shoppingItem.cost();
        }
        Receipt receipt = new Receipt();
        receipt.setTotalPrice(totalPrice);
        return receipt;
    }
}
