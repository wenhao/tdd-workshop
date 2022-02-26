package com.github.wenhao.domain;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    private final CustomerType customerType;
    private final List<LocalDate> dates;

    public Reservation(CustomerType customerType, List<LocalDate> dates) {
        this.customerType = customerType;
        this.dates = dates;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public List<LocalDate> getDates() {
        return dates;
    }
}
