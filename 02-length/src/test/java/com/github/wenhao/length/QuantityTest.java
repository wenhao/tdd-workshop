package com.github.wenhao.length;

import org.junit.Test;

import static com.github.wenhao.length.QuantityUnit.MILE;
import static com.github.wenhao.length.QuantityUnit.YARD;
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
}
