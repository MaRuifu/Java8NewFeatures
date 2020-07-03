package com.test7Optional;

public class Man {

    private Goddness goddness;


    public Man() {
    }


    public Goddness getGoddness() {
        return goddness;
    }

    public void setGoddness(Goddness goddness) {
        this.goddness = goddness;
    }

    @Override
    public String toString() {
        return "Man{" +
                "goddness=" + goddness +
                '}';
    }


}