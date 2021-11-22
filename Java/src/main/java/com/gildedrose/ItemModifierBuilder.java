package com.gildedrose;

import java.util.function.Function;

public interface ItemModifierBuilder<T> extends Function<Item, T> {

    T build(Item item);

    @Override
    default T apply(Item item) {
        return build(item);
    }
}
