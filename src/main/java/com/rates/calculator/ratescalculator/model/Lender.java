package com.rates.calculator.ratescalculator.model;

import java.util.Objects;

public class Lender {

    private String name;
    private Double rate;
    private Integer available;

    public Lender(String name, Double rate, Integer available) {
        this.name = name;
        this.rate = rate;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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
