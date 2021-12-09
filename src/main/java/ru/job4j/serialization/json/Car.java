package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final boolean isNew;
    private final int age;
    private final Number number;
    private final String[] statuses;

    public Car(boolean isNew, int age, Number number, String[] statuses) {
        this.isNew = isNew;
        this.age = age;
        this.number = number;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{" + "isNew=" + isNew + ", age=" + age + ", car=" + number + ", statuses=" + Arrays.toString(statuses) + '}';
    }
}