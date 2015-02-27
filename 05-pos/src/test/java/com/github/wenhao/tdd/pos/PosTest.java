package com.github.wenhao.tdd.pos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.Good;
import com.github.wenhao.tdd.pos.domain.Receipt;
import com.github.wenhao.tdd.pos.domain.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

public class PosTest
{

    private Pos pos;

    @Before
    public void setUp()
    {
        pos = new Pos();
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_one_product()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Good("ITEM000001", 40d), 1);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(40d));
    }

}
