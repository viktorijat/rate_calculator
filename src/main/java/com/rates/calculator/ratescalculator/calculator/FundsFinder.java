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

        Comparator<Lender> c = Comparator.comparing(Lender::getRate).reversed().thenComparing(Lender::getAvailable).reversed();

        lenders.sort(c);

        for (Lender l : lenders) {
            System.out.println(l);
        }

        System.out.println("---------");
        //List<Lender> completeList = lenders.sort(Comparator.comparing(lender -> lender.getRate()));
        //return lenders;

        List<Lender> availableLenders = new ArrayList<>();
        Double a1 = amount;
        for (Lender l : lenders) {

            if (a1.equals(0.0)) {
                break;
            }
            if (Objects.equals(l.getAvailable(), a1)) {
                a1 -= l.getAvailable();
                availableLenders.add(l);
            }

            if (l.getAvailable() < a1) {
                a1 -= l.getAvailable();
                availableLenders.add(l);
            }
        }

        System.out.println("availableLenders: " + availableLenders);
        return availableLenders;
    }


}
