package com.rates.calculator.ratescalculator.model.formater;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class NumberFormatter {

    private static NumberFormatter instance;

    private NumberFormatter() {
    }

    public static NumberFormatter getInstance() {
        if (instance == null) {
            instance = new NumberFormatter();
        }
        return instance;
    }

    public NumberFormat getCurrencyFormatter() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String language = resourceBundle.getString("locale.language");
        String country = resourceBundle.getString("locale.country");
        Locale locale = new Locale(language, country);
        return NumberFormat.getCurrencyInstance(locale);
    }

    public NumberFormat getPercentageFormatter() {
        return NumberFormat.getPercentInstance();
    }

}
