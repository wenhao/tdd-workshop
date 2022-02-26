package com.github.wenhao.factory;

import com.github.wenhao.charge.TaxiCharge;
import com.github.wenhao.config.TaxiConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MultipleTaxiChargeFactoryTest {

    private MultipleTaxiChargeFactory taxiChargeFactory;
    @Mock
    private TaxiConfig taxiConfig;

    @Before
    public void setUp() {
        taxiChargeFactory = new MultipleTaxiChargeFactory(taxiConfig);
    }

    @Test
    public void should_get_day_charge() {
        // given
        when(taxiConfig.get("normal", "day", "baseFee")).thenReturn("11");
        when(taxiConfig.get("normal", "day", "range")).thenReturn("3");
        when(taxiConfig.get("normal", "day", "pricePerMile.3")).thenReturn("1.6");

        // when
        TaxiCharge dayCharge = taxiChargeFactory.getDayCharge("normal");

        // then
        assertThat(dayCharge).isNotNull();
    }

    @Test
    public void should_get_night_charge() {
        // given
        when(taxiConfig.get("normal", "night", "baseFee")).thenReturn("11");
        when(taxiConfig.get("normal", "night", "range")).thenReturn("3");
        when(taxiConfig.get("normal", "night", "pricePerMile.3")).thenReturn("1.6");

        // when
        TaxiCharge nightCharge = taxiChargeFactory.getNightCharge("normal");

        // then
        assertThat(nightCharge).isNotNull();

    }
}
