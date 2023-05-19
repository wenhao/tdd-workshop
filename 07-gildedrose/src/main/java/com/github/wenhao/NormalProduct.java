package com.github.wenhao;

import com.github.wenhao.domain.Product;

public class NormalProduct extends Product {
    public NormalProduct(final int sellIn, final int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        if (getSellIn() == 0) {
            decreaseQuality();
        }
    }
}
