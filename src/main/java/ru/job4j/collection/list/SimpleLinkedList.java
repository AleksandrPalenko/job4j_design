package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size = 0;

    public static class Node<E> {
        E currentElement;
        Node<E> nextElement;

        public Node(E value) {
            this.currentElement = value;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }
    }

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value);
            size++;
            return;
        }
        Node<E> node = head;
        while (node.nextElement != null) {
            node = node.nextElement;
        }
        node.nextElement = new Node<>(value);

        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        int currentIndex = 0;
        Node<E> tmp = head;
        while (tmp != null) {
            if (currentIndex == index) {
                return tmp.getCurrentElement();
            } else {
                tmp = tmp.getNextElement();
                currentIndex++;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int modCount;
            int position;
            final int expectedModCount = modCount;
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E currentElement = current.currentElement;
                current = current.nextElement;
                position++;
                return currentElement;
            }
        };
    }
}