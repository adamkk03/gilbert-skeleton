package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Szkeleton Teszt Menü ---");
            System.out.println("1. Hókotró takarít (Söprő fejjel)");
            System.out.println("2. Hókotró takarít (Hányó fejjel)");
            System.out.println("3. Hókotró jeget tör");
            // ... ide jöhet a többi 14 eset ...
            System.out.println("0. Kilépés");
            System.out.print("Válassz egy tesztesetet: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Kérlek számot adj meg!");
                continue;
            }

            switch (choice) {
                case 1:
                    runSoproFejTeszt();
                    break;
                case 2:
                    System.out.println("Ez a teszt még fejlesztés alatt...");
                    break;
                case 0:
                    System.out.println("Kilépés... Szép napot!");
                    break;
                default:
                    System.out.println("Érvénytelen választás!");
            }
        }
    }

    private static void runSoproFejTeszt() {
        System.out.println("\n--- 5.3.1: Hókotró takarít (Söprő fejjel) indítása ---");


        System.out.println("--- Teszt vége ---\n");
    }
}