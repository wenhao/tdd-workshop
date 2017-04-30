package com.github.wenhao.length;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class QuantityTest
{
    @Test
    public void should_equal_when_two_same_quantity_compare()
    {
        // given
        final Quantity threeMileQuantity = new Quantity(3, "Mile");
        final Quantity otherThreeMileQuantity = new Quantity(3, "Mile");

        // when

        // then
        assertThat(threeMileQuantity, equalTo(otherThreeMileQuantity));
    }
}
