package com.github.wenhao.tdd.pos.parser;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.DiscountItem;
import org.junit.Test;

public class DiscountPromotionParserTest
{
    @Test
    public void should_be_able_to_parse_discount_item()
    {
        // when
        DiscountPromotionParser discountPromotionParser = new DiscountPromotionParser();
        List<DiscountItem> discountItems = discountPromotionParser.parse("discount_promotion.txt");

        // then
        assertThat(discountItems.size(), is(2));
        assertThat(discountItems.get(0).getName(), is("ITEM000001"));
        assertThat(discountItems.get(0).getRate(), is(75));
    }
}
