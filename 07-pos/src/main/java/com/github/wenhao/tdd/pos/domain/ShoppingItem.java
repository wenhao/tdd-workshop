package com.github.wenhao.tdd.pos.domain;

public class ShoppingItem {
    private String name;
    private Double price;
    private Double amount;

    public ShoppingItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public ShoppingItem(String name, double price, Double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public ShoppingItem() {
    }

    public Double getPrice() {
        return price;
    }

    public Double getAmount() {
        return amount;
    }

    public Double cost() {
        return price * amount;
    }

    public String getName() {
        return name;
    }
}
