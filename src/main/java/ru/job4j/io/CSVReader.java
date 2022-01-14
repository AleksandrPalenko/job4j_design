package ru.job4j.io;

import ru.job4j.serialization.json.A;

import java.io.*;
import java.util.*;

public class CSVReader {

    private void valid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        ArgsName argsName = ArgsName.of(args);
        File file = new File(argsName.get("path"));
        if (!file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("File does not exists");
        }
        for (String str : args) {
            argsName.get(str);
            if (str == null) {
                throw new IllegalArgumentException(
                        String.format("The parameter %s is not found", str));
            }
        }
    }
/*
-path=file.csv -delimiter=";"  -out=stdout -filter=name,age
 */

    public static void handle(ArgsName argsName) throws Exception {
        List<Integer> filterVal = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String path = argsName.get("path");
        String filter = argsName.get("filter");
        try (var scanner = new Scanner(new File(path))) {
            if (scanner.hasNext()) {
                String[] arg = scanner.nextLine().split(delimiter);
                for (int i = 0; i < arg.length; i++) {
                    if (filter.contains(arg[i])) {
                        filterVal.add(i);
                    }
                }
            }
        }
        try (var scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                String[] arg = scanner.nextLine().split(delimiter);
                StringJoiner tempLine = new StringJoiner(";");
                for (int i = 0; i < arg.length; i++) {
                    if (filterVal.contains(i)) {
                        tempLine.add(arg[i]);
                    }
                }
                list.add(tempLine.toString());
            }
            if ("stdout".equals(out)) {
                list.forEach(System.out::println);
            } else {
                saveResult(list, out);
            }
        }
    }

    public static void saveResult(List<String> log, String file) throws Exception {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CSVReader csvReader = new CSVReader();
        csvReader.valid(args);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
