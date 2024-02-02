package com.workintech.library.model;

import java.util.Scanner;

// Kütühaneci
public class Librarian extends Person implements Loginable {
    private String password;
    private static Librarian librarian;

    private Librarian(String name) {

        super(name.toLowerCase());
        this.password = name.toLowerCase().trim() + "123";
    }

    public synchronized static Librarian getInstance() {

        if (librarian == null) {
            librarian = new Librarian("Ali");
        }
        return librarian;
    }

    public String getPassword() {
        return password;
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public boolean canLogin() {
        System.out.println("Lütfen kullanıcı adınızı girin: ");
        String nameInput = getInput();
        System.out.println("Lütfen şifrenizi girin: ");
        String passwordInput = getInput();
        while (true) {
            if (getName().equals(nameInput) && getPassword().equals(passwordInput)) {
                System.out.println("**Hesabınıza giriş yapıldı**");
                return true;
            } else {
                System.out.println("Yanlış şifre veya isim girdiniz yeniden deneyiniz!");
                break;
            }
        }
        return false;
    }
}