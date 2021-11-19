package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Invalid. need arguments");
        }
        for (String str : args) {
            if (check(str)) {
                throw new IllegalArgumentException("Exception");
            }
            String[] tmp = str.replaceFirst("-", "").split("=");
            values.put(tmp[0], tmp[1]);
        }
    }

    private boolean check(String str) {
        if (!str.startsWith("-") || str.startsWith("-=") || str.contains("==") || !str.contains("=") || str.endsWith("=")) {
            throw new IllegalArgumentException("Invalid string");
        }
        return false;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}