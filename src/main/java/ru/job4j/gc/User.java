package ru.job4j.gc;

public class User {

    private final int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{"
                + "id='"
                + id + '\''
                + '}';
    }
    
    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            new User(i, "Name");
        }
        GCDemo.info();
    }

}