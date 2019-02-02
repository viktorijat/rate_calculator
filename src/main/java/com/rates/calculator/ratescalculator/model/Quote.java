package com.rates.calculator.ratescalculator.model;

public class Quote {

    private Double requestedAmount;
    private Double rate;
    private Double monthlyRepayment;
    private Double totalRepayment;

    public Quote(Double requestedAmount, Double rate, Double monthlyRepayment, Double totalRepayment) {
        this.requestedAmount = requestedAmount;
        this.rate = rate;
        this.monthlyRepayment = monthlyRepayment;
        this.totalRepayment = totalRepayment;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setMonthlyRepayment(Double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public void setTotalRepayment(Double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    @Override
    public String toString() {
        return "Requested Amount: " + requestedAmount + "\n" +
                "Rate: " + rate + "\n" +
                "Monthly Repayment: " + monthlyRepayment + "\n" +
                "Total Repayment: " + totalRepayment;
    }
}
