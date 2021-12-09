package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car(false, 1, new Number("B104FFF-99"),
                new String[]{"Russia", "White"});

        /* Преобразуем объект car в json-строку. */
        final Gson gson = new GsonBuilder().create();
        /* Модифицируем json-строку */
        final String carToJson = gson.toJson(car);
        System.out.println(carToJson);
        final Car carMod = gson.fromJson(carToJson, Car.class);
        System.out.println(carMod);
    }
}