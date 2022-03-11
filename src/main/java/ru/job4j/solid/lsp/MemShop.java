package ru.job4j.solid.lsp;


import java.util.ArrayList;
import java.util.List;

public class MemShop implements Storage {

    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            if (getPercent(food) >= 75) {
                food.setPrice((int) (food.getPrice() - (food.getPrice() * food.getDiscount())));
            }
            list.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 25 && getPercent(food) < 100;
    }

    @Override
    public List<Food> storeFood() {
        return List.copyOf(list);
    }

    @Override
    public void cleared() {
        list.clear();
    }
}
