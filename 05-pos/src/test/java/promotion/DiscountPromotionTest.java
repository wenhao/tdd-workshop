package promotion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import org.junit.Test;

public class DiscountPromotionTest
{
    @Test
    public void should_be_able_to_get_discounted_price_if_item_needs_discount()
    {
        // given
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // when
        Double cost = new DiscountPromotion(shoppingItem, 75d).cost();

        // then
        assertThat(cost, is(60d));
    }
}