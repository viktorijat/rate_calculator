package com.rates.calculator.ratescalculator.model;

import org.springframework.beans.factory.annotation.Value;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

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
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String language = resourceBundle.getString("locale.language");
        String country = resourceBundle.getString("locale.country");
        Locale locale = new Locale("en");
        System.out.println(locale);
        Locale uk = Locale.UK;

        Locale a = new Locale.Builder().setRegion("en").setLanguage("UK").build();

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        Currency usd = Currency.getInstance(Locale.UK);
        currencyFormatter.setCurrency(usd);

        String symbol = usd.getSymbol(locale);
        System.out.println("Currency symbol is = " + symbol);

        //Locale l1 =

        return "Requested Amount: " + currencyFormatter.format(requestedAmount) + "\n" +
                "Rate: " + rate + "\n" +
                "Monthly Repayment: " + currencyFormatter.format(monthlyRepayment) + "\n" +
                "Total Repayment: " + currencyFormatter.format(totalRepayment);
    }
}
