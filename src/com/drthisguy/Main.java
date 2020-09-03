package com.drthisguy;

public class Main {
    public static void main(String[] args) {

        double principal = Mortgage.readInValues("Principal: ", 1000, 1_000_000);
        float annualInterest = (float)Mortgage.readInValues("Annual Interest Rate: ", 1, 30);
        byte years = (byte)Mortgage.readInValues("Period (Years): ", 1, 30 );

        var mortgage = new Mortgage(principal, annualInterest, years);

        mortgage.printMortgage();
        mortgage.printPaymentSchedule();
    }
}
