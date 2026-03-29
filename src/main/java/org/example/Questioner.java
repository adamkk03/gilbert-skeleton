package org.example;

import java.util.Scanner;

public class Questioner {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Feltesz egy eldöntendő kérdést a konzolon.
     *
     * @param question A kérdés szövege
     * @return true ha a válasz 'I' (Igen), false ha bármi más (pl. 'N').
     */
    public static boolean ask(String question) {
        System.out.print("[?] " + question + " (I/N): ");
        String answer = scanner.nextLine().trim().toUpperCase();
        return answer.equals("I");
    }
}
