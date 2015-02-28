package com.github.wenhao.tdd.pos.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.Product;
import org.junit.Test;

public class ProductParserTest
{
    @Test
    public void should_be_able_to_convert_shopping_item()
    {
        // given
        String lines = "ITEM000001:40";
        
        // when
        ProductParser productParser = new ProductParser();
        Product product = productParser.parse(lines);

        // then
        assertThat(product.getName(), is("ITEM000001"));
        assertThat(product.getPrice(), is(40d));
    }
}
