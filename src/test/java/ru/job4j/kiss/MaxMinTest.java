package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMax() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer expected = 4;
        Integer rsl = maxMin.max(list, Integer::compareTo);
        assertEquals(rsl, expected);
    }

    @Test
    public void whenMin() {
        MaxMin maxMin = new MaxMin();
        List<Integer> value = new ArrayList<>();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        Integer expected = 1;
        Integer rsl = maxMin.min(value, Integer::compareTo);
        assertEquals(rsl, expected);
    }
}