package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    int size;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        }else {
            node.next = head;
        }
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        head = tmp.next;
        tmp.next = null;
        return tmp.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> tmp = head.next;
        head.next = null;
        while (tmp != null) {
            Node<T> next = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = next;
        }
        return true;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> pref;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}