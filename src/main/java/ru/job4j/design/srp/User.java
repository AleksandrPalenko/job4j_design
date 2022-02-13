package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class User implements Report {

    private Store store;
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var users = store.findBy(filter);
        var lib = new GsonBuilder().create();
        return lib.toJson(users);
    }
}
