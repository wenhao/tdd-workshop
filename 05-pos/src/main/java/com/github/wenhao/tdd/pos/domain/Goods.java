package com.github.wenhao.tdd.pos.domain;

public class Goods
{
    private final Double price;
    private final String name;

    public Goods(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }
}
