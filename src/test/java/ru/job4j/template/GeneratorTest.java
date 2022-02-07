package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tdd.User;

import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class GeneratorTest {

    @Ignore
    @Test
    public void whenGenerate() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        generate.put("name", "subject");
        generate.put("Petr Arsentev", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertEquals(rsl, expected);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGenerateIncorrectResultWithKey() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        generate.put("userName", "subject");
        generate.put("Petr Arsentev", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertEquals(rsl, expected);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGenerateIncorrectResultWithValue() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        generate.put("name", "anySubject");
        generate.put("Petr Arsentev", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertEquals(rsl, expected);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGenerateIncorrectWithAmountValue() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        generate.put("name", "subject");
        generate.put("Petr Arsentev", "you");
        generate.put("Petr", "you");
        generate.put("Arsentev", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertEquals(rsl, expected);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGenerateIncorrectWithNullValue() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertNull(rsl);
    }
}