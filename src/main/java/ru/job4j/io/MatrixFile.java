package ru.job4j.io;

import java.io.FileOutputStream;

public class MatrixFile {
    public static void main(String[] args) {
                try (FileOutputStream out = new FileOutputStream("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\result.txt")) {
                    for (byte i = 1; i <= 9; i++) {
                        for (byte j = 1; j <= 9; j++) {
                            out.write(((i * j + " #").getBytes()));
                        }
                            out.write(System.lineSeparator().getBytes());
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


