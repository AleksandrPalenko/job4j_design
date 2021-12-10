package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final boolean isNew;
    private final int age;
    private final Number number;
    private final String[] statuses;

    public Car(boolean isNew, int age, Number number, String[] statuses) {
        this.isNew = isNew;
        this.age = age;
        this.number = number;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{"
                + "isNew="
                + isNew + ", age="
                + age + ", car="
                + number + ", statuses="
                + Arrays.toString(statuses)
                + '}';
    }

    public boolean isNew() {
        return isNew;
    }

    public int getAge() {
        return age;
    }

    public Number getNumber() {
        return number;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonCar = new JSONObject("{\"number\":\"B104FFF-99\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Lada");
        list.add("Automatic");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Car car = new Car(false, 2, new Number("104"),
                new String[]{"Russia", "Blue"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isNew", car.isNew());
        jsonObject.put("age", car.getAge());
        jsonObject.put("gosNumber", jsonCar);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}