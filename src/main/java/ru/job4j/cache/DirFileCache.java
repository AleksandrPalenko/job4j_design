package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {
/*
Ключ - имя файла. Значение - текст из файла
 */
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /*
    String load(String key)
    читает файл и получает его содержимое в виде строки
     */
    @Override
    protected String load(String key) {
        String str = null;
        try {
            str = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}