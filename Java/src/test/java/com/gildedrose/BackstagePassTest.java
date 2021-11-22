package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class BackstagePassTest extends IncreaseQualityItemTest {
    @Override
    public String getItemName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {10, 8, 6})
    void testQualityIncreaseDoubledWhenLessThan11Days(int sellIn) {
        final int quality = 4;
        Item actual = new Item(getItemName(), sellIn, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, quality + 2);
        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {5, 3, 1})
    void testQualityIncreaseTripledWhenLessThan6Days(int sellIn) {
        final int quality = 4;
        Item actual = new Item(getItemName(), sellIn, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), sellIn - 1, quality + 3);
        assertItem(expected, actual);
    }

    @Test
    void testQualityDropsToZeroAfterConcert() {
        final int quality = new Random().nextInt(50);
        Item actual = new Item(getItemName(), 0, quality);

        createGildedRose(actual).updateQuality();

        Item expected = new Item(getItemName(), -1, 0);
        assertItem(expected, actual);
    }
}
