package ru.job4j.io.duplicates;

import ru.job4j.set.Set;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.HashMap;
import java.util.List;

public class DuplicatesFinder extends SimpleFileVisitor {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        duplicatesVisitor.getDuplicates().forEach(System.out::println);
    }
}