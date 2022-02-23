package ru.job4j.solid.lsp;

import java.time.LocalDate;

public class MeetFood extends Food {
    public MeetFood(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
