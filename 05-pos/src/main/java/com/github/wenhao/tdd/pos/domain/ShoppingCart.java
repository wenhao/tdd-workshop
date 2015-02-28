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

    public List<ShoppingItem> getShoppingItems()
    {
        return shoppingItems;
    }

    public void add(String name, double price, Double amount)
    {
        shoppingItems.add(new ShoppingItem(name, price, amount));
    }
}
