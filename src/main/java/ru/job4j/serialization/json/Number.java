package ru.job4j.serialization.json;

public class Number {
    private final String gosNumber;

    public Number(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "gosNumber='" + gosNumber + '\''
                + '}';
    }
}