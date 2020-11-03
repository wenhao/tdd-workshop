package com.github.wenhao;

import com.github.wenhao.domain.Product;

import java.util.List;

public class GlidedRose {
    private final List<Product> products;

    public GlidedRose(final List<Product> products) {
        this.products = products;
    }

    public void passOneDay() {
        this.products.stream().forEach(Product::update);
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
