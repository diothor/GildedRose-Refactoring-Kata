package com.gildedrose;

import java.util.function.Consumer;

public interface SellInModifier extends Consumer<Item> {

    void modifySellIn(Item item);

    @Override
    default void accept(Item item) {
        modifySellIn(item);
    }
}
