package com.rates.calculator.ratescalculator.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RateCalculator {

    @Value("${periodOfTime}")
    private Double period;

    public Double calculateRate(Double sum, Double percentage, String method) {

        if (method.equals(RateMethod.FINANCE_FORMULAS.name())) {
            return financeFormulasCalculator(sum, percentage);
        } else if (method.equals(RateMethod.RATE_1728.name())) {
            return loanForm1728(sum, percentage);
        } else if (method.equals(RateMethod.WIKI_HOW.name())) {
            return loanWikiHow(sum, percentage);
        } else if (method.equals(RateMethod.ECONOMICS_BOOK.name())) {
            return economicsBookRateCalculator(sum, percentage);
        }
        return 0.0;
    }

    /*
        Rate calculation formula as suggested from a university economics book
     */
    private Double economicsBookRateCalculator(Double sum, Double percentage) {
        double up = sum * percentage + sum;
        return up / period;
    }

    /*
        Rate calculation formula as found on https://www.wikihow.com/Calculate-Mortgage-Payments
     */
    private Double loanWikiHow(Double sum, Double rate) {

        double up = rate * Math.pow((1 + rate), period);
        double down = Math.pow((1 + rate), period) - 1;
        double suma = sum * up / down;
        System.out.println("SUMA: " + suma);
        return suma;
    }

    /*
        Rate calculation formula as found on http://www.1728.org/loanform.htm
     */
    private Double loanForm1728(Double sum, Double percentage) {
        return (percentage + (percentage / (Math.pow((1 + percentage), period) - 1))) * sum;
    }

    /*
        Rate calculation formula as found on http://financeformulas.net/Loan_Payment_Formula.html
     */
    private Double financeFormulasCalculator(Double sum, Double percentage) {
        return (percentage * sum) / (1 - Math.pow((1 + percentage), -period));
    }
}