package ru.job4j.solid;

import java.util.List;
import java.util.function.Predicate;

public class MemWarehouse implements ControllQuality{
    @Override
    public List<Food> processBy(Predicate<Food> filter) {
        return null;
    }
}
