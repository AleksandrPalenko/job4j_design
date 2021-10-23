package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class SimpleMapTest {

    Map<String, String> map;

    @Test
    public void whenPutInTable() {
        map = new SimpleMap<>();
        map.put("firstCar", "test");
        map.put("secondCar", "testMore");
    }

    @Test
    public void whenPutItInAndDeleteIt() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("Toyota", 1));
        assertFalse(map.put("Toyota", 1));
        assertTrue(map.put("Lada", 3));
        assertTrue(map.remove("Lada"));
        assertTrue(map.remove("Toyota"));
        assertFalse(map.remove("BMW"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyMapThenNextThrowException() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test
    public void whenAddTwoEntriesButGetEmptyBucket() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertNull(map.get("three"));
    }

    @Test
    public void whenAddEntriesThenRemoveIt() {
        map = new SimpleMap<>();
        map.put("one", "1");
        assertTrue(map.remove("one"));
        assertNull(map.get("one"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenGetIteratorThenMustBeException() {
        Map<String, Integer> map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        map.put("first", 1);
        iterator.next();
    }

    @Test
    public void whenGetIteratorMultipleTimes() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("car", 1);
        map.put("bar", 2);
        Iterator<String> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("bar", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("car", iterator.next());
        assertFalse(iterator.hasNext());

    }
}
