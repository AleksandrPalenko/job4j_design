package ru.job4j.gc.ref;

import java.util.concurrent.TimeUnit;

/**
 * Strong Reference
 * мы создаем объект и далее их за'null'яем.
 * Вызываем сборщик мусора и ждем некоторое время.
 * Объекты удаляются, т.к. ссылки на них null
 */
public class StrongDemoExampleFirst {

    public static void main(String[] args) throws InterruptedException {
    example1();
}

    private static void example1() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            };
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

}
