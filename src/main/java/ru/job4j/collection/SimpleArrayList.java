package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    public static void main(String[] args) {
        List<String> string = new SimpleArrayList<>(10);
        string.add("big");
        string.add("big2");
        string.add("big3");

        System.out.println(string.remove(0));
        for (int i = 0; i < string.size(); i++) {
            System.out.println(string.size());
        }
    }

    private T[] container;

    private int size;

    private int modCount; //чтобы нарушился для итератора. И чтобы это не происходило ввели такой параметр.
    // Это счётчик количества изменений(добавлений, удалений элементов) чтобы до создания итератора и после было равное количество

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        container[index] = newValue;
        return newValue;
    }

    @Override
    public T remove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (size < container.length) {
            Objects.checkIndex(index, size);
            System.arraycopy(this.container, index + 1, this.container, index, numMoved);
        }
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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