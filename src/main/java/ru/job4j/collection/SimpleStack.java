package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleStack<T> {

    private final ForwardLinked<T> linked = new ForwardLinked<T>();

    public void addFirst(T value) {
        if (head == null) {
            head = new Node<>(value);
            size++;
        }
    }

    public T deleteFirst() {
        Node<T> tmp = head;
        if (head != null) {
            head = head.nextElement;
        } else {
            throw new NoSuchElementException();
        }
        return tmp.currentElement;
    }

    public T pop() {
        return deleteFirst();
    }

    public void push(T value) {
        addFirst(value);
    }

    private Node<T> head;
    private int size;

    public static class Node<T> {
        T currentElement;
        Node<T> nextElement;

        public Node(T value) {
            this.currentElement = value;
        }
    }
}