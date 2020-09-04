package com.drthisguy;


public class Mortgage {
    private final static byte MONTHS_PER_YEAR = 12;
    private final static byte PERCENT = 100;

    private final double principal;
    private final float annualInterest;
    private final byte numberOfYears;

    public Mortgage(double principal, float annualInterest, byte numberOfYears) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.numberOfYears = numberOfYears;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest(); //duplicated lines kept for re-usability purposes.
        short numberOfPayments = getNumberOfPayments();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_PER_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (numberOfYears * MONTHS_PER_YEAR);
    }
}
