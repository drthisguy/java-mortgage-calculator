package com.drthisguy;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    final static byte MONTHS_PER_YEAR = 12;
    final static byte PERCENT = 100;
    private double principal;
    private float annualInterest;
    private byte numberOfYears;

    public Mortgage(double principal, float annualInterest, byte numberOfYears) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setNumberOfYears(numberOfYears);
    }

    private void setPrincipal(double principal) {
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private void setNumberOfYears(byte numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public static double readInValues(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
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

    public void printMortgage() {
        double mortgage = calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage Payments: " + formattedMortgage);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= MONTHS_PER_YEAR * numberOfYears; month++) {
            double balance = calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private double calculateMortgage() {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR; //duplicated lines kept for re-usability purposes.
        short numberOfPayments =(short)(numberOfYears * MONTHS_PER_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );
    }

    private double calculateBalance(int numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR;
        short numberOfPayments =(short)(numberOfYears * MONTHS_PER_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
