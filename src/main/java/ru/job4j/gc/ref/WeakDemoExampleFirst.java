package ru.job4j.gc.ref;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Weak Reference
 * за'null'ение сильной ссылки приводит к удалению объекта
 * и мы его также уже не можем получить по слабой ссылке.
 */
public class WeakDemoExampleFirst {

    public static void main(String[] args) throws InterruptedException {
        example1();
    }

    private static void example1() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed");
            }
        };
        WeakReference<Object> weak = new WeakReference<>(object);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(weak.get());
    }
}
