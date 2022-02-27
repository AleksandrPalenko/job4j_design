package ru.job4j.parking.lsp;

import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class ControlParkingTest {

    @Ignore
    @Test
    public void whenParkingForCars() {
        ControlParking parking = new ControlParking(2, 1);
        Vehicles vehicles = new PassengerCar(2);
        assertTrue(parking.add(vehicles));
    }

}