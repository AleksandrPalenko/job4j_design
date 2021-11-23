package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            boolean status = false;
            for (String line : list) {
                if (!status && ("400".equals(line.split(" ")[0])
                        || ("500".equals(line.split(" ")[0])))) {
                    status = true;
                    writer.print(line.split(" ")[1] + ";");
                } else if (status && ("200".equals(line.split(" ")[0])
                        || ("300".equals(line.split(" ")[0])))) {
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
