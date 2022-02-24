package ru.job4j.solid.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

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
        assertThat(trash.storeFood(), is(List.of(milk)));
    }

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
                LocalDate.now().minusDays(11),
                200,
                0);
        controlQuality.sorted(meet);
        controlQuality.sorted(cheese);
        assertThat(shop.storeFood(), is(List.of(meet, cheese)));
    }

    @Test
    public void whenFoodToCloseToExpiredAndDiscount() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food milk = new MilkFood("Milk",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(21),
                100,
                0.4);
        controlQuality.sorted(milk);
        assertThat(shop.storeFood().size(), is(1));
        assertThat(shop.storeFood().get(0).getPrice(), is(60));
    }

    @Test
    public void whenFoodToReadyToWarehouse() {
        Storage trash = new MemTrash();
        Storage shop = new MemShop();
        Storage warehouse = new MemWarehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, shop, warehouse));
        Food yogurt = new MilkFood("Yogurt",
                LocalDate.now().plusDays(15),
                LocalDate.now().minusDays(1),
                100,
                0);
        controlQuality.sorted(yogurt);
        assertThat(warehouse.storeFood().size(), is(1));
    }

}