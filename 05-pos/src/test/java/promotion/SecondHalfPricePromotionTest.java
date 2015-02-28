package promotion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.SecondHalfPricePromotion;
import org.junit.Test;

public class SecondHalfPricePromotionTest
{
    @Test
    public void should_be_able_to_get_second_half_price_if_item_needs_half_price()
    {
        // given
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // when
        Double cost = new SecondHalfPricePromotion(shoppingItem).cost();

        // then
        assertThat(cost, is(60d));
    }
}