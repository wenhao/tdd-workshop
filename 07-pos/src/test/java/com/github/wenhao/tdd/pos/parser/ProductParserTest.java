package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.Product;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductParserTest {
    @Test
    public void should_be_able_to_convert_shopping_item() {
        // when
        ProductParser productParser = new ProductParser();
        List<Product> products = productParser.parse("itemlist.txt");

        // then
        assertThat(products.size()).isEqualTo(3);
        assertThat(products.get(0).getName()).isEqualTo("ITEM000001");
        assertThat(products.get(0).getPrice()).isEqualTo(40d);
    }
}
