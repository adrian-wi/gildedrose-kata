package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        List<Item> items = Arrays.asList(new Item("foo", 0, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getFirstItem().name);
        assertEquals(-1, app.getFirstItem().sellIn);
    }

    @Test
    public void passedSellByDateCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("foo", -1, 20));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("foo", app.getFirstItem().name);
        assertEquals(18, app.getFirstItem().quality);
        assertEquals(-2, app.getFirstItem().sellIn);
    }


    @Test
    public void sellByDatePassed() {
        //given
        List<Item> items = Arrays.asList(new Item("foo", -1, 0));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("foo", app.getFirstItem().name);
        assertEquals(0, app.getFirstItem().quality);
        assertEquals(-2, app.getFirstItem().sellIn);
    }

    @Test
    public void decreaseQualityCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("foo", 1, 1));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("foo", app.getFirstItem().name);
        assertEquals(0, app.getFirstItem().quality);
        assertEquals(0, app.getFirstItem().sellIn);
    }

    @Test
    public void agedBrieQualityCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Aged Brie", 1, 1));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Aged Brie", app.getFirstItem().name);
        assertEquals(2, app.getFirstItem().quality);
        assertEquals(0, app.getFirstItem().sellIn);
    }

    @Test
    public void agedBriePassedSellDateIncrieaseByTwoCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Aged Brie", -1, 40));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Aged Brie", app.getFirstItem().name);
        assertEquals(42, app.getFirstItem().quality);
        assertEquals(-2, app.getFirstItem().sellIn);
    }

    @Test
    public void qualityOverFiftyCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Aged Brie", 1, 50));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Aged Brie", app.getFirstItem().name);
        assertEquals(50, app.getFirstItem().quality);
        assertEquals(0, app.getFirstItem().sellIn);
    }

    @Test
    public void sulfurasCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 1, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Sulfuras, Hand of Ragnaros", app.getFirstItem().name);
        assertEquals(10, app.getFirstItem().quality);
        assertEquals(1, app.getFirstItem().sellIn);
    }

    @Test
    public void backStagePassesIncreasedByOneCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getFirstItem().name);
        assertEquals(11, app.getFirstItem().quality);
        assertEquals(10, app.getFirstItem().sellIn);
    }

    @Test
    public void backStagePassesIncreasedByTwoCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getFirstItem().name);
        assertEquals(12, app.getFirstItem().quality);
        assertEquals(9, app.getFirstItem().sellIn);
    }

    @Test
    public void backStagePassesIncreasedByThreeCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getFirstItem().name);
        assertEquals(13, app.getFirstItem().quality);
        assertEquals(4, app.getFirstItem().sellIn);
    }

    @Test
    public void backStagePassesAfterConcertCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getFirstItem().name);
        assertEquals(0, app.getFirstItem().quality);
        assertEquals(-1, app.getFirstItem().sellIn);
    }

    @Test
    public void conjuredCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Conjured", 2, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Conjured", app.getFirstItem().name);
        assertEquals(8, app.getFirstItem().quality);
        assertEquals(1, app.getFirstItem().sellIn);
    }

    @Test
    public void conjuredSellDatePassedCheck() {
        //given
        List<Item> items = Arrays.asList(new Item("Conjured", -1, 10));
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();

        //then
        assertEquals("Conjured", app.getFirstItem().name);
        assertEquals(6, app.getFirstItem().quality);
        assertEquals(-2, app.getFirstItem().sellIn);
    }

}
