package com.test7Optional;

public class Goddness {

    private String name;


    public Goddness(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goddness() {
    }

    @Override
    public String toString() {
        return "Goddness{" +
                "name='" + name + '\'' +
                '}';
    }
}
