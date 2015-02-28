package com.github.wenhao.tdd.pos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.SecondHalfPricePromotion;
import org.junit.Before;
import org.junit.Test;

public class PosTest
{

    private Pos pos;

    @Before
    public void setUp() throws Exception
    {
        pos = new Pos();
    }

    @Test
    public void should_be_able_to_calc_total_price()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new DiscountPromotion(new SecondHalfPricePromotion(new ShoppingItem("ITEM000001", 40d, 2d)), 75d));

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(45d));
    }
}
