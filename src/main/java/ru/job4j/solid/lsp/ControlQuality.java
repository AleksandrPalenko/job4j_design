package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void sorted(Food food) {
        for (Storage store : storage) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
    }

    public void resort() {
        List<Food> product = new ArrayList<>();
        for (Storage store: storage) {
            product.addAll(store.storeFood());
        }
        for (Food foods:product) {
            sorted(foods);
        }
    }
}