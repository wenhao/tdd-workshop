package com.github.wenhao.provider;

import com.github.wenhao.domain.Reservation;
import com.github.wenhao.domain.CustomerType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReservationProvider {

    public List<Reservation> get() {
        return getContents().stream()
                .map(this::createReservation)
                .collect(Collectors.toList());
    }

    private Reservation createReservation(String it) {
        String[] strings = it.split(":");
        CustomerType customerType = CustomerType.valueOf(strings[0].toUpperCase());
        List<LocalDate> dates = Pattern.compile(",").splitAsStream(strings[1])
                .map(dateString -> {
                    String date = dateString.split("\\(")[0].trim();
                    return LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH));
                }).collect(Collectors.toList());
        return new Reservation(customerType, dates);
    }

    private List<String> getContents() {
        try {
            return Resources.asCharSource(Resources.getResource("reservation.txt"), Charsets.UTF_8).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
