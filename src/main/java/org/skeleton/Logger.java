package org.skeleton;

public class Logger {

    private static int depth = 0;

    private static String getIndent() {
        StringBuilder sb = new StringBuilder();
        sb.repeat("\t", Math.max(0, depth));
        return sb.toString();
    }

    public static void call(String className, String methodName) {
        System.out.println(getIndent() + "-> " + className + ": " + methodName);
        depth++;
    }

    public static void ret(String type, String value) {
        depth--;
        System.out.println(getIndent() + "<- " + type + ": " + value);
    }

    public static void retVoid() {
        depth--;
        System.out.println(getIndent() + "<- void");
    }

    // A tesztek végén érdemes meghívni, hogy a tabulátorok nullázódjanak
    public static void reset() {
        depth = 0;
    }
}
