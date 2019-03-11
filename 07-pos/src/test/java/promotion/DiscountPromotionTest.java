package promotion;

import com.github.wenhao.tdd.pos.domain.ShoppingItem;
import com.github.wenhao.tdd.pos.promotion.DiscountPromotion;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class DiscountPromotionTest {
    @Test
    public void should_be_able_to_get_discounted_price_if_item_needs_discount() {
        // given
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2d);

        // when
        Double cost = new DiscountPromotion(shoppingItem, 75d).cost();

        // then
        assertThat(cost).isEqualTo(60d);
    }
}