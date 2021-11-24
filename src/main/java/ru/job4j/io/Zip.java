package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private final Map<String, String> values = new HashMap<>();

    public static void packFiles(List<File> sources, File target) {
        if (!target.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory");
        }
        if (sources.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File str : sources) {
                zip.putNextEntry(new ZipEntry(str.getName()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(str))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void check(String str) {
        if (!str.startsWith("-") || !str.startsWith("С:") || !str.contains("-e") || !str.contains("-o")) {
            throw new IllegalArgumentException("Invalid string");
        }
    }

    private void parse(String[] args) {
        for (String arg : args) {
            check(arg);
            String[] str = arg.split("=");
            values.put(str[0].substring(1), str[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.parse(args);
        ArgsName argsName = ArgsName.of(args);
        Path path = Path.of(argsName.get("d"));
        String st = argsName.get("e");
        Search.search(path, p -> p.toFile().getName().equals(st));
        packFiles(
                Collections.singletonList(new File("./poms.xml")),
                new File("./poms.zip")
        );
    }
}