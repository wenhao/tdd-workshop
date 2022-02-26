package com.github.wenhao.manager;

import com.github.wenhao.domain.Reservation;
import com.github.wenhao.domain.Hotel;
import com.github.wenhao.strategy.RegularPriceStrategy;
import com.github.wenhao.strategy.RewardsPriceStrategy;
import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelChainManager {

    private List<Hotel> hotels;

    public HotelChainManager() {
        Hotel lakewood = new Hotel("Lakewood", 3, ImmutableList.of(new RegularPriceStrategy(110, 90), new RewardsPriceStrategy(80, 80)));
        Hotel bridgewood = new Hotel("Bridgewood", 4, ImmutableList.of(new RegularPriceStrategy(160, 60), new RewardsPriceStrategy(110, 50)));
        Hotel ridgewood = new Hotel("Ridgewood", 5, ImmutableList.of(new RegularPriceStrategy(220, 150), new RewardsPriceStrategy(100, 40)));
        hotels = ImmutableList.of(lakewood, bridgewood, ridgewood);
    }

    public Hotel offer(Reservation reservation) {
        List<Hotel> sortedHotels = hotels.stream()
                .sorted(Comparator.comparingInt(o -> o.getFee(reservation)))
                .collect(Collectors.toList());
        Hotel firstHotel = sortedHotels.get(0);
        Hotel secondHotel = sortedHotels.get(1);
        if (firstHotel.getFee(reservation) < secondHotel.getFee(reservation)) {
            return firstHotel;
        }
        return firstHotel.getRating() > secondHotel.getRating() ? firstHotel : secondHotel;
    }
}
