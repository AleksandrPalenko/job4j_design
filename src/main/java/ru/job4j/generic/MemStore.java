package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        if (!mem.containsValue(model)) {
            mem.put(model.getId(), model);
        }

    }

    @Override
    public boolean replace(String id, T model) {
        for (String key : mem.keySet()) {
            T value = mem.get(key);
            return mem.replace(id, model, value);
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) != null) {
            mem.remove(id);
            return true;
        }
        return false;

    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}