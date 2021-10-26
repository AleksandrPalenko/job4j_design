package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int idx = indexFor(hash(key.hashCode()));
        boolean rsl = table[idx] == null;
        if (capacity * LOAD_FACTOR <= count) {
            expand();
        }
        if (rsl) {
            table[idx] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] tmp = table;
        MapEntry<K, V>[] tableNew = new MapEntry[capacity];
        for (MapEntry<K, V> tbl : tmp) {
            if (tbl != null) {
                this.put(tbl.key, tbl.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int idx = indexFor(hash(key.hashCode()));
        return table[idx] != null && table[idx].key.equals(key) ? table[idx].value : null;
    }

    @Override
    public boolean remove(K key) {
        int idx = indexFor(hash(key.hashCode()));
        boolean rsl = table[idx] != null && table[idx].key.equals(key);
        if (rsl) {
            table[idx].value = null;
            count--;
            modCount++;
        }
            return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            int position;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (position < table.length - 1 && table[position] == null) {
                    position++;
                }
                return table[position] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[position++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}