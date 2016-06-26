package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class GildedRose {
    private List<Item> items;

    private Map<String, ItemStrategy> itemStrategies = new HashMap<>();

    {
        itemStrategies.put("Aged Brie", new AgedBrieItem());
        itemStrategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstageItem());
        itemStrategies.put("Sulfuras, Hand of Ragnaros", new SulfurasItem());
        itemStrategies.put("Conjured", new ConjuredItem());
    }

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {

        items = items.stream().map(item -> {
            ItemStrategy itemStrategy = itemStrategies.getOrDefault(item.name, new NormalItem());
            return itemStrategy.handle(item);
        }).collect(Collectors.toList());
    }

    public Item getFirstItem() {
        return items.get(0);
    }
}
