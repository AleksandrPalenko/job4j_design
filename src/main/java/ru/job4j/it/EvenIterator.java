package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] ints;
    private int count = 0;

    public EvenIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        if (count == ints.length) {
            return false;
        }
        for (int i = count; i < ints.length; i++) {
            if (isEven(ints[i])) {
                return true;
            }
            count++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return ints[count++];
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
