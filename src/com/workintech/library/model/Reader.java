package com.workintech.library.model;

import com.workintech.library.model.Book;
import com.workintech.library.model.Person;

import java.util.*;

public class Reader extends Person {
    private Map<Integer, Book> books;
    private double bill;
    private int memberNum; // Okuyucunun üye numarası

    public Reader(String name, int memberNum) {
        super(name);
        books = new LinkedHashMap<>();
        this.memberNum = memberNum;
    }

    public double getBill() { // Okuyucunun faturası
        bill = 0;
        for (Book book : books.values()) {
            bill += book.getPrice();
        }
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getMemberNum() {
        return memberNum;
    } // Okuyucunun üye numarası

    // Bir Okuyucu en fazla 5 kitap alabilir.
    public Map<Integer, Book> getBooks() { // Okuyucunun ödünç aldığı kitapların mapini döndürür, ancak kitap sayısı 5'i aşarsa son kitabı otomatik olarak listeden çıkarır.
        if (books.size() > 5) {
            System.out.println("Bir okuyucu 5'ten fazla kitap alamaz! ");
            List<Book> removeLast = new ArrayList<>(books.values());
            books.clear();
            removeLast.remove(removeLast.size() - 1);
            for (Book book : removeLast) {
                books.put(book.getBookID(), book);
            }
        }
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return memberNum == reader.memberNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNum);
    }
}