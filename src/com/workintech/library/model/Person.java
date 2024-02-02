package com.workintech.library.model;

import java.util.Map;

public class Person { // Is subclassed by -Author - Librarian - Reader
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
