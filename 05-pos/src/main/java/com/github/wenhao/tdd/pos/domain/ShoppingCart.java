package com.github.wenhao.tdd.pos.domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ShoppingCart
{
    private List<ShoppingItem> shoppingItems;

    public ShoppingCart()
    {
        shoppingItems = newArrayList();
    }

    public void add(Good good, Integer amount)
    {
        shoppingItems.add(new ShoppingItem(good, amount));
    }

    public List<ShoppingItem> getShoppingItems()
    {
        return shoppingItems;
    }

}
