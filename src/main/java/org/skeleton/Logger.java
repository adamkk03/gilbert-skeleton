package org.skeleton;

/**
 * Utility class for logging method calls and returns with indentation.
 * Useful for tracing execution flow in the prototype.
 */
public class Logger {

    /** Current indentation depth based on method call nesting. */
    private static int depth = 0;

    /**
     * Generates an indentation string based on current depth.
     * @return A string containing tab characters.
     */
    private static String getIndent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    /**
     * Logs a method call.
     * @param className The name of the class being called.
     * @param methodName The name of the method being called.
     */
    public static void call(String className, String methodName) {
        System.out.println(getIndent() + "-> " + className + ": " + methodName);
        depth++;
    }

    /**
     * Logs a method return with a value.
     * @param type The return type or description.
     * @param value The value being returned.
     */
    public static void ret(String type, String value) {
        depth--;
        System.out.println(getIndent() + "<- " + type + ": " + value);
    }

    /**
     * Logs a void method return.
     */
    public static void retVoid() {
        depth--;
        System.out.println(getIndent() + "<- void");
    }

    /**
     * Resets the indentation depth.
     * Should be called between tests to ensure correct formatting.
     */
    public static void reset() {
        depth = 0;
    }
}
