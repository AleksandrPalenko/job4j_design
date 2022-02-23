package ru.job4j.solid.lsp;

import java.time.LocalDate;

public class MilkFood extends Food {
    public MilkFood(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
