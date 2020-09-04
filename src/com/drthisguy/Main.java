package com.drthisguy;

public class Main {

    public static void main(String[] args) {

        double principal = Console.readInValues("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readInValues("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readInValues("Period (Years): ", 1, 30);

        var calculator = new Mortgage(principal, annualInterest, years);

        var report =  new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
