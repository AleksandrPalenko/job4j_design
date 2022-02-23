package ru.job4j.parking.lsp;

public class PassengerCar implements Vehicles {

    private final int size = 1;

    public int getSize() {
        return 1;
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}
