/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.ShoppingCarItem;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
