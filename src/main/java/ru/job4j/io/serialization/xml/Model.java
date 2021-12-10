package ru.job4j.io.serialization.xml;

public class Model {
    private final String seriesNumber;

    public Model(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    @Override
    public String toString() {
        return "Model{"
                + "seriesNumber='" + seriesNumber + '\''
                + '}';
    }
}

