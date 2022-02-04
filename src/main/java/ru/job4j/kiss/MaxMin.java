package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return func(value, p -> p < 0, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return func(value, p -> p > 0, comparator);
    }

    public <T> T func(List<T> value, Predicate<Integer> find, Comparator<T> comparator) {
        T val = value.get(0);
        for (T tVal : value) {
            if (find.test(comparator.compare(val, tVal))) {
                val = tVal;
            }
        }
        return val;
    }
}