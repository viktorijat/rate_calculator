package com.rates.calculator.ratescalculator.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lender lender = (Lender) o;
        return Objects.equals(name, lender.name) &&
                Objects.equals(rate, lender.rate) &&
                Objects.equals(available, lender.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, available);
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
