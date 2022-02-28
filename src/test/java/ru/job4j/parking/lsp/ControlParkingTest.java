package ru.job4j.parking.lsp;

import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class ControlParkingTest {

    @Ignore
    @Test
    public void whenParkingForPassengersAndFreightCars() {
        ControlParking parking = new ControlParking(2, 1);
        Vehicles vehicles = new PassengerCar(2);
        assertTrue(parking.add(vehicles));
    }

    @Ignore
    @Test
    public void whenFalseParkingFreightCarsOnPassengers() {
        ControlParking parking = new ControlParking(4, 0);
        Vehicles vehicles = new PassengerCar(2);
        Vehicles truck = new FreightCar(1);
        assertTrue(parking.add(vehicles));
        assertTrue(parking.add(truck));
    }

    @Ignore
    @Test
    public void whenTrueParkingCarsOnFreight() {
        ControlParking parking = new ControlParking(3, 2);
        Vehicles truck = new FreightCar(3);
        assertTrue(parking.add(truck));
    }

    @Ignore
    @Test
    public void whenTrueParkingCars() {
        ControlParking parking = new ControlParking(1, 0);
        Vehicles vehicles = new PassengerCar(1);
        assertTrue(parking.add(vehicles));
        assertFalse(parking.add(new FreightCar(1)));
    }

    @Ignore
    @Test
    public void whenParkingCars() {
        ControlParking parking = new ControlParking(0, 2);
        Vehicles vehicles = new PassengerCar(2);
        Vehicles truck = new FreightCar(1);
        assertTrue(parking.add(vehicles));
        assertTrue(parking.add(truck));
    }
}