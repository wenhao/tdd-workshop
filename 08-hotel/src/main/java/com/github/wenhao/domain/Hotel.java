package com.github.wenhao.domain;

import com.github.wenhao.strategy.PriceStrategy;

import java.util.List;

public class Hotel {
    private String name;
    private int rating;
    private List<PriceStrategy> priceStrategies;

    public Hotel(String name, int rating, List<PriceStrategy> priceStrategies) {
        this.name = name;
        this.rating = rating;
        this.priceStrategies = priceStrategies;
    }

    public String getName() {
        return name;
    }

    public int getFee(Reservation reservation) {
        return priceStrategies.stream()
                .mapToInt(it -> it.getFee(reservation))
                .sum();
    }

    public int getRating() {
        return rating;
    }
}
