package com.github.wenhao.tdd.pos.parser;

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
        String lines = "ITEM000001-2";

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        ShoppingCarItem shoppingCarItem = shoppingCarItemParser.parse(lines);

        // then
        assertThat(shoppingCarItem.getName(), is("ITEM000001"));
        assertThat(shoppingCarItem.getAmount(), is(2));
    }

    @Test
    public void should_be_able_to_parse_shopping_car_item_by_using_default()
    {
        // given
        String lines = "ITEM000001";

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        ShoppingCarItem shoppingCarItem = shoppingCarItemParser.parse(lines);

        // then
        assertThat(shoppingCarItem.getName(), is("ITEM000001"));
        assertThat(shoppingCarItem.getAmount(), is(1));
    }
}
