package com.workintech.library.model;

import java.util.Objects;

public class Book {
    private int bookID;
    private String author;
    private String name;
    private double price;
    private int edition; // baskı numarası
    private String dateOfPurchase; // satın alma tarihi
    private Category category;

    public Book(int bookID, String author, String name, double price, int edition, String dateOfPurchase, Category category) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.category = category;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int book_ID) {
        this.bookID = book_ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "-" +
                "book_ID=" + bookID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", edition=" + edition +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", category='" + category + '\'' +
                '-';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }
}
