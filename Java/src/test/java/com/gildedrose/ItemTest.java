package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ItemTest {
    abstract String getItemName();

    void assertItem(Item expected, Item actual) {
        assertAll(() -> {
            assertEquals(expected.name, actual.name);
            assertEquals(expected.quality, actual.quality);
            assertEquals(expected.sellIn, actual.sellIn);
        });
    }

    GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }
}
