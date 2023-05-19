package com.github.wenhao;

import com.github.wenhao.domain.Product;

public class BackstagePassProduct extends Product {
    public BackstagePassProduct(final int sellIn, final int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();
        if (getSellIn() < 10) {
            increaseQuality();
        }
        if (getSellIn() < 5) {
            increaseQuality();
        }
        if (getSellIn() == 0) {
            setQuality(0);
        }
    }
}
