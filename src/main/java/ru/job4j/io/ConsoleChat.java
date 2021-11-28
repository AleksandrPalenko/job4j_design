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
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            String textFromConsole = reader.readLine();
            Random rand = new Random();
            String answersFromBot = null;
            boolean chatActive = true;
            readPhrases();
            while (!textFromConsole.equals(OUT) && chatActive) {
                bufferedWriter.write(textFromConsole);
                if (textFromConsole.equals(STOP)) {
                    chatActive = false;
                }
                if (!textFromConsole.equals(STOP) && chatActive) {
                    if (!list.isEmpty()) {
                        answersFromBot = list.get(rand.nextInt(list.size() - 1));
                        bufferedWriter.write(answersFromBot);
                    }
                    System.out.println(answersFromBot);
                }
                    if (textFromConsole.equals(CONTINUE)) {
                        chatActive = true;
                    }
                    saveLog(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
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
        ConsoleChat cc = new ConsoleChat("user.txt", "botAnswer.txt");
        cc.run();
    }
}



