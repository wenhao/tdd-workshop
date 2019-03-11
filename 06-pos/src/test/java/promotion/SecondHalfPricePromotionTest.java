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

package promotion;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.SecondHalfPricePromotion;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class SecondHalfPricePromotionTest {
    @Test
    public void should_be_able_to_get_second_half_price_if_item_needs_half_price() {
        // given
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // when
        Double cost = new SecondHalfPricePromotion(shoppingItem).cost();

        // then
        assertThat(cost).isEqualTo(60d);
    }
}