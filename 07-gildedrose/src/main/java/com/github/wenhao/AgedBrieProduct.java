package com.github.wenhao;

import com.github.wenhao.domain.Product;

public class AgedBrieProduct extends Product {
    public AgedBrieProduct(final int sellIn, final int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();
    }
}
