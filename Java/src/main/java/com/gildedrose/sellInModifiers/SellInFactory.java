package com.gildedrose.sellInModifiers;

import com.gildedrose.Item;
import com.gildedrose.SellInModifier;

public class SellInFactory {

    public SellInModifier build(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return item1 -> {};
        }
        return new DecreaseSellInModifier();
    }
}
