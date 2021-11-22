package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.ItemModifierBuilder;
import com.gildedrose.QualityModifier;

class BeforeAfterDateModifierBuilder<T> implements ItemModifierBuilder<T> {

    private final int date;
    private final T before;
    private final T after;

    BeforeAfterDateModifierBuilder(int date, T before, T after) {
        this.date = date;
        this.before = before;
        this.after = after;
    }

    public T build(Item item) {
        final int sellIn = item.sellIn;
        return sellIn < date ? after : before;
    }
}
