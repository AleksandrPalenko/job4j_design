package ru.job4j.io;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "src/main/java/ru/job4j/data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "src/main/java/ru/job4j/data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTestWithException() {
        String path = "src/main/java/ru/job4j/data/pair_with_exception.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWithEmptyLine() {
        String path = "src/main/java/ru/job4j/data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }
}