package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConjuredItemTest extends ItemTest {

    @Override
    public String getItemName() {
        return "Conjured Item";
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {1, 2, 10})
    void testQualityDecreaseBeforeSellDate(int sellIn) {
        final int quality = 20;
        Item actual = new Item(getItemName(), sellIn, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, quality - 2);
        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {-1, 0})
    void testQualityDecreaseAfterSellDate(int sellIn) {
        final int quality = 6;
        Item actual = new Item(getItemName(), sellIn, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, quality - 4);
        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}, quality = {1}")
    @CsvSource({"1, 2", "1, 0", "0, 2", "-1, 2", "-1, 4"})
    void testQualityNeverGoesBelowZero(int sellIn, int quality) {
        Item actual = new Item(getItemName(), sellIn, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, 0);
        assertItem(expected, actual);
    }
}
