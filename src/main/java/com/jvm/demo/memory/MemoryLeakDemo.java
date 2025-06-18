package com.jvm.demo.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Memory Leak Demo
 * This class demonstrates common memory leak scenarios
 */
public class MemoryLeakDemo {
    private static List<byte[]> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting memory leak demonstration...");

        // Simulate memory leak
        while (true) {
            // Allocate 1MB memory each time
            byte[] bytes = new byte[1024 * 1024];
            list.add(bytes);

            System.out.println("Memory allocated: " + list.size() + "MB");

            // Pause every 100MB for observation
            if (list.size() % 100 == 0) {
                Thread.sleep(1000);
            }
        }
    }
}