package ru.job4j.solid;

import java.util.List;
import java.util.function.Predicate;

public class MemTrash implements ControllQuality {
    @Override
    public List<Food> processBy(Predicate<Food> filter) {
        return null;
    }
}
