package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


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
        Map<String, String> map = new SimpleMap<>();
        Assert.assertTrue(map.put("Toyota", "car"));
        Assert.assertFalse(map.put("Toyota", "car"));
        Assert.assertTrue(map.put("Lada", "car"));
        Assert.assertTrue(map.remove("Lada"));
        Assert.assertTrue(map.remove("Toyota"));
        Assert.assertFalse(map.remove("BMW"));
    }

    @Test
    public void whenPutInAndGetIt() {
        map = new SimpleMap<>();
        Assert.assertEquals("test", map.get("firstCar"));
        Assert.assertEquals("testMore", map.get("secondCar"));
    }

    @Test
    public void whenAssertNull() {
        Map<String, String> map = new SimpleMap<>();
        //map.put("firstCar", "test");
        Assert.assertNull(map.get(""));
    }

    @Test
    public void whenCheckIterator() {
        map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("Two", iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("One", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

}
