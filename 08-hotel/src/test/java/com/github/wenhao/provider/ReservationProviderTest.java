package com.github.wenhao.provider;

import com.github.wenhao.domain.CustomerType;
import com.github.wenhao.domain.Reservation;
import com.github.wenhao.provider.ReservationProvider;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReservationProviderTest {
    @Test
    public void should_provider_reservation_from_file() {
        // given

        // when
        List<Reservation> reservations = new ReservationProvider().get();

        // then
        assertThat(reservations.get(0).getCustomerType()).isEqualTo(CustomerType.REGULAR);
    }
}
