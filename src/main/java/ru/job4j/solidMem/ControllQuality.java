package ru.job4j.solidMem;

import java.util.List;
import java.util.function.Predicate;

public interface ControllQuality {

    List<Food> processBy(Predicate<Food> filter);
}
