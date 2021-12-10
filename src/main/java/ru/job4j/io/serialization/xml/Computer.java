package ru.job4j.io.serialization.xml;

import java.util.Arrays;

public class Computer {

    private final boolean isGaming;
    private final int age;
    private final Model model;
    private final String[] statuses;

    public Computer(boolean isGaming, int age, Model model, String[] statuses) {
        this.isGaming = isGaming;
        this.age = age;
        this.model = model;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + isGaming
                + ", age=" + age
                + ", model=" + model
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }


}