package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.SecondHalfItem;

public class SecondHalfPriceParser implements Parser<SecondHalfItem>
{
    public SecondHalfItem parse(String line)
    {
        return new SecondHalfItem(line);
    }
}
