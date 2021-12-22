package ru.job4j.io;

import ru.job4j.serialization.json.A;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {

    public static void valid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        ArgsName.of(args);
        if (args[0].startsWith("-path")) {
            File file = new File(args[1]);
            if (!file.isDirectory() || !file.exists()) {
                throw new IllegalArgumentException("File does not exists");
            }
        }
    }


    public static void handle(ArgsName argsName) throws Exception {

    }
}
