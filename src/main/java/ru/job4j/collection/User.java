package ru.job4j.collection;

import java.util.*;

public class User {

    public static Map<User, Object> map = new HashMap<>();
    
    private String name;
    private int children;
    private static Calendar birthday = new GregorianCalendar(1975, Calendar.OCTOBER, 6);
    private static Date date = birthday.getTime();

    public User(String name, int children, Date date) {
        this.name = name;
        this.children = children;
        User.date = date;
    }
    public static void main(String[] args) {
        User user1 = new User("Nikolay", 0, date);
        User user2 = new User("Nikolay", 0, date);
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (Map.Entry<User, Object> maps: map.entrySet()) {
            User data = maps.getKey();
            System.out.println(maps);
            System.out.println(data.hashCode());
        }
    }
}
