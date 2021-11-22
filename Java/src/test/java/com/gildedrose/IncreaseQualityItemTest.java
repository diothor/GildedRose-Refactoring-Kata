package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

abstract class IncreaseQualityItemTest extends ItemTest {

    private static final int MAX_QUALITY = 50;

    @Test
    void testQualityIncreases() {
        final int quality = 4;
        Item actual = new Item(getItemName(), 11, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), 10, quality + 1);
        assertItem(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 1})
    void testItemMaxQuality(int sellIn) {
        Item actual = new Item(getItemName(), sellIn, MAX_QUALITY);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, MAX_QUALITY);
        assertItem(expected, actual);
    }

}
