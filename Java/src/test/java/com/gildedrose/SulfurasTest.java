package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class SulfurasTest extends ItemTest {
    @Override
    public String getItemName() {
        return "Sulfuras, Hand of Ragnaros";
    }

    @ParameterizedTest(name = "[{index}] sellIn = {0}")
    @ValueSource(ints = {-1, 0, 1, 10, 20, 49, 50, 60})
    public void testSulfurasIsEternal(final int sellIn) {
        Item sulfuras = new Item(getItemName(), sellIn, 16);

        createGildedRose(sulfuras).updateQuality();

        Item expected = new Item(getItemName(), sellIn, 16);
        assertItem(expected, sulfuras);
    }

    @ParameterizedTest(name = "[{index}] quality = {0}")
    @ValueSource(ints = {-6, 0, 12, Integer.MAX_VALUE})
    public void testSulfurasQualityDoesNotChange(final int quality) {
        final int sellIn = new Random().nextInt(60);
        Item sulfuras = new Item(getItemName(), sellIn, quality);

        createGildedRose(sulfuras).updateQuality();

        Item expected = new Item(getItemName(), sellIn, quality);
        assertItem(expected, sulfuras);
    }
}
