package ru.job4j.solid;

import java.util.List;

public interface Storage {
    boolean add(Food food, List<Food> list);
}
