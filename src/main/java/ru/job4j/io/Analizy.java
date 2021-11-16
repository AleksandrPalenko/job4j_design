package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            boolean status = false;
            for (String line : lines) {
                if (!status && ("400".equals(line.split(" ")[0])
                        || ("500".equals(line.split(" ")[0]) && !status))) {
                    status = true;
                    writer.print(line.split(" ")[1] + ";");
                } else if (status && ("200".equals(line.split(" ")[0])
                        || ("300".equals(line.split(" ")[0]) && status))) {
                    status = false;
                    writer.println(line.split(" ")[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.csv", "target.csv");
    }
}
