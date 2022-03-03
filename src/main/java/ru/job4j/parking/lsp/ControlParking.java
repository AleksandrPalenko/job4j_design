package ru.job4j.parking.lsp;


import java.util.List;

public class ControlParking implements Parking {

    private int parkingForPassenger;
    private int parkingForFreight;
    private int countTrucks = 0;
    private int countCars = 0;
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
        if (vehicle.getSize() == PassengerCar.SIZE) {
            if (countCars < parkingForPassenger) {
                vehicles.add(vehicle);
                countCars++;
            }
        } else if (vehicle.getSize() > PassengerCar.SIZE) {
            vehicles.add(vehicle);
            if (parkingForFreight > PassengerCar.SIZE) {
                vehicles.add(vehicle);
                countTrucks++;
            }
        } else if (vehicle.getSize() <= (parkingForPassenger - countCars)) {
            if (parkingForFreight < 1 && parkingForPassenger > 1) {
                vehicles.add(vehicle);
                countCars = countCars + vehicle.getSize();
            }
        }
        return true;
    }

}
