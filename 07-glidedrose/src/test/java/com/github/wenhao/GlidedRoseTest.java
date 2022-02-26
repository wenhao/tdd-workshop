package com.github.wenhao;

import com.github.wenhao.domain.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GlidedRoseTest {

    @Test
    public void should_decrease_product_sellin_and_decrease_quality_for_normal_product() {
        // given
        Product product = new Product("normal", 2, 2);
        final List<Product> products = new ArrayList<>();
        products.add(product);

        // when
        GlidedRose glidedRose = new GlidedRose(products);
        glidedRose.passOneDay();
        final Product updatedProduct = glidedRose.getProducts().get(0);

        // then
        assertThat(updatedProduct.getSellIn()).isEqualTo(1);
        assertThat(updatedProduct.getQuality()).isEqualTo(1);
    }
}
