package ru.job4j.ood.isp.menu;

public class TODOApp implements MenuPrinter {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Override
    public void print(Menu menu) {
        SimpleMenu simpleMenu = new SimpleMenu();
        simpleMenu.add(Menu.ROOT, "Задача", STUB_ACTION);
        simpleMenu.add("Задача", " Задача", STUB_ACTION);
        simpleMenu.add(" Задача", " Задача", STUB_ACTION);
        simpleMenu.add(" Задача", " Задача", STUB_ACTION);
        simpleMenu.add("Задача", " Задача", STUB_ACTION);
    }
}

