package ru.job4j.solid;

import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Ignore
    @Test
    public void whenFoodIsExpired() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food milk = new MilkFood("Milk",
                LocalDate.now(),
                LocalDate.now().minusDays(10),
                100,
                0);
        controlQuality.sorted(milk);
        assertThat(trash.storeFood(), is(milk));
    }

    @Ignore
    @Test
    public void whenFoodIsReadyToShop() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food meet = new MeetFood("Meet",
                LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(21),
                100,
                0);
        Food cheese = new MilkFood("Cheese",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(10),
                200,
                0);
        controlQuality.sorted(meet);
        assertThat(shop.storeFood(), is(List.of(meet, cheese)));
    }

    @Ignore
    @Test
    public void whenFoodToCloseToExpired() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food milk = new MilkFood("Milk",
                LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(10),
                100,
                30);
        controlQuality.sorted(milk);
        assertThat(milk.getDiscount(), is(0));
    }

    @Ignore
    @Test
    public void whenFoodToReadyToWarehouse() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food yogurt = new MilkFood("Yogurt",
                LocalDate.now().plusDays(28),
                LocalDate.now().minusDays(2),
                100,
                30);
        controlQuality.sorted(yogurt);
        assertEquals(warehouse.storeFood().size(), is(1));
    }

}