package com.github.wenhao.tdd.pos;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.SecondHalfPricePromotion;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosTest {

    private Pos pos;

    @BeforeEach
    public void setUp() throws Exception {
        pos = new Pos();
    }

    @Test
    public void should_be_able_to_calc_total_price() {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new DiscountPromotion(new SecondHalfPricePromotion(new ShoppingItem("ITEM000001", 40d, 2d)), 75d));

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice()).isEqualTo(45d);
    }
}
