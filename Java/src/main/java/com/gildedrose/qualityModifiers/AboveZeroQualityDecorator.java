package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

class AboveZeroQualityDecorator implements QualityModifier {

    private final QualityModifier qualityModifier;

    AboveZeroQualityDecorator(QualityModifier qualityModifier) {
        this.qualityModifier = qualityModifier;
    }

    @Override
    public void modifyQuality(Item item) {
        if(isAfterSellInDay(item)) {
            item.quality = 0;
        } else {
            qualityModifier.modifyQuality(item);
        }
    }
}
