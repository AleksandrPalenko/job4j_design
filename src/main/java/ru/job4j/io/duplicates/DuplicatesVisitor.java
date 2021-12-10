package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProp = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!files.containsKey(fileProp)) {
            List<Path> pathList = new ArrayList<>();
            pathList.add(file.toAbsolutePath());
            files.put(fileProp, pathList);
        } else {
            List<Path> duplicates = files.get(fileProp);
            duplicates.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getDuplicates() {
        List<Path> pathDuplicates = new ArrayList<>();
        files.values().stream()
                .filter(s -> s.size() > 1)
                .forEach(pathDuplicates::addAll);
        return pathDuplicates;
    }

}