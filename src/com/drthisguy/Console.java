package com.drthisguy;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    //overloaded method. not actually used.
    public static double readInValues(String prompt) {
        return scanner.nextDouble();
    }

    public static double readInValues(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter some value between "+ min + " and " + max);
        }
        return value;
    }
}
