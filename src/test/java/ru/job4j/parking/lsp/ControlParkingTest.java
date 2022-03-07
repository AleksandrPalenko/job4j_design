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
    public void whenTrueParkingCarsAndFreight() {
        ControlParking parking = new ControlParking(3, 2);
        Vehicles truck = new FreightCar(2);
        Vehicles car = new PassengerCar();
        Vehicles car2 = new PassengerCar();
        Vehicles car3 = new PassengerCar();
        assertTrue(parking.add(truck));
        assertTrue(parking.add(car));
        assertTrue(parking.add(car2));
        assertTrue(parking.add(car3));
    }

    @Test
    public void whenTrueParkingTruckAndFalseParkingCars() {
        ControlParking parking = new ControlParking(2, 2);
        Vehicles truck = new FreightCar(2);
        Vehicles truck2 = new FreightCar(2);
        assertTrue(parking.add(truck));
        assertTrue(parking.add(truck2));
    }

    @Test
    public void whenParkingCars() {
        ControlParking parking = new ControlParking(2, 6);
        Vehicles vehicles = new PassengerCar();
        Vehicles car = new PassengerCar();
        Vehicles truck = new FreightCar(6);
        assertTrue(parking.add(truck));
        assertTrue(parking.add(car));
        assertTrue(parking.add(vehicles));
    }

    @Test
    public void whenParkingTruckIsFalse() {
        ControlParking parking = new ControlParking(1, 0);
        Vehicles truck = new FreightCar(2);
        assertFalse(parking.add(truck));
    }
}