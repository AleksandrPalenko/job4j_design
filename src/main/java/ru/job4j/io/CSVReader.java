package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void main(String[] args) throws Exception {
        handle(ArgsName.of(args));
    }

    public static void handle(ArgsName argsName) throws Exception {
        var data = String.join("employees.csv");
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter("; ");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
    }
}
