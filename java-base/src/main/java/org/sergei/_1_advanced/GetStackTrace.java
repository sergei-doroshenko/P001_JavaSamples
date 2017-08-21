package org.sergei._1_advanced;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetStackTrace {
    public static void main(String[] args) {
        new Stub().doSome();
    }

    static class Stub {
        public void doSome() {
            String st = generateThreadStackTrace(Thread.currentThread());
            System.out.println(st);
        }
    }

    public static String generateThreadStackTrace(Thread thread) {
        String newLine = System.getProperty("line.separator");
        final StackTraceElement[] stackTraceElements = thread.getStackTrace();
        return Stream.of(stackTraceElements)
                .map(e -> "at " + e.toString())
                .collect(Collectors.joining(newLine));
    }
}
