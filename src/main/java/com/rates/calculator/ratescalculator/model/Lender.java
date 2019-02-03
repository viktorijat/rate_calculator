package com.rates.calculator.ratescalculator.model;

public class Lender {

    private String name;
    private Double rate;
    private Double available;

    public Lender(String name, Double rate, Double available) {
        this.name = name;
        this.rate = rate;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public Double getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", available=" + available +
                '}';
    }
}