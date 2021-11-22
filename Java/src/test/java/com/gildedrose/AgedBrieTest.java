package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AgedBrieTest extends IncreaseQualityItemTest {

    @Override
    public String getItemName() {
        return "Aged Brie";
    }

    @ParameterizedTest(name = "[{index}] quality = {0}")
    @ValueSource(ints = {-3, -1, 0, 4, 48})
    void testQualityIncreaseDoubledWhenAfterSellDate(int quality) {
        final int sellIn = 0;
        Item agedBrie = new Item(getItemName(), sellIn, quality);

        createGildedRose(agedBrie).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, quality + 2);
        assertItem(expected, agedBrie);
    }
}
