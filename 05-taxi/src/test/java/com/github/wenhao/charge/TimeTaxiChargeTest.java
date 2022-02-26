package com.github.wenhao.charge;

import com.github.wenhao.domain.Ride;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeTaxiChargeTest {

    private TimeTaxiCharge taxiCharge;
    @Mock
    private TaxiCharge dayCharge;
    @Mock
    private TaxiCharge nightCharge;

    @Before
    public void setUp() {
        taxiCharge = new TimeTaxiCharge(dayCharge, nightCharge);
    }

    @Test
    public void should_charge_day_fee_when_time_during_day() {
        // given
        Ride ride = new Ride(4D, 12);
        when(dayCharge.chargeFee(ride)).thenReturn(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));

        // when
        BigDecimal fee = taxiCharge.chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));
    }

    @Test
    public void should_charge_night_fee_when_time_during_night() {
        // given
        Ride ride = new Ride(4D, 5);
        when(nightCharge.chargeFee(ride)).thenReturn(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));

        // when
        BigDecimal fee = taxiCharge.chargeFee(ride);

        // then
        assertThat(fee).isEqualTo(BigDecimal.valueOf(12.6).setScale(2, ROUND_UP));
    }
}
