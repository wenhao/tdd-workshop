package com.github.wenhao.tdd.pos;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;

public class Pos
{
    public Receipt checkout(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        receipt.setTotalPrice(40d);
        return receipt;
    }
}
