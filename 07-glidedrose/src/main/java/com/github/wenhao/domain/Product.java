package com.github.wenhao.domain;

public class Product {
    private final String name;
    private int sellIn;
    private int quality;

    public Product(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    public void update() {
        this.sellIn--;
        this.quality--;
    }
}
