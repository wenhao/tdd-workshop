package com.github.wenhao.tdd.pos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.Goods;
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
    public void should_be_able_to_calc_total_price_if_buy_one_product_without_promotion()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000006", 40d), 1);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(40d));
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_one_product_with_multiple_amount_without_promotion()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000006", 40d), 2);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(80d));
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_multiple_products_with_multiple_amount_without_promotion()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000006", 40d), 1);
        shoppingCart.add(new Goods("ITEM000007", 50d), 2);
        shoppingCart.add(new Goods("ITEM000006", 40d), 1);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(180d));
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_discount_promotion_product()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000001", 40d), 1);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(30d));
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_multiple_discount_promotion_product()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000001", 40d), 1);
        shoppingCart.add(new Goods("ITEM000005", 60d), 1);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(84d));
    }

    @Test
    public void should_be_able_to_calc_total_price_if_buy_second_half_promotion_product()
    {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Goods("ITEM000003", 50d), 2);

        // when
        Receipt receipt = pos.checkout(shoppingCart);

        // then
        assertThat(receipt.getTotalPrice(), is(75d));
    }
}
