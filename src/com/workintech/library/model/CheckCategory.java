package com.workintech.library.model;

import java.util.Scanner;

public class CheckCategory {
    public static Category checkCategory() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("FICTION için 1'e basınız,");
        System.out.println("MYSTERY için 2'ye basınız,");
        System.out.println("SCIENCE_FICTION için 3'e basınız,");
        System.out.println("ROMANCE için 4'e basınız,");
        System.out.println("HISTORY için 5'e basınız,");
        System.out.println("PSYCHOLOGICAL için 6'ya basınız,");


        int choice = scanner.nextInt();
        Category category = null;

        switch (choice) {
            case 1:
                category = Category.FICTION;
                break;
            case 2:
                category = Category.MYSTERY;
                break;
            case 3:
                category = Category.SCIENCE_FICTION;
                break;
            case 4:
                category = Category.ROMANCE;
                break;
            case 5:
                category = Category.HISTORY;
                break;
            case 6:
                category = Category.PSYCHOLOGICAL;
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
        }
        return category;
    }
}