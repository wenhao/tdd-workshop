package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.SecondHalfItem;

public class SecondHalfPriceParser extends Parser<SecondHalfItem> {
    public SecondHalfItem convert(String line) {
        return new SecondHalfItem(line);
    }
}
