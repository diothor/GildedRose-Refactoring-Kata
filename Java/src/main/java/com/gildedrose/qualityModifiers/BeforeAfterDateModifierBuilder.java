package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

class BeforeAfterDateModifierBuilder {

    private final int date;
    private final QualityModifier before;
    private final QualityModifier after;

    BeforeAfterDateModifierBuilder(int date, QualityModifier before, QualityModifier after) {
        this.date = date;
        this.before = before;
        this.after = after;
    }

    QualityModifier build(Item item) {
        final int sellIn = item.sellIn;
        return sellIn < date ? after : before;
    }
}
