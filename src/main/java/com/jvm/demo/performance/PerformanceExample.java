package com.jvm.demo.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This example demonstrates common performance optimization scenarios:
 * 1. String concatenation vs StringBuilder
 * 2. ArrayList pre-allocation
 * 3. Boxing/Unboxing overhead
 * 4. Loop optimization
 */
public class PerformanceExample {
    private static final int ITERATIONS = 100_000;

    public static void main(String[] args) {
        System.out.println("Starting performance examples...");

        // Example 1: String concatenation vs StringBuilder
        measureStringConcatenation();

        // Example 2: ArrayList pre-allocation
        measureArrayListPreAllocation();

        // Example 3: Boxing/Unboxing overhead
        measureBoxingOverhead();

        // Example 4: Loop optimization
        measureLoopOptimization();
    }

    private static void measureStringConcatenation() {
        System.out.println("\n1. String concatenation vs StringBuilder");

        // Using String concatenation
        long startTime = System.nanoTime();
        String result1 = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result1 += "test" + i;
        }
        long endTime = System.nanoTime();
        System.out.printf("String concatenation time: %d ms (length: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), result1.length());

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append("test").append(i);
        }
        String result2 = sb.toString();
        endTime = System.nanoTime();
        System.out.printf("StringBuilder time: %d ms (length: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), result2.length());
    }

    private static void measureArrayListPreAllocation() {
        System.out.println("\n2. ArrayList pre-allocation");

        // Without pre-allocation
        long startTime = System.nanoTime();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            list1.add(i);
        }
        long endTime = System.nanoTime();
        System.out.printf("ArrayList without pre-allocation time: %d ms%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime));

        // With pre-allocation
        startTime = System.nanoTime();
        List<Integer> list2 = new ArrayList<>(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            list2.add(i);
        }
        endTime = System.nanoTime();
        System.out.printf("ArrayList with pre-allocation time: %d ms%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }

    private static void measureBoxingOverhead() {
        System.out.println("\n3. Boxing/Unboxing overhead");

        // Using primitive int
        long startTime = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            sum1 += i;
        }
        long endTime = System.nanoTime();
        System.out.printf("Primitive int operations time: %d ms (sum: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), sum1);

        // Using Integer (boxing/unboxing)
        startTime = System.nanoTime();
        Integer sum2 = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            sum2 += i; // Autoboxing occurs here
        }
        endTime = System.nanoTime();
        System.out.printf("Integer boxing/unboxing operations time: %d ms (sum: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), sum2);
    }

    private static void measureLoopOptimization() {
        System.out.println("\n4. Loop optimization");

        // Traditional loop
        long startTime = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            sum1 += i;
        }
        long endTime = System.nanoTime();
        System.out.printf("Traditional loop time: %d ms (sum: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), sum1);

        // Optimized loop (unrolled)
        startTime = System.nanoTime();
        int sum2 = 0;
        for (int i = 0; i < ITERATIONS; i += 4) {
            sum2 += i;
            sum2 += i + 1;
            sum2 += i + 2;
            sum2 += i + 3;
        }
        endTime = System.nanoTime();
        System.out.printf("Unrolled loop time: %d ms (sum: %d)%n",
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime), sum2);
    }
}