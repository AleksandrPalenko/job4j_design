package ru.job4j.parking.lsp;

import org.junit.Test;


import static org.junit.Assert.*;

public class ControlParkingTest {

    @Test
    public void whenParkingForPassengersAndFreightCars() {
        ControlParking parking = new ControlParking(2, 0);
        Vehicles truck = new FreightCar(2);
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenFalseParkingFreightCarsOnPassengers() {
        ControlParking parking = new ControlParking(4, 0);
        Vehicles vehicles = new PassengerCar();
        Vehicles truck = new FreightCar(2);
        assertTrue(parking.add(vehicles));
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenTrueParkingCarsOnFreight() {
        ControlParking parking = new ControlParking(3, 2);
        Vehicles truck = new FreightCar(2);
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenTrueParkingCars() {
        ControlParking parking = new ControlParking(2, 0);
        Vehicles vehicles = new PassengerCar();
        assertTrue(parking.add(new FreightCar(2)));
    }

    @Test
    public void whenParkingCars() {
        ControlParking parking = new ControlParking(0, 2);
        Vehicles vehicles = new PassengerCar();
        Vehicles truck = new FreightCar(2);
        assertFalse(parking.add(vehicles));
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenParkingTruckIsFalse() {
        ControlParking parking = new ControlParking(1, 0);
        Vehicles vehicles = new PassengerCar();
        Vehicles truck = new FreightCar(2);
        assertFalse(parking.add(truck));
    }
}