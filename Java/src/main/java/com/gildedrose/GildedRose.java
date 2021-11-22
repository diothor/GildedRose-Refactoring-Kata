package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private final ItemUpdateStrategy updater;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        updater = new ItemUpdateStrategy();
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(updater::update);
    }
}
