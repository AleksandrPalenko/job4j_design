package ru.job4j.io.serialization.xml;

import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) {
       final Computer computer = new Computer(true, 1, new Model("Acer NITRO 5"),
                new String[]{"Intel core i5", "GeForce GTX 1650"});
    }
}
