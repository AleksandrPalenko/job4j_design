package ru.job4j.ood.isp;

public interface Mobile {
    /*
    Здесь необходимо вынести метод void photograph() под другой интерфейс, так как не все телефоны имеют камеру.
     */
    void call();
    void writeLetter();
    void photograph();
}

