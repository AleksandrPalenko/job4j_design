package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private final Map<String, String> values = new HashMap<>();

    public static void packFiles(List<Path> sources, File target) {
        if (!target.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory");
        }
        if (sources.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path str : sources) {
                zip.putNextEntry(new ZipEntry(str.toFile().getName()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(str.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void check(String[] strings) {
        for (String string : strings) {
            String[] str = string.split("=");
            if (str.length != 2 || !str[0].startsWith("-") || str[0].isEmpty()) {
                throw new IllegalArgumentException("Invalid string");
            }
            if (str[0].equals("-d")) {
                File file = new File(str[1]);
                if (!file.isDirectory() || !file.exists()) {
                    throw new IllegalArgumentException("Archive directory does not exists");
                }
            }
        }
    }

    private void parse(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        check(args);
        for (String arg : args) {
            String[] str = arg.split("=");
            values.put(str[0].substring(1), str[1]);
        }

    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.parse(args);
        ArgsName argsName = ArgsName.of(args);
        File output = new File(argsName.get("o"));
        Path path = Path.of(argsName.get("d"));
        String st = argsName.get("e");
        List<Path> list = Search.search(path, p -> !p.toFile().getName().endsWith(st));
        packFiles(list, output);
    }
}