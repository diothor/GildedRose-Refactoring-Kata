package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

class DecreaseQualityModifier implements QualityModifier {

    protected static final int DEFAULT_DECREASE = 1;
    private final int decreaseRate;

    DecreaseQualityModifier(int decreaseRate) {
        this.decreaseRate = decreaseRate;
    }

    DecreaseQualityModifier() {
        this(1);
    }

    @Override
    public void modifyQuality(Item item) {
        decrease(item);
    }

    void decrease(Item item) {
        int decrease = isAfterSellInDay(item) ? 2 * DEFAULT_DECREASE : DEFAULT_DECREASE;
        item.quality -= decreaseRate * decrease;
        item.quality = Math.max(item.quality, 0);
    }
}
