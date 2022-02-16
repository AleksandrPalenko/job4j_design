package ru.job4j.solid;

import java.util.List;

public class ControlQuality {

    private List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void sorted(Food food) {
        for (Storage store : storage) {
            store.add(food);
        }
    }
}