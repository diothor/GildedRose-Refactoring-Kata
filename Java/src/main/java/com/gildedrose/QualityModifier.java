package com.gildedrose;

import java.util.function.Consumer;

public interface QualityModifier extends Consumer<Item> {

    void modifyQuality(Item item);

    @Override
    default void accept(Item item) {
        modifyQuality(item);
    }

    default boolean isAfterSellInDay(Item item) {
        return item.sellIn < 0;
    }
}
