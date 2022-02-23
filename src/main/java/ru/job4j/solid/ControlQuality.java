package ru.job4j.solid;

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
            } else {
                throw new IllegalArgumentException(food.getName() + " unallocated in storage");
            }
        }
    }
}