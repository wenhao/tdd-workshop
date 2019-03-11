package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.SecondHalfItem;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SecondHalfPriceParserTest {
    @Test
    public void should_be_able_to_parse_second_half_price() {
        // given
        // when

        SecondHalfPriceParser secondHalfPriceParser = new SecondHalfPriceParser();
        List<SecondHalfItem> secondHalfItems = secondHalfPriceParser.parse("second_half_price_promotion.txt");

        // then
        assertThat(secondHalfItems.size()).isEqualTo(2);
        assertThat(secondHalfItems.get(0).getName()).isEqualTo("ITEM000001");
    }
}
