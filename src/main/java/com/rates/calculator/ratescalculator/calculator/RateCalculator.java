package com.rates.calculator.ratescalculator.calculator;

import com.rates.calculator.ratescalculator.model.Lender;
import java.util.Comparator;
import java.util.List;

public class RateCalculator {

    public List<Lender> findLendersWithEnoughMoney(List<Lender> lenders, Double amount) {

        Comparator<Lender> c = Comparator.comparing(Lender::getRate).reversed().thenComparing(Lender::getAvailable).reversed();

        lenders.sort(c);

        for (Lender l : lenders) {
            System.out.println(l);
        }

        System.out.println("---------");
        //List<Lender> completeList = lenders.sort(Comparator.comparing(lender -> lender.getRate()));
        return lenders;
    }


}
