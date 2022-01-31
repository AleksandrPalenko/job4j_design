package ru.job4j.gc.ref;

import java.util.concurrent.TimeUnit;

/**
 * Strong Reference
 * Во втором методе, мы создаем объекты вместе с вложенными.
 * Удаляя внешние объекты как в примере выше удаляются и вложенные,
 * не смотря на то что они не null.
 */
public class StrongExampleSecond {

    public static void main(String[] args) throws InterruptedException {
        example2();
    }

    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() {
                Object innerObject = new Object() {
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println("Remove inner object!");
                    }
                };
            };
            objects[i] = object;
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }
}
