package com.drthisguy;

import java.text.NumberFormat;

public class MortgageReport {

    private final Mortgage calculator;
    private final NumberFormat currency;

    public MortgageReport(Mortgage calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (double balance: calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage Payments: " + formattedMortgage);
    }
}
