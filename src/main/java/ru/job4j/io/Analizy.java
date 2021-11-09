package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String[]> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
           rsl = reader.lines().map(s -> s.split(" ")).collect(Collectors.toList());
        } catch (Exception a) {
            a.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            boolean status = false;
            for (String[] line: rsl) {
                if (!status && (line[0].equals("400") || line[0].equals("500"))) {
                    status = true;
                    writer.print(line[1] + ";");
                } else if (status && (line[0].equals("200") || line[0].equals("300"))) {
                    status = false;
                    writer.println(line[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        unavailable("server.csv", "target.csv");
    }
}
