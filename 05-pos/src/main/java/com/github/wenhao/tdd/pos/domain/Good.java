package com.github.wenhao.tdd.pos.domain;

public class Good
{
    private final Double price;
    private final String name;

    public Good(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
}
