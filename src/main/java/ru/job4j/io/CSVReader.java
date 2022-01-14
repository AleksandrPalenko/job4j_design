package ru.job4j.io;

import ru.job4j.serialization.json.A;

import java.io.*;
import java.util.*;

public class CSVReader {

    public static void valid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        ArgsName argsName = ArgsName.of(args);
        for (String str : args) {
            argsName.get(str);
            File file = new File(argsName.get("path"));
            if (!file.isDirectory() || !file.exists()) {
                throw new IllegalArgumentException("File does not exists");
            } else if (str == null) {
                throw new IllegalArgumentException(
                        String.format("The parameter %s is not found", str));
            }
        }
    }
/*
-path=file.csv -delimiter=";"  -out=stdout -filter=name,age
 */

    public static void handle(ArgsName argsName) throws Exception {
        List<String> filterVal = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String path = argsName.get("path");
        String filter = argsName.get("filter");
        var scanner = new Scanner(new BufferedReader(new FileReader(argsName.get(path))));
        if (scanner.hasNext()) {
            String[] arg = scanner.nextLine().split(delimiter);
            StringJoiner tempLine = new StringJoiner(";");
            for (int i = 0; i < arg.length; i++) {
                if (filter.contains(arg[i])) {
                    filterVal.add(String.valueOf(i));
                } else if (filterVal.contains(arg[i])) {
                    tempLine.add(String.valueOf(i));
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
        valid(args);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
