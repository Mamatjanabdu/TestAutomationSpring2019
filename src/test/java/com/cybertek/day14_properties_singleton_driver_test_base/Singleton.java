package com.cybertek.day14_properties_singleton_driver_test_base;

public class Singleton {


    private Singleton() {
    }


    private static String string;

    public static String getInstance() {
        if (string == null) {
            System.out.println("GIVING VALUE NOW");
            string = "I have a value now";
        } else {
            System.out.println("ALREADY HAS VALUE");
        }

        return string;
    }
}
