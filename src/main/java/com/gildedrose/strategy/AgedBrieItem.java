package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieItem implements ItemStrategy {

    @Override
    public Item handle(Item item) {
        int newQualtity = 0;
        if (item.sellIn > 0) {
            newQualtity = item.quality + 1;
        } else {
            newQualtity = item.quality + 2;
        }

        if (newQualtity >= 50) {
            newQualtity = 50;
        }
        return new Item(item.name, item.sellIn - 1, newQualtity);
    }
}
