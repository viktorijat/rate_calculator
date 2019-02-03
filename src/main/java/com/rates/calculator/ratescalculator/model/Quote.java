package com.rates.calculator.ratescalculator.model;

import com.rates.calculator.ratescalculator.model.formater.NumberFormatter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

@Document
public class Quote {

    @Id
    private String id;

    @NumberFormat(pattern = "#,###,###,###.##")
    private Double requestedAmount;

    private Double rate;

    @NumberFormat(pattern = "#,###,###,###.##")
    private Double monthlyRepayment;

    @NumberFormat(pattern = "#,###,###,###.##")
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

    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public Double getRate() {
        return rate;
    }

    public Double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public Double getTotalRepayment() {
        return totalRepayment;
    }

    @Override
    public String toString() {


        NumberFormatter numberFormat = NumberFormatter.getInstance();

        return "Requested Amount: " + numberFormat.getCurrencyFormatter().format(requestedAmount) + "\n" +
                "Rate: " + numberFormat.getPercentageFormatter().format(rate) + "\n" +
                "Monthly Repayment: " + numberFormat.getCurrencyFormatter().format(monthlyRepayment) + "\n" +
                "Total Repayment: " + numberFormat.getCurrencyFormatter().format(totalRepayment);
    }
}