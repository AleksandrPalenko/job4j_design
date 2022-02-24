package ru.job4j.parking.lsp;

import org.junit.Ignore;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlParkingTest {

    @Ignore
    @Test
    public void whenParkingForPassengersCars() {
        Parking parking = new ControlParking(5, 0);
        Vehicles vehicles = new PassengerCar();
        parking.add(vehicles);
        assertThat(vehicles.getSize(), is(5));
    }

}