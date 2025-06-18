package com.jvm.demo.jit;

/**
 * This example demonstrates JIT compilation effects by:
 * 1. Running a simple hot method multiple times
 * 2. Showing performance comparison before and after JIT compilation
 */
public class JITExample {
    private static final int WARMUP_ITERATIONS = 10000;
    private static final int MEASURE_ITERATIONS = 100000;

    public static void main(String[] args) {
        System.out.println("Starting JIT compilation example...");
        System.out.println("JVM version: " + System.getProperty("java.version"));
        System.out.println("JVM vendor: " + System.getProperty("java.vendor"));

        // Initial performance measurement (before JIT)
        System.out.println("\nInitial performance (before JIT):");
        long beforeTime = measurePerformance("Before JIT");

        // Warm up phase - this should trigger JIT compilation
        System.out.println("\nWarming up...");
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            hotMethod(i);
        }

        // Wait a bit to allow JIT compilation to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final performance measurement (after JIT)
        System.out.println("\nFinal performance (after JIT):");
        long afterTime = measurePerformance("After JIT");

        // Calculate and display speedup
        double speedup = (double) beforeTime / afterTime;
        System.out.printf("\nPerformance improvement: %.2fx faster after JIT compilation%n", speedup);

        // Additional verification of JIT compilation
        if (speedup > 5.0) {
            System.out.println("✓ Significant performance improvement detected - JIT compilation likely occurred");
        } else {
            System.out.println("⚠ Limited performance improvement - JIT compilation may not have triggered");
        }
    }

    private static long measurePerformance(String phase) {
        long startTime = System.nanoTime();

        // Run the hot method multiple times
        for (int i = 0; i < MEASURE_ITERATIONS; i++) {
            hotMethod(i);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.printf("%s - Total execution time: %d ms%n", phase, duration);
        return duration;
    }

    // Hot method that will be JIT compiled
    private static int hotMethod(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += i * i; // Simple but enough work to make JIT worthwhile
        }
        return result;
    }
}