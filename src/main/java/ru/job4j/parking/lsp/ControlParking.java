package ru.job4j.parking.lsp;


import java.util.ArrayList;
import java.util.List;

public class ControlParking implements Parking {

    private int parkingForPassenger;
    private int parkingForFreight;
    private int countTrucks = 0;
    private int countCars = 0;
    private List<Vehicles> vehicles = new ArrayList<>();


    public ControlParking(int parkingForPassenger, int parkingForFreight) {
        this.parkingForPassenger = parkingForPassenger;
        this.parkingForFreight = parkingForFreight;
    }

    @Override
    public boolean add(Vehicles vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() == PassengerCar.SIZE && parkingForPassenger > 1) {
            vehicles.add(vehicle);
            countCars++;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE && parkingForFreight > 1) {
            vehicles.add(vehicle);
            countTrucks++;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE && parkingForFreight < 1
                && vehicle.getSize() <= parkingForPassenger) {
            vehicles.add(vehicle);
            parkingForPassenger += vehicle.getSize();
            rsl = true;
        }
        return rsl;
    }

}
