package ru.job4j.gc.ref;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Weak Reference
 * мы создаем объект вообще без сильных ссылки. При вызове сборщика мусора они все удаляются.
 */
public class WeakDemoExampleSecond {

    public static void main(String[] args) throws InterruptedException {
        example2();
    }

    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new WeakReference<Object>(new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Removed!");
                }
            }));
        }
        System.gc();
        TimeUnit.SECONDS.sleep(3);
    }
}
