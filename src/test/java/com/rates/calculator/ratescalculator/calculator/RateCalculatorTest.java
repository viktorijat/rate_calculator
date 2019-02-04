package com.rates.calculator.ratescalculator.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateCalculatorTest {

    @Autowired
    private RateCalculator rateCalculator;

    @Test
    public void shouldCalculateRateByMethod1() {

        Double rate = rateCalculator.calculateRate(500.0, 0.012, RateMethod.FINANCE_FORMULAS.name());
        assertThat(rate, is(17.18611378748253));
    }

    @Test
    public void shouldCalculateRateByMethod2() {

        Double rate = rateCalculator.calculateRate(500.0, 0.012, RateMethod.RATE_1728.name());
        assertThat(rate, is(17.186113787482533));
    }

    @Test
    public void shouldCalculateRateByMethod3() {

        Double rate = rateCalculator.calculateRate(500.0, 0.012, RateMethod.WIKI_HOW.name());
        assertThat(rate, is(17.186113787482537));
    }

    @Test
    public void shouldCalculateRateByMethod4() {

        Double rate = rateCalculator.calculateRate(500.0, 0.012, RateMethod.ECONOMICS_BOOK.name());
        assertThat(rate, is(14.055555555555555));
    }

    @Test
    public void shouldCalculateRateByMethod5() {

        Double rate = rateCalculator.calculateRate(500.0, 0.012, RateMethod.THE_CALCULATOR_SITE.name());
        assertThat(rate, is(1018.3185996419719));
    }
}