package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

class PassQualityModifierBuilder {

    QualityModifier build(Item item) {
        int increaseRate = calculateIncreaseMultiplier(item);
        return new AboveZeroQualityDecorator(new IncreaseQualityModifier(increaseRate));
    }

    private int calculateIncreaseMultiplier(Item item) {
        int multiplier = 1;
        if (item.sellIn < 10) {
            multiplier += 1;
        }
        if (item.sellIn < 5) {
            multiplier += 1;
        }
        return multiplier;
    }
}
