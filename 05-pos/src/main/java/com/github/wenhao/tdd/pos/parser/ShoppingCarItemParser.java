package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.ShoppingCarItem;

public class ShoppingCarItemParser implements Parser<ShoppingCarItem>
{
    public ShoppingCarItem parse(String line)
    {
        String[] split = line.split("-");
        if (split.length > 1) {
            return new ShoppingCarItem(split[0], Integer.valueOf(split[1]));
        }
        return new ShoppingCarItem(line, 1);
    }
}
