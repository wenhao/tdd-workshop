package com.github.wenhao;

import com.github.wenhao.manager.HotelChainManager;
import com.github.wenhao.provider.ReservationProvider;

public class ApplicationRunner {
    public static void main(String[] args) {
        HotelChainManager hotelChainManager = new HotelChainManager();
        new ReservationProvider().get().stream()
                .map(hotelChainManager::offer)
                .forEach(it -> System.out.println(it.getName()));
    }
}
