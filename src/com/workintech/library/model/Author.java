package com.workintech.library.model;

import java.util.*;
public class Author extends Person {
    private Map<Integer, Book> books;

    public Author(String name) {
        super(name);
        books = new HashMap();
    }
    public Map<Integer, Book> getBooks() {
        return books;
    }
}
