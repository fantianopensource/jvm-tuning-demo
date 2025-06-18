package com.jvm.demo.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * GC Example
 * Demonstrates different GC behaviors
 * Recommended JVM arguments:
 * -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.log
 */
public class GCExample {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting GC demonstration...");

        // Create objects to trigger GC
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // Allocate 1MB memory
            byte[] bytes = new byte[_1MB];
            list.add(bytes);

            // Print every 10MB
            if (i % 10 == 0) {
                System.out.println("Memory allocated: " + (i + 1) + "MB");
                Thread.sleep(100);
            }
        }

        // Print memory before GC
        System.out.println("\nBefore System.gc():");
        printMemoryInfo();

        // Clear list to trigger GC
        list.clear();
        System.out.println("\nCalling System.gc()...");
        System.gc();

        // Print memory after GC
        System.out.println("\nAfter System.gc():");
        printMemoryInfo();

        System.out.println("GC demonstration completed");
    }

    private static void printMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / _1MB;
        long freeMemory = runtime.freeMemory() / _1MB;
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total Memory: " + totalMemory + "MB");
        System.out.println("Free Memory: " + freeMemory + "MB");
        System.out.println("Used Memory: " + usedMemory + "MB");
    }
}