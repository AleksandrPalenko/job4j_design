package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private int size;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int idx = indexFor(hash(key.hashCode()));
        if (table[idx] == null) {
            table[idx] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] tableNew = new MapEntry[capacity];
        for (MapEntry<K, V> tbl : tableNew) {
            if (tbl != null) {
                put(tbl.key, tbl.value);
            }
        }
        table = tableNew;
    }

    @Override
    public V get(K key) {
        int idx = indexFor(hash(key.hashCode()));
        return table[idx] != null && table[idx].key.equals(key) ? table[idx].value : null;
    }

    @Override
    public boolean remove(K key) {
        int idx = indexFor(hash(key.hashCode()));
        if (table[idx] != null && table[idx].key.equals(key)) {
            table[idx].value = null;
            count--;
            modCount++;
            return true;
        }
        return false;
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
                while (table[position] == null && position < table.length - 1) {
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

        public MapEntry() {

        }

        public K getKey() {
            return key;
        }
    }
}