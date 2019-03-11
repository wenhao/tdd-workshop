package com.github.wenhao.length;

import static com.github.wenhao.length.QuantityUnit.FEET;
import static com.github.wenhao.length.QuantityUnit.INCH;
import static com.github.wenhao.length.QuantityUnit.MILE;
import static com.github.wenhao.length.QuantityUnit.YARD;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class QuantityTest {
    @Test
    public void should_equal_when_two_same_quantity_compare() {
        // given
        final Quantity threeMileQuantity = new Quantity(3, MILE);
        final Quantity otherThreeMileQuantity = new Quantity(3, MILE);

        // when

        // then
        assertThat(threeMileQuantity).isEqualTo(otherThreeMileQuantity);
    }

    @Test
    public void should_not_equal_when_two_quantity_has_different_length() {
        // given
        final Quantity threeMileQuantity = new Quantity(3, MILE);
        final Quantity fiveMileQuantity = new Quantity(5, MILE);

        // when

        // then
        assertThat(threeMileQuantity).isNotEqualTo(fiveMileQuantity);

    }

    @Test
    public void should_equal_when_two_quantity_has_different_unit() {
        // given
        Quantity oneMileQuantity = new Quantity(1, MILE);
        Quantity yard1760 = new Quantity(1760, YARD);

        // when

        // then
        assertThat(oneMileQuantity).isEqualTo(yard1760);
    }

    @Test
    public void should_not_equal_when_two_quantity_has_different_length_and_unit() {
        // given
        Quantity oneMileQuantity = new Quantity(1, MILE);
        Quantity yard1761 = new Quantity(1761, YARD);

        // when

        // then
        assertThat(oneMileQuantity).isNotEqualTo(yard1761);
    }

    @Test
    public void should_one_yard_equal_three_feet() {
        // given
        Quantity oneYard = new Quantity(1, YARD);
        Quantity threeFeet = new Quantity(3, FEET);

        // when

        // then
        assertThat(oneYard).isEqualTo(threeFeet);
    }

    @Test
    public void should_one_feet_equal_twelve_feet() {
        // given
        Quantity oneFeet = new Quantity(1, FEET);
        Quantity twelveInch = new Quantity(12, INCH);

        // when

        // then
        assertThat(oneFeet).isEqualTo(twelveInch);
    }

    @Test
    public void should_one_quantity_plus_another() {
        // given
        Quantity oneFeet = new Quantity(1, FEET);
        Quantity twelveInch = new Quantity(12, INCH);

        // when
        Quantity quantity = oneFeet.plus(twelveInch);

        // then
        assertThat(quantity).isEqualTo(new Quantity(24, INCH));
    }
}
