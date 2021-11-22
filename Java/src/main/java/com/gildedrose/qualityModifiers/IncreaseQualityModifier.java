package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

class IncreaseQualityModifier implements QualityModifier {

    protected static final int DEFAULT_INCREASE = 1;
    protected static final int MAX_QUALITY = 50;
    private final int increaseRate;

    IncreaseQualityModifier(int increaseRate) {
        this.increaseRate = increaseRate;
    }

    IncreaseQualityModifier() {
        this(1);
    }

    public void modifyQuality(Item item) {
        int increase = calculateIncrease(item);
        increase(item, increase);
    }

    int calculateIncrease(Item item) {
        return isAfterSellInDay(item) ? 2 * DEFAULT_INCREASE : DEFAULT_INCREASE;
    }

    protected void increase(Item item, int increase) {
        item.quality += increaseRate * increase;
        item.quality = Math.min(item.quality, MAX_QUALITY);
    }
}
