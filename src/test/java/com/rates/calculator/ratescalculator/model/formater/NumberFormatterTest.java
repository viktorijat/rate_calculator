package com.rates.calculator.ratescalculator.model.formater;

import org.junit.Test;

import java.text.NumberFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberFormatterTest {


    @Test
    public void shouldGetCurrencyFormatter() {
        NumberFormatter numberFormatter = NumberFormatter.getInstance();
        NumberFormat numberFormat = numberFormatter.getCurrencyFormatter();
        assertThat(numberFormat.format(1000.0), is("£1,000.00"));
    }

    @Test
    public void shouldGetPercentageFormatter() {
        NumberFormatter numberFormatter = NumberFormatter.getInstance();
        NumberFormat numberFormat = numberFormatter.getPercentageFormatter();
        assertThat(numberFormat.format(0.07), is("7%"));
    }
}