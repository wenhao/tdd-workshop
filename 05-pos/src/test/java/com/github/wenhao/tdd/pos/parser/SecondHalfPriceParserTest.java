package com.github.wenhao.tdd.pos.parser;

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
        String line = "ITEM000001";

        // when
        SecondHalfPriceParser secondHalfPriceParser = new SecondHalfPriceParser();
        SecondHalfItem secondHalfItem = secondHalfPriceParser.parse(line);

        // then
        assertThat(secondHalfItem.getName(), is("ITEM000001"));
    }
}
