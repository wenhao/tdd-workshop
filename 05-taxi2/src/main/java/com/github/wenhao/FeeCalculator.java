package com.github.wenhao;

import java.math.BigDecimal;

public interface FeeCalculator {
    BigDecimal charge(Trip trip);
}
