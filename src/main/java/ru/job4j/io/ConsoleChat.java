package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> list = readPhrases();
        List<String> dialog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String textFromConsole = reader.readLine();
            int answersFromBot = (int) (Math.random() * list.size());
            boolean chatActive = true;
             while (!(OUT).equals(textFromConsole)) {
                dialog.add(textFromConsole);
                if (chatActive) {
                    String answer = list.get(answersFromBot);
                    System.out.println("Данные из файла " + answer);
                    dialog.add(answer);
                }
                if ((STOP).equals(textFromConsole)) {
                    chatActive = false;
                }
                if ((CONTINUE).equals(textFromConsole)) {
                    chatActive = true;
                }
                textFromConsole = reader.readLine();
                if ((OUT).equals(textFromConsole)) {
                    chatActive = false;
                    dialog.add(textFromConsole);
                }
            }
            saveLog(dialog);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            in.lines().forEach(rsl::add);
        } catch (IOException q) {
            q.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        if (log.isEmpty()) {
            throw new IllegalArgumentException("Invalid log");
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(this.path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(out::println);
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialog.txt", "botAnswer.txt");
        cc.run();
    }
}



