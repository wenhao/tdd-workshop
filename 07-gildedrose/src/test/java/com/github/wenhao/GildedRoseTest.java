package com.github.wenhao;

import java.util.List;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.wenhao.domain.Product;
import com.google.common.collect.Lists;

public class GildedRoseTest {

    @Test
    public void should_decrease_product_sellin_and_decrease_quality_for_normal_product() {
        // given
        final List<Product> products = Lists.newArrayList(new NormalProduct(2, 2));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(1);
        assertThat(products.get(0).getQuality()).isEqualTo(1);
    }

    @Test
    public void should_decrease_product_sellin_and_double_decrease_quality_for_expired_product() {
        // given
        final List<Product> products = Lists.newArrayList(new NormalProduct(0, 2));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(0);
        assertThat(products.get(0).getQuality()).isEqualTo(0);
    }

    @Test
    public void should_decrease_product_sellin_and_double_decrease_quality_but_quality_must_large_than_zero() {
        // given
        final List<Product> products = Lists.newArrayList(new NormalProduct(0, 0));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(0);
        assertThat(products.get(0).getQuality()).isEqualTo(0);
    }

    @Test
    public void should_decrease_product_sellin_and_increase_quality_for_aged_brie_product() {
        // given
        final List<Product> products = Lists.newArrayList(new AgedBrieProduct(1, 1));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(0);
        assertThat(products.get(0).getQuality()).isEqualTo(2);
    }

    @Test
    public void should_decrease_product_sellin_and_quality_not_larger_than_fifty() {
        // given
        final List<Product> products = Lists.newArrayList(new AgedBrieProduct(1, 50));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getQuality()).isEqualTo(50);
    }

    @Test
    public void should_not_decrease_product_sellin_and_quality_for_sulfuras_product() {
        // given
        final List<Product> products = Lists.newArrayList(new SulfurasProduct(1, 1));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(1);
        assertThat(products.get(0).getQuality()).isEqualTo(1);
    }

    @Test
    public void should_decrease_sellin_and_increase_quality_if_product_is_backstage_pass_and_sellin_large_than_ten_when_update() {
        // given
        final List<Product> products = Lists.newArrayList(new BackstagePassProduct(20, 1));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(19);
        assertThat(products.get(0).getQuality()).isEqualTo(2);
    }

    @Test
    public void should_decrease_sellin_and_double_increase_quality_if_product_is_backstage_pass_and_sellin_less_than_ten_bigger_than_five_when_update() {
        // given
        final List<Product> products = Lists.newArrayList(new BackstagePassProduct(10, 1));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(9);
        assertThat(products.get(0).getQuality()).isEqualTo(3);
    }

    @Test
    public void should_decrease_sellin_and_triple_increase_quality_if_product_is_backstage_pass_and_sellin_less_than_five_when_update() {
        // given
        final List<Product> products = Lists.newArrayList(new BackstagePassProduct(5, 1));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(4);
        assertThat(products.get(0).getQuality()).isEqualTo(4);
    }

    @Test
    public void should_decrease_sellin_and_zero_quality_if_product_is_backstage_pass_and_sellin_less_than_zero_when_update() {
        // given
        final List<Product> products = Lists.newArrayList(new BackstagePassProduct(0, 5));

        // when
        new GildedRose(products).passOneDay();

        // then
        assertThat(products.get(0).getSellIn()).isEqualTo(0);
        assertThat(products.get(0).getQuality()).isEqualTo(0);
    }
}
