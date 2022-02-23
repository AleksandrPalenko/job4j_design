package ru.job4j.solid.lsp;

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
}