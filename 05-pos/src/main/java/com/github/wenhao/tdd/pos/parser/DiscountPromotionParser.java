package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.DiscountItem;

public class DiscountPromotionParser implements Parser<DiscountItem>
{
    public DiscountItem parse(String line)
    {
        String[] split = line.split(":");
        return new DiscountItem(split[0], Integer.valueOf(split[1]));
    }
}
