package com.github.wenhao.tdd.pos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import com.github.wenhao.tdd.pos.promotion.SecondHalfPricePromotion;
import org.junit.Test;

public class PosTest
{
    @Test
    public void should_be_able_to_get_original_price_without_promotion()
    {
        // when
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // then
        assertThat(shoppingItem.cost(), is(40d * 2));
    }

    @Test
    public void should_be_able_to_get_multiple_promotion()
    {
        // given
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // when
        Double cost = new SecondHalfPricePromotion(new DiscountPromotion(shoppingItem, 75d)).cost();

        // then
        assertThat(cost, is(45d));
    }

}
