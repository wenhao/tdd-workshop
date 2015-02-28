package com.github.wenhao.tdd.pos.domain;

public class DiscountItem
{

    private String name;
    private Integer rate;

    public DiscountItem(String name, Integer rate)
    {
        this.name = name;
        this.rate = rate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getRate()
    {
        return rate;
    }

    public void setRate(Integer rate)
    {
        this.rate = rate;
    }
}
