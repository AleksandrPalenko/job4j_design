package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        for (String s : mem.keySet()) {
            if (!mem.containsKey(s)) {
                mem.put(model.getId(), model);
            }
        }

    }

    @Override
    public boolean replace(String id, T model) {
            T value = mem.get(id);
            return mem.replace(id, model, value);
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