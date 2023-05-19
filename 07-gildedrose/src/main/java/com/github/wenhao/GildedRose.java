package com.github.wenhao;

import java.util.List;

import com.github.wenhao.domain.Product;

public class GildedRose {
    private final List<Product> products;

    public GildedRose(final List<Product> products) {
        this.products = products;
    }

    public void passOneDay() {
        this.products.forEach(Product::update);
    }
}
