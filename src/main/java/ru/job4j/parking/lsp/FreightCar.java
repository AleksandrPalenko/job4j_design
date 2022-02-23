package ru.job4j.parking.lsp;

public class FreightCar implements Vehicles {

    private final int size = 2;

    public int getSize() {
        return 2;
    }

    @Override
    public boolean add(Car car) {

        return false;
    }
}
