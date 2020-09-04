package com.drthisguy;


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

    public double calculateMortgage() {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR; //duplicated lines kept for re-usability purposes.
        short numberOfPayments =(short)(numberOfYears * MONTHS_PER_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );
    }

    public double calculateBalance(int numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR;
        short numberOfPayments =(short)(numberOfYears * MONTHS_PER_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public short getYears() {
        return numberOfYears;
    }
}
