package org.skeleton;

import java.util.Scanner;

/**
 * Utility class to ask yes/no questions via the console.
 * Used for interactive decision making in the prototype.
 */
public class Questioner {

    /** Scanner for reading user input from the console. */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Asks a yes/no question on the console.
     *
     * @param question The text of the question.
     * @return true if the answer is 'I' (Igen), false otherwise.
     */
    public static boolean ask(String question) {
        System.out.print("[?] " + question + " (I/N): ");
        String answer = scanner.nextLine().trim().toUpperCase();
        return answer.equals("I");
    }
}
