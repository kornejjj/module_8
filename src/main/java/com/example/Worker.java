package com.example;

public class Worker {
    private String type;  // Youngest or Eldest
    private String name;
    private String birthday;

    public Worker(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return type + " Worker Name: " + name + ", Birthday: " + birthday;
    }
}

