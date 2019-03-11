package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.ShoppingCarItem;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShoppingCarItemParserTest {
    @Test
    public void should_be_able_to_parse_shopping_car_item() {
        // given

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        List<ShoppingCarItem> shoppingCarItems = shoppingCarItemParser.parse("cart.txt");

        // then
        assertThat(shoppingCarItems.size()).isEqualTo(7);
        assertThat(shoppingCarItems.get(2).getName()).isEqualTo("ITEM000001");
        assertThat(shoppingCarItems.get(2).getAmount()).isEqualTo(3);
    }

    @Test
    public void should_be_able_to_parse_shopping_car_item_by_using_default() {
        // given

        // when
        ShoppingCarItemParser shoppingCarItemParser = new ShoppingCarItemParser();
        List<ShoppingCarItem> shoppingCarItems = shoppingCarItemParser.parse("cart.txt");

        // then
        assertThat(shoppingCarItems.get(0).getName()).isEqualTo("ITEM000001");
        assertThat(shoppingCarItems.get(0).getAmount()).isEqualTo(1);
    }
}
