package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredItem implements ItemStrategy {
    @Override
    public Item handle(Item item) {
        int newQualtity = 0;
        if (item.quality > 0) {
            if (item.sellIn > 0) {
                newQualtity = item.quality - 2;
            } else {
                newQualtity = item.quality - 4;
            }
        }
        return new Item(item.name, item.sellIn - 1, newQualtity);
    }
}
