package com.gildedrose.sellInModifiers;

import com.gildedrose.Item;
import com.gildedrose.SellInModifier;

class DecreaseSellInModifier implements SellInModifier {
    @Override
    public void modifySellIn(Item item) {
        item.sellIn -= 1;
    }
}
