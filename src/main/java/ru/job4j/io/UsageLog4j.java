package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int countRoom = 2;
        char gender = 'M';
        boolean isHealthy = false;
        short height = 176;
        long numberOfFloorsInTheHouse = (long) 45941315156498D;
        float numberOfHair = 30000f;
        byte age = 27;
        double distanceToOfficeFrom = 25;
        LOG.debug(
                "Select -> int : {}, char : {}, boolean : {}, short : {}, long: {}, float : {}, byte : {}, double : {}",
                countRoom, age, gender, isHealthy, height, numberOfFloorsInTheHouse, numberOfHair,
                distanceToOfficeFrom);
    }
}