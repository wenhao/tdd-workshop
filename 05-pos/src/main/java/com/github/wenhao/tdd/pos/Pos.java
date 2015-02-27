package com.github.wenhao.tdd.pos;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;

public class Pos
{

    public Receipt checkout(ShoppingCart shoppingCart)
    {
        double totalPrice = 0;

        for (ShoppingItem shoppingItem : shoppingCart.getShoppingItems()) {
            if (shoppingItem.getName().equals("ITEM000001")) {
                totalPrice += shoppingItem.getPrice() * 75 / 100;
            } else {
                totalPrice += shoppingItem.getPrice();
            }
        }

        return newReceipt(totalPrice);
    }

    private Receipt newReceipt(double totalPrice)
    {
        Receipt receipt = new Receipt();
        receipt.setTotalPrice(totalPrice);
        return receipt;
    }
}
