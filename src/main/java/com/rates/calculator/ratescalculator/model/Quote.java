package com.rates.calculator.ratescalculator.model;

import org.springframework.beans.factory.annotation.Value;

import java.text.NumberFormat;
import java.util.Locale;

public class Quote {

    private Double requestedAmount;
    private Double rate;
    private Double monthlyRepayment;
    private Double totalRepayment;

    @Value("${numberOfDecimals}")
    private Integer numberOfDecimals;

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
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        return "Requested Amount: " + currencyFormatter.format(requestedAmount) + "\n" +
                "Rate: " + rate + "\n" +
                "Monthly Repayment: " + currencyFormatter.format(monthlyRepayment) + "\n" +
                "Total Repayment: " + currencyFormatter.format(totalRepayment);
    }
}
