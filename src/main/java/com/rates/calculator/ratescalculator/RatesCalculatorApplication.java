package com.rates.calculator.ratescalculator;

import com.rates.calculator.ratescalculator.model.Quote;
import com.rates.calculator.ratescalculator.processor.RateProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RatesCalculatorApplication {

    private static RateProcessor rateProcessor;
    private static Logger logger = LoggerFactory.getLogger(RatesCalculatorApplication.class);

    @Autowired
    public RatesCalculatorApplication(RateProcessor rateProcessor) {
        RatesCalculatorApplication.rateProcessor = rateProcessor;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RatesCalculatorApplication.class, args);
        Quote quote = rateProcessor.findRateForLoan(args);
        logger.info("\n" + quote.toString());
    }
}

