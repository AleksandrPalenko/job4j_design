package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList() {
        this(10);
    }
    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        increaseArray();
        container[size++] = value;
    }

    public void increaseArray() {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T val = container[index];
        container[index] = newValue;
        return val;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T val = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - 1 - index);
        container[container.length - 1] = null;
        modCount++;
        size--;
        return val;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int position = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }

        };
    }
}