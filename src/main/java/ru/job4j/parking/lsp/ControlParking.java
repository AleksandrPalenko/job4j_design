package ru.job4j.parking.lsp;


import java.util.List;

public class ControlParking implements Parking {

    private int parkingForPassenger;
    private int parkingForFreight;
    List<Vehicles> vehicles;

    public ControlParking(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public ControlParking(int parkingForPassenger, int parkingForFreight) {
        this.parkingForPassenger = parkingForPassenger;
        this.parkingForFreight = parkingForFreight;
    }

    @Override
    public boolean add(Vehicles vehicle) {
        boolean rsl = false;
        for (Vehicles vehicles1 : vehicles) {
            if (vehicles1.getSize() == PassengerCar.SIZE) {
                vehicles.add(vehicle);
                parkingForPassenger += 1;
                rsl = true;
            } else if (vehicles1.getSize() > PassengerCar.SIZE) {
                vehicles.add(vehicle);
                parkingForFreight += 1;
                rsl = true;
            }
        }
        return rsl;

    }

    public List<Vehicles> getVehicles() {
        return List.copyOf(vehicles);
    }
}
