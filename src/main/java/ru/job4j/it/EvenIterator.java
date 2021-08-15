package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] ints;
    private int point = 0;

    public EvenIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return ints[point] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (ints.length == 0) {
            throw new NoSuchElementException();
        }
        if (hasNext()) {
            point++;
        }
        return ints[point];
    }

}
