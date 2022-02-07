package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tdd.User;

import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.assertEquals;


public class GeneratorTest {

    @Ignore
    @Test
    public void whenGenerate() {
        User user = new User();
        Map<String, String> generate = new HashMap<>();
        generate.put("name", "subject");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String rsl = user.produce("I am a ${name}, Who are ${subject}? ", generate);
        assertEquals(rsl, expected);
    }

}