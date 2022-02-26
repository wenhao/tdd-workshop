package com.github.wenhao.strategy;

import com.github.wenhao.domain.Reservation;

public interface PriceStrategy {
    int getFee(Reservation reservation);
}
