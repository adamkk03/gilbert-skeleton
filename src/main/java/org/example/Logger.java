package org.example;

import java.util.Scanner;

public class Logger {

    private static Scanner scanner = new Scanner(System.in);

    public static void call(String className, String methodCall) {
        System.out.println("-> " + className + ": " + methodCall);
    }

    public static void ret(String type, String value) {
        if (value == null || value.isEmpty()) {
            System.out.println("<- " + type);
        } else {
            System.out.println("<- " + type + ": " + value);
        }
    }

    public static void retVoid() {
        System.out.println("<- void");
    }

    public static boolean ask(String question) {
        System.out.print("[?] " + question + " (I/N): ");
        String answer = scanner.nextLine().trim().toUpperCase();

        while (!answer.equals("I") && !answer.equals("N")) {
            System.out.print("Kérlek 'I' vagy 'N' betűvel válaszolj! (I/N): ");
            answer = scanner.nextLine().trim().toUpperCase();
        }

        return answer.equals("I");
    }
}
