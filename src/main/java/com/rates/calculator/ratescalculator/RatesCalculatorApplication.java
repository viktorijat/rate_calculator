package com.rates.calculator.ratescalculator;

import com.rates.calculator.ratescalculator.processor.RateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RatesCalculatorApplication {

    private static RateProcessor rateProcessor;

    @Autowired
    public RatesCalculatorApplication(RateProcessor rateProcessor) {
        RatesCalculatorApplication.rateProcessor = rateProcessor;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RatesCalculatorApplication.class, args);
        rateProcessor.findRateForLoan(args);
    }
}