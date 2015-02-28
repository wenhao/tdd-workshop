package com.github.wenhao.tdd.pos.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.DiscountItem;
import org.junit.Test;

public class DiscountPromotionParserTest
{
    @Test
    public void should_be_able_to_parse_discount_item()
    {
        // given
        String line = "ITEM000001:75";

        // when
        DiscountPromotionParser discountPromotionParser = new DiscountPromotionParser();
        DiscountItem discountItem = discountPromotionParser.parse(line);

        // then
        assertThat(discountItem.getName(), is("ITEM000001"));
        assertThat(discountItem.getRate(), is(75));
    }
}
