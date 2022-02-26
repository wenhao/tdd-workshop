package com.github.wenhao.strategy;

import com.github.wenhao.domain.Reservation;
import com.github.wenhao.domain.CustomerType;

public class RewardsPriceStrategy implements PriceStrategy {
    private int weekdaysPrice;
    private int weekendPrice;

    public RewardsPriceStrategy(int weekdaysPrice, int weekendPrice) {
        this.weekdaysPrice = weekdaysPrice;
        this.weekendPrice = weekendPrice;
    }

    @Override
    public int getFee(Reservation reservation) {
        if (reservation.getCustomerType().equals(CustomerType.REWARDS)) {
            return reservation.getDates().stream().mapToInt(it -> it.getDayOfWeek().getValue() < 6 ? weekdaysPrice : weekendPrice).sum();
        }
        return 0;
    }
}
