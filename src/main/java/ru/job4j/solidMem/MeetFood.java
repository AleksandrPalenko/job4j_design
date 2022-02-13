package ru.job4j.solidMem;

import java.util.Date;

public class MeetFood extends Food{
    public MeetFood(String name, Date expiryDate, Date createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
