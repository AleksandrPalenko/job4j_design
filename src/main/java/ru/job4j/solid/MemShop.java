package ru.job4j.solid;


import java.util.ArrayList;
import java.util.List;

public class MemShop implements Storage {

    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            list.add(food);
        } else if (getPercent(food) < 25) {
            food.setDiscount(30);
        }

        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        if (getPercent(food) >= 25 || getPercent(food) < 100) {
            rsl = list.add(food);
        } else if (getPercent(food) >= 75 || getPercent(food) < 100) {
            food.setDiscount(30);
            rsl = list.add(food);
        }
        return rsl;
    }

    @Override
    public List<Food> storeFood() {
        return List.copyOf(list);
    }
}
