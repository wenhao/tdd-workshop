package com.github.wenhao.tdd.pos;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.engine.PriceEngine;

public class Pos
{

    private PriceEngine priceEngine;

    public Pos()
    {
        this.priceEngine = new PriceEngine();
    }

    public Receipt checkout(ShoppingCart shoppingCart)
    {
        double totalPrice = 0;

        for (ShoppingItem shoppingItem : shoppingCart.getShoppingItems()) {
            totalPrice += priceEngine.calculate(shoppingItem);
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
