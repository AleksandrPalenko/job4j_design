package ru.job4j.solid;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MemShop implements Storage {

    @Override
    public boolean add(Food food, List<Food> list) {
        return false;
    }
}
