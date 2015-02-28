package com.github.wenhao.tdd.pos.parser;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.ShoppingCarItem;
import org.junit.Test;

public class ShoppingCarItemParserTest
{
    @Test
    public void should_be_able_to_parse_shopping_car_item()
    {
        // given

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        List<ShoppingCarItem> shoppingCarItems = shoppingCarItemParser.parse("cart.txt");

        // then
        assertThat(shoppingCarItems.size(), is(7));
        assertThat(shoppingCarItems.get(2).getName(), is("ITEM000001"));
        assertThat(shoppingCarItems.get(2).getAmount(), is(3));
    }

    @Test
    public void should_be_able_to_parse_shopping_car_item_by_using_default()
    {
        // given

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        List<ShoppingCarItem> shoppingCarItems = shoppingCarItemParser.parse("cart.txt");

        // then
        assertThat(shoppingCarItems.get(0).getName(), is("ITEM000001"));
        assertThat(shoppingCarItems.get(0).getAmount(), is(1));
    }
}
