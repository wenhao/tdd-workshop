package com.github.wenhao.tdd.pos.parser;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.SecondHalfItem;
import org.junit.Test;

public class SecondHalfPriceParserTest
{
    @Test
    public void should_be_able_to_parse_second_half_price()
    {
        // given
        // when

        SecondHalfPriceParser secondHalfPriceParser = new SecondHalfPriceParser();
        List<SecondHalfItem> secondHalfItems = secondHalfPriceParser.parse("second_half_price_promotion.txt");

        // then
        assertThat(secondHalfItems.size(), is(2));
        assertThat(secondHalfItems.get(0).getName(), is("ITEM000001"));
    }
}
