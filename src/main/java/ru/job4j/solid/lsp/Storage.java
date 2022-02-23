package ru.job4j.solid.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    boolean add(Food food);

    default int getPercent(Food food) {
        return (LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear()) * 100
                / (food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear());
    }

    boolean accept(Food food);

    List<Food> storeFood();
}
