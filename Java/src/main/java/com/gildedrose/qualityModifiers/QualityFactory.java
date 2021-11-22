package com.gildedrose.qualityModifiers;

import com.gildedrose.Item;
import com.gildedrose.QualityModifier;

public class QualityFactory {

    private final PassQualityModifierBuilder passQualityModifierBuilder;
    private final BeforeAfterDateModifierBuilder sebaQualityModifierBuilder;

    public QualityFactory() {
        passQualityModifierBuilder = new PassQualityModifierBuilder();
        sebaQualityModifierBuilder = new BeforeAfterDateModifierBuilder(5, new IncreaseQualityModifier(), new DecreaseQualityModifier());
    }

    public QualityModifier build(Item item) {
        if(item.name.toLowerCase().contains("seba")) {
            return sebaQualityModifierBuilder.build(item);
        }
        if (item.name.equals("Aged Brie")) {
            return new IncreaseQualityModifier();
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return passQualityModifierBuilder.build(item);
        }
        if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return item1 -> {};
        }
        if(item.name.toLowerCase().contains("conjured")) {
            return new DecreaseQualityModifier(2);
        }

        return new DecreaseQualityModifier();
    }
}
