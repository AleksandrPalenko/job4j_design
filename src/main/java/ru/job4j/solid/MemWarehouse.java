package ru.job4j.solid;

import java.util.List;
import java.util.function.Predicate;

public class MemWarehouse implements Storage {

    @Override
    public boolean add(Food food, List<Food> list) {
        return false;
    }
}
