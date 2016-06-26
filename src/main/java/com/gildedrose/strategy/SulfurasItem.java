package com.gildedrose.strategy;

import com.gildedrose.Item;

public class SulfurasItem implements ItemStrategy {
    @Override
    public Item handle(Item item) {
        return new Item(item.name, item.sellIn, item.quality);
    }
}
