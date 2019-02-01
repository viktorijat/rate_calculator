package com.rates.calculator.ratescalculator.comparators;

import com.rates.calculator.ratescalculator.model.Lender;
import java.util.Comparator;

public class RateComparator implements Comparator<Lender> {

        @Override
        public int compare(Lender o1, Lender o2) {
            return Double.compare(o1.getRate(), o2.getRate());
        }
}
