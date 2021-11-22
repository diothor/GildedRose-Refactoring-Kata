package com.gildedrose;

import com.gildedrose.qualityModifiers.QualityFactory;
import com.gildedrose.sellInModifiers.SellInFactory;

class ItemUpdateStrategy {
    private final QualityFactory qualityFactory;
    private final SellInFactory sellInFactory;

    ItemUpdateStrategy() {
        qualityFactory = new QualityFactory();
        sellInFactory = new SellInFactory();
    }

    void update(Item item) {
        sellInFactory.build(item).modifySellIn(item);
        qualityFactory.build(item).modifyQuality(item);
    }
}
