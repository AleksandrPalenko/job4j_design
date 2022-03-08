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
        boolean ruleCars = (parkingForPassenger - countCars) >= 1;
        boolean ruleTruck = (parkingForFreight - countTrucks) >= 1;
        if (vehicle.getSize() == PassengerCar.SIZE && ruleCars) {
            vehicles.add(vehicle);
            countCars++;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE && ruleTruck) {
            vehicles.add(vehicle);
            countTrucks++;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE && parkingForFreight < 1
                && vehicle.getSize() <= (parkingForPassenger - countCars)) {
            vehicles.add(vehicle);
            countCars = countCars + vehicle.getSize();
            rsl = true;
        }
        return rsl;

    }
/*
- если машина имеет размер 1 и мест для легковых осталось больше 1,то добавлям
- если машина имеет размер > 1 и мест для грузовых осталось  больше 1,то добавляем
- если машина имеет размер > 1 и мест для грузовых нет,а для легковых мест хватает,для грузовой,то добавлям
 */
}
