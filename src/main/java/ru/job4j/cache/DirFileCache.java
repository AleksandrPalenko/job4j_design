package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
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
        StringBuilder str =  new StringBuilder();
        SoftReference<StringBuilder> softStr = new SoftReference<>(str);
        String line = null;
        try (BufferedReader in = new BufferedReader(new FileReader(key))) {
            while ((line = in.readLine()) != null) {
                line.lines().forEach(str::append);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return softStr.toString();
    }

}