package com.github.wenhao.tdd.pos.domain;

public class ShoppingCarItem
{
    private String name;
    private Integer amount;

    public ShoppingCarItem(String name, Integer amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}
