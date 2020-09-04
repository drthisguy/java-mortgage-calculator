package com.drthisguy;

import java.text.NumberFormat;

public class MortgageReport {

    private Mortgage calculator;

    public MortgageReport(Mortgage calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= Mortgage.MONTHS_PER_YEAR * calculator.getYears(); month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {

        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage Payments: " + formattedMortgage);
    }
}
