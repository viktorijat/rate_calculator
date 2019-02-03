package com.rates.calculator.ratescalculator.calculator;

import com.rates.calculator.ratescalculator.model.Lender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class FundsFinder {

    public List<Lender> findLendersWithEnoughMoney(List<Lender> lenders, Double amount) {

        lenders.sort(Comparator.comparing(Lender::getRate).reversed().thenComparing(Lender::getAvailable).reversed());

        List<Lender> availableLenders = new ArrayList<>();
        for (Lender lender : lenders) {

            if (amount.equals(0.0)) {
                break;
            }
            if (Objects.equals(lender.getAvailable(), amount)) {
                amount -= lender.getAvailable();
                availableLenders.add(lender);
            }

            if (lender.getAvailable() < amount) {
                amount -= lender.getAvailable();
                availableLenders.add(lender);
            }
        }
        return availableLenders;
    }
}