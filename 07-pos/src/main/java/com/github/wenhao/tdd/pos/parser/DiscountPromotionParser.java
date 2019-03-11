package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.DiscountItem;

public class DiscountPromotionParser extends Parser<DiscountItem> {
    public DiscountItem convert(String line) {
        String[] split = line.split(":");
        return new DiscountItem(split[0], Integer.valueOf(split[1]));
    }
}
