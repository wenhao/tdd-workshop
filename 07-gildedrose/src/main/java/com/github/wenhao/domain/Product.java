package com.github.wenhao.domain;

public abstract class Product {
    protected int sellIn;
    protected int quality;

    public Product(final int sellIn, final int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(final int quality) {
        this.quality = quality;
    }

    public abstract void update();

    protected void decreaseQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }

    protected void decreaseSellIn() {
        if (this.sellIn > 0) {
            this.sellIn--;
        }
    }

    protected void increaseQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
