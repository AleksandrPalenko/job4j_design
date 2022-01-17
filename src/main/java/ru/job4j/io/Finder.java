package ru.job4j.io;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*
Программа должна искать данные в заданном каталоге и подкаталогах.
-d=c:/ -n=*.txt -t=mask -o=log.txt
считать аргументы с командной строки, убидится что они валидны(Args)
на основании аргументов оперделить тип поиска, дерискторию начала поиска и т.д.(Searcher)
Реализовать поиск на основании предиката (по имени, маске, по регулярному выражению)(SearcherFiles)
-d - директория, в которой начинать поиск.
-n - имя файла, маска, либо регулярное выражение.
-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
-o - результат записать в файл.
 */
public class Finder {

    private void valid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("invalid arguments");
        }
        ArgsName argsName = ArgsName.of(args);
        File file = new File(argsName.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));

        }
        for (String str : args) {
            argsName.get(str);
            if (str == null) {
                throw new IllegalArgumentException(
                        String.format("The parameter %s is not found", str));
            }
        }
    }

    public static void searchList(ArgsName argsName, File target) throws IOException {
        String typeFinder = argsName.get("t");
        List<Path> list = new ArrayList<>();
        List<List> log =  new ArrayList<>();
        if ("mask".equals(typeFinder)) {
            list = Search.search(Paths.get(argsName.get("d")),
                    p -> p.toFile().getName().endsWith(argsName.get("n").replace("*", "")));
        }
        if ("name".equals(typeFinder)) {
            list = Search.search(Paths.get(argsName.get("d")), p -> p.toFile().getName().equals(argsName.get("n")));
        }
        if ("regex".equals(typeFinder)) {
            list = Search.search(Paths.get(argsName.get("d")),
                    p -> Pattern.compile((argsName.get("n"))).matcher(p.toFile().getName()).find());
        }
        log.add(list);
        try (PrintWriter out = new PrintWriter(new FileWriter(target, Charset.forName("WINDOWS-1251"), true))) {
            for (Path str:list) {
                out.write(String.valueOf(str));
            }
            log.forEach(out::println);
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        finder.valid(args);
        ArgsName argsName = ArgsName.of(args);
        File output = new File(argsName.get("o"));
        searchList(argsName, output);
    }
}
