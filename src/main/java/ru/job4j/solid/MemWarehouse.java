package ru.job4j.solid;


import java.util.ArrayList;
import java.util.List;

public class MemWarehouse implements Storage {

    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            list.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) < 25;
    }

    @Override
    public List<Food> storeFood() {
        return List.copyOf(list);
    }
}
