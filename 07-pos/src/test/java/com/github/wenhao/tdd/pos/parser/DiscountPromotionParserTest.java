package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.DiscountItem;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DiscountPromotionParserTest {
    @Test
    public void should_be_able_to_parse_discount_item() {
        // when
        DiscountPromotionParser discountPromotionParser = new DiscountPromotionParser();
        List<DiscountItem> discountItems = discountPromotionParser.parse("discount_promotion.txt");

        // then
        assertThat(discountItems.size()).isEqualTo(2);
        assertThat(discountItems.get(0).getName()).isEqualTo("ITEM000001");
        assertThat(discountItems.get(0).getRate()).isEqualTo(75);
    }
}
