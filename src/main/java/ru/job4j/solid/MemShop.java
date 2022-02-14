package ru.job4j.solid;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MemShop implements ControllQuality {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> processBy(Predicate<Food> filter) {
        return null;
    }

}
