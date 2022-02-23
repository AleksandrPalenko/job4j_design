package ru.job4j.solid.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    boolean add(Food food);

    default int getPercent(Food food) {
        //LocalDate date = LocalDate.now();
        //Duration shelfLife = Duration.between(food.getCreateDate(), food.getExpiryDate());
        //Duration dayBeforeExpired = Duration.between(date, food.getCreateDate());
        //return (int) Math.abs((dayBeforeExpired.toDays() / shelfLife.toDays()) * 100);
        return (LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear()) * 100
                / (food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear());
    }

    boolean accept(Food food);

    List<Food> storeFood();
}
