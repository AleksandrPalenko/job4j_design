package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.hash;

public class User {

    public static Map<User, Object> map = new HashMap<>();
    
    private String name;
    private int children;
    private static Calendar birthday = new GregorianCalendar();

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        User.birthday = birthday;
    }
    public static void main(String[] args) {
        birthday.set(1994, Calendar.OCTOBER, 13);
        User user1 = new User("Igor", 1, birthday);
        User user2 = new User("Nikolay", 0, birthday);
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (Map.Entry<User, Object> maps: map.entrySet()) {
            User data = maps.getKey();
            System.out.println(hash(data.hashCode()));
        }
    }                                                                                   
}
