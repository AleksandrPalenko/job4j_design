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
        MemTrash trash = new MemTrash();
        MemShop shop = new MemShop();
        MemWarehouse warehouse = new MemWarehouse();
        List<Storage> list = List.of(trash, shop, warehouse);
        Food milk = new MilkFood("Milk",
                LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 16),
                100,
                0);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.sorted(milk);
        assertThat(milk.getDiscount(), is(0));
    }

}