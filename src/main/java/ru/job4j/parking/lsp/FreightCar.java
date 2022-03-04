package ru.job4j.parking.lsp;

public class FreightCar implements Vehicles {

    private int size;

    public FreightCar(int size) {
        validate(size);
        this.size = size;
    }

    private void validate(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size of truck Car must be greater then 1!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}
