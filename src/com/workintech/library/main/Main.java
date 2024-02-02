package com.workintech.library.main;

import com.workintech.library.model.Category;
import com.workintech.library.model.Book;
import com.workintech.library.model.Librarian;
import com.workintech.library.model.Library;
import com.workintech.library.model.Reader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Librarian theLibrarian = Librarian.getInstance();
        Library library = new Library();

        //Kitaplar oluşturuldu.
        Book book1 = new Book(1, "J.C. Grange",
                "Le Passager", 65.4, 30, "Kasım 2019", Category.MYSTERY);
        Book book2 = new Book(2, "Dan Brown",
                "Cehennem", 95, 30, "Aralık 2009", Category.MYSTERY);
        Book book3 = new Book(3, "Fyodor Dostoevsky",
                "Crime and Punishment", 55, 30, "Aralık 2009", Category.PSYCHOLOGICAL);
        Book book4 = new Book(4, "J. K. Rowling",
                "Harry Potter and the Deathly Hallows", 100, 30, "Aralık 2009", Category.FICTION);
        Book book5 = new Book(5, " J. R. R. Tolkien",
                "The Lord of the Rings", 100, 30, "Aralık 2009", Category.FICTION);
        Book book6 = new Book(6, "Charles Dickens",
                "A Tale of Two Cities", 100, 30, "Aralık 2009", Category.ROMANCE);
        Book book7 = new Book(7, "J.C. Grange",
                "Blood Red Rivers", 65.4, 30, "Kasım 2019", Category.MYSTERY);
        Book book8 = new Book(8, "İlber Ortaylı",
                "Türklerin Tarihi", 65.4, 30, "Kasım 2019", Category.HISTORY);
        Book book9 = new Book(9, "İlber Ortaylı",
                "Bir Ömür Nasıl Yaşanır?", 65.2, 35, "Şubat 2019", Category.HISTORY);

        //Üç okuyucu nesnesi oluşturuldu.
        Reader reader1 = new Reader("Eda", 123);
        Reader reader2 = new Reader("Bade", 456);
        Reader reader3 = new Reader("Duru", 789);

        //Oluşturulan okuyucular kütüphaneye eklendi.
        library.getReaders().add(reader1);
        library.getReaders().add(reader2);
        library.getReaders().add(reader3);
        System.out.println(library.getReaders());

        //Önceden oluşturulmuş kitap nesneleri (book1, book2, ...), kütüphaneye ID'leri ile eklendi.
        library.getBooks().put(book1.getBookID(), book1);
        library.getBooks().put(book2.getBookID(), book2);
        library.getBooks().put(book3.getBookID(), book3);
        library.getBooks().put(book4.getBookID(), book4);
        library.getBooks().put(book5.getBookID(), book5);
        library.getBooks().put(book6.getBookID(), book6);
        library.getBooks().put(book7.getBookID(), book7);
        library.getBooks().put(book8.getBookID(), book8);
        library.getBooks().put(book9.getBookID(), book9);
        System.out.println(library.getBooks());

        //reader1 (Eda) adlı okuyucuya ilk beş kitap ödünç olarak verildi.
        reader1.getBooks().put(book1.getBookID(), book1);
        reader1.getBooks().put(book2.getBookID(), book2);
        reader1.getBooks().put(book3.getBookID(), book3);
        reader1.getBooks().put(book4.getBookID(), book4);
        reader1.getBooks().put(book5.getBookID(), book5);
        //reader1.getBooks().put(book6.getBookID(), book6);
        //System.out.println(reader1.getBooks());
        Scanner scanner = new Scanner(System.in);
        if (theLibrarian.canLogin()) {
            while (true) {
                try {
                    System.out.println("**Yapmak istediğiniz işlemi seçin**");
                    System.out.println("1- Yeni kitap ekle:");
                    System.out.println("2- Kitap ödünç al:");
                    System.out.println("3- Yazarın kitaplarını listele:");
                    System.out.println("4- Kitabı adı ile ara:");
                    System.out.println("5- Yazar adı ile ara:");
                    System.out.println("6- ID ile ara:");
                    System.out.println("7- Kitap bilgilerini güncelle:");
                    System.out.println("8- Kitap kaydını sil:");
                    System.out.println("9- Kategoriye ait kitapları listele:");
                    System.out.println("10- Kitap iade et:");
                    System.out.println("11- Yeni üye ekle:");
                    System.out.println("12- Kitap ara:");
                    System.out.println("Sistemden çıkmak için 0'a basınız:");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        //Kullanıcı 0'a basana kadar seçeneklere devam et
                        case 0:
                            System.out.println("Çıkış yapılıyor...");
                            System.exit(0);
                        case 1:
                            library.addNewBook(); // Yeni kitap ekle
                            System.out.println(library.getBooks());
                            break;
                        case 2:
                            library.barrowBook(); // Kitap ödünç al
                            break;
                        case 3:
                            library.getAuthorAllBooks(); // Yazarın kitaplarını listele
                            break;
                        case 4:
                            library.getBookByName(); // Kitabı adı ile ara
                            break;
                        case 5:
                            library.getBookByAuthor(); // Yazar adı ile ara
                            break;
                        case 6:
                            library.getBookByID(); // ID ile ara
                            break;
                        case 7:
                            library.updateBook(); // Kitap bilgilerini güncelle
                            break;
                        case 8:
                            library.deleteBook(); // Kitap kaydını sil
                            System.out.println(library.getBooks());
                            break;
                        case 9:
                            library.getAllBooksInCategory(); // Kategoriye ait kitapları listele
                            break;
                        case 10:
                            library.bookToReturn(); // Kitap iade et
                            break;
                        case 11:
                            library.addMember(); // Yeni üye ekle
                            System.out.println(library.getReaders());
                            break;
                        case 12:
                            library.searchBook(); // Kitap ara
                            break;
                        default:
                            System.out.println("Geçersiz seçim. Lütfen tekrar deneyin!");
                    }
                } catch (Exception ex) {
                    System.out.println("**Lütfen bir tamsayı giriniz!**");
                    scanner.nextLine();
                }
            }
        }
    }
}