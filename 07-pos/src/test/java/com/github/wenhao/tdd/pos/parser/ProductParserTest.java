package com.github.wenhao.tdd.pos.parser;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.Product;
import org.junit.Test;

public class ProductParserTest
{
    @Test
    public void should_be_able_to_convert_shopping_item()
    {
        // when
        ProductParser productParser = new ProductParser();
        List<Product> products = productParser.parse("itemlist.txt");

        // then
        assertThat(products.size(), is(3));
        assertThat(products.get(0).getName(), is("ITEM000001"));
        assertThat(products.get(0).getPrice(), is(40d));
    }
}
