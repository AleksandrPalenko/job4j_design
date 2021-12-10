package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "model")
public class Model {
    private String seriesNumber;

    public Model() {

    }

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

