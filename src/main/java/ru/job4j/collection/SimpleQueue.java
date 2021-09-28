package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int sizeIn;
    int sizeOut;

    public T poll() {
        if (sizeIn != sizeOut) {
            out.push(in.pop());
            sizeIn--;
            sizeOut++;
        } else {
            in.push(out.pop());
        }
        return out.pop();
    }

    public void push(T value) {
        out.push(value);
    }
}
