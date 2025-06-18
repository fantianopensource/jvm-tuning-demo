package com.jvm.demo.classloader;

/**
 * Class Loading Mechanism Example
 */
public class ClassLoaderExample {
    public static void main(String[] args) {
        System.out.println("Starting class loading mechanism demonstration...");

        // Print class loader hierarchy
        ClassLoader loader = ClassLoaderExample.class.getClassLoader();
        System.out.println("Current class loader: " + loader);

        // Print parent class loaders
        while (loader != null) {
            loader = loader.getParent();
            System.out.println("Parent class loader: " + loader);
        }

        // Print system class loader
        System.out.println("System class loader: " + ClassLoader.getSystemClassLoader());

        // Print extension class loader
        System.out.println("Extension class loader: " + ClassLoader.getSystemClassLoader().getParent());

        System.out.println("Class loading mechanism demonstration completed");
    }
}