package ru.job4j.parking.lsp;

public class FreightCar implements Vehicles {

    private int size;

    public FreightCar(int size) {
        if (PassengerCar.SIZE >= 2) {
            this.size = size;
        }
    }

    public int getSize() {
        return 2;
    }

}
