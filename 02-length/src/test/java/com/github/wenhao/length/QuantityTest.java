package com.github.wenhao.length;

import org.junit.Test;

import static com.github.wenhao.length.QuantityUnit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class QuantityTest
{
    @Test
    public void should_equal_when_two_same_quantity_compare()
    {
        // given
        final Quantity threeMileQuantity = new Quantity(3, MILE);
        final Quantity otherThreeMileQuantity = new Quantity(3, MILE);

        // when

        // then
        assertThat(threeMileQuantity, equalTo(otherThreeMileQuantity));
    }

    @Test
    public void should_not_equal_when_two_quantity_has_different_length()
    {
        // given
        final Quantity threeMileQuantity = new Quantity(3, MILE);
        final Quantity fiveMileQuantity = new Quantity(5, MILE);

        // when

        // then
        assertThat(threeMileQuantity, not(equalTo(fiveMileQuantity)));

    }

    @Test
    public void should_equal_when_two_quantity_has_different_unit()
    {
        // given
        Quantity oneMileQuantity = new Quantity(1, MILE);
        Quantity yard1760 = new Quantity(1760, YARD);

        // when

        // then
        assertThat(oneMileQuantity, equalTo(yard1760));
    }

    @Test
    public void should_not_equal_when_two_quantity_has_different_length_and_unit()
    {
        // given
        Quantity oneMileQuantity = new Quantity(1, MILE);
        Quantity yard1761 = new Quantity(1761, YARD);

        // when

        // then
        assertThat(oneMileQuantity, not(equalTo(yard1761)));
    }

    @Test
    public void should_one_yard_equal_three_feet()
    {
        // given
        Quantity oneYard = new Quantity(1, YARD);
        Quantity threeFeet = new Quantity(3, FEET);

        // when

        // then
        assertThat(oneYard, equalTo(threeFeet));
    }

    @Test
    public void should_one_feet_equal_twelve_feet()
    {
        // given
        Quantity oneFeet = new Quantity(1, FEET);
        Quantity twelveInch = new Quantity(12, INCH);

        // when

        // then
        assertThat(oneFeet, equalTo(twelveInch));
    }

    @Test
    public void should_one_quantity_plus_another()
    {
        // given
        Quantity oneFeet = new Quantity(1, FEET);
        Quantity twelveInch = new Quantity(12, INCH);

        // when
        Quantity quantity = oneFeet.plus(twelveInch);

        // then
        assertThat(quantity, equalTo(new Quantity(24, INCH)));

    }
}
