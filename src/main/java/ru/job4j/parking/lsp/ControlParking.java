package ru.job4j.parking.lsp;


import java.util.List;

public class ControlParking implements Parking {

    private final int parkingForPassenger;
    private final int parkingForFreight;
    List<Vehicles> vehicles;

    public ControlParking(int parkingForPassenger, int parkingForFreight) {
        this.parkingForPassenger = parkingForPassenger;
        this.parkingForFreight = parkingForFreight;
    }

    @Override
    public boolean add(Vehicles vehicle) {
        return false;
    }

    public List<Vehicles> getVehicles() {
        return List.copyOf(vehicles);
    }
}
