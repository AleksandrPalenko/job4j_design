package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
               int number = Integer.parseInt(line);
                    String rsl = number % 2 == 0 ? "This is even" : "This is not even";
                System.out.println(rsl + " " + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}