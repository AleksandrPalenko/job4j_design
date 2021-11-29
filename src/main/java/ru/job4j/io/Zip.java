package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private final Map<String, String> values = new HashMap<>();

    public static void packFiles(List<Path> sources, File target) {
        if (sources.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path str : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(str)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(str.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void check(String[] strings) {
        if (strings.length != 3) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        for (String string : strings) {
            StringCheck(string);
            String[] str = string.split("=");
            values.put(strings[0].substring(1), strings[1]);
            if (str[0].startsWith("-d")) {
                File file = new File(str[1]);
                if (!file.isDirectory() || !file.exists()) {
                    throw new IllegalArgumentException("Archive directory does not exists");
                }
            }
        }
    }

    private void StringCheck(String str) {
        if (!str.startsWith("-") || str.startsWith("-=") || str.contains("==") || !str.contains("=") || str.endsWith("=")) {
            throw new IllegalArgumentException("Invalid string");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.check(args);
        ArgsName argsName = ArgsName.of(args);
        File output = new File(argsName.get("o"));
        Path path = Path.of(argsName.get("d"));
        String st = argsName.get("e");
        List<Path> list = Search.search(path, p -> !p.toFile().getName().endsWith(st));
        packFiles(list, output);
    }
}