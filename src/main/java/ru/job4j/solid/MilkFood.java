package ru.job4j.solid;

import java.time.LocalDate;
import java.util.Date;

public class MilkFood extends Food {
    public MilkFood(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
