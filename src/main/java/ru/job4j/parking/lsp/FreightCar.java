package ru.job4j.parking.lsp;

public class FreightCar implements Vehicles {

    private int size;

    public FreightCar() {
        if (PassengerCar.SIZE <= 2) {
            throw new IllegalArgumentException("Invalid size for FreightCar");
        }
    }

    public FreightCar(int freight) {
    }

    public int getSize() {
        return size;
    }

}
