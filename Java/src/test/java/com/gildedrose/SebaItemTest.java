package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SebaItemTest extends ItemTest {

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {100, 7, 6})
    void increaseQualityTill5th(int sellInValue) {
        final int qualityValue = 10;
        Item actual = new Item(getItemName(), sellInValue, qualityValue);

        createGildedRose(actual).updateQuality();
        Item expected = new Item(getItemName(), sellInValue - 1, qualityValue + 1);

        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {5, 4, 3, 1})
    void decreaseQualityFrom4th(int sellInValue) {
        final int qualityValue = 10;
        Item actual = new Item(getItemName(), sellInValue, qualityValue);

        createGildedRose(actual).updateQuality();
        Item expected = new Item(getItemName(), sellInValue - 1, qualityValue - 1);

        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {0, -5})
    void decreaseQualityFrom4thWhenExpired(int sellInValue) {
        final int qualityValue = 10;
        Item actual = new Item(getItemName(), sellInValue, qualityValue);

        createGildedRose(actual).updateQuality();
        Item expected = new Item(getItemName(), sellInValue - 1, qualityValue - 2);

        assertItem(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {4, 3, 0, -5})
    void alwaysPositiveQuality(int sellInValue) {
        final int qualityValue = 0;
        Item actual = new Item(getItemName(), sellInValue, qualityValue);

        createGildedRose(actual).updateQuality();
        Item expected = new Item(getItemName(), sellInValue - 1, qualityValue);

        assertItem(expected, actual);
    }

    @Override
    String getItemName() {
        return "Seba Item";
    }
}
