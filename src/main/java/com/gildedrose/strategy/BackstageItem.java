package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstageItem implements ItemStrategy {

    @Override
    public Item handle(Item item) {
        int newQualtity = 0;
        if (item.sellIn > 10) {
            newQualtity = item.quality + 1;
        } else if (item.sellIn > 5) {
            newQualtity = item.quality + 2;
        } else if (item.sellIn > 0) {
            newQualtity = item.quality + 3;
        }

        return new Item(item.name, item.sellIn - 1, newQualtity);
    }
}
