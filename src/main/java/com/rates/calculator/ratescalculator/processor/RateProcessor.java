package com.rates.calculator.ratescalculator.processor;

import com.rates.calculator.ratescalculator.calculator.FundsFinder;
import com.rates.calculator.ratescalculator.calculator.RateCalculator;
import com.rates.calculator.ratescalculator.calculator.RateMethod;
import com.rates.calculator.ratescalculator.loader.InputRatesLoader;
import com.rates.calculator.ratescalculator.model.Lender;
import com.rates.calculator.ratescalculator.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class RateProcessor {

    @Value("${requestedAmount}")
    private Double requestedAmount;

    @Value("${lendersFile}")
    private String lendersFile;

    @Value("${periodOfTime}")
    private Integer periodOfTime;

    @Autowired
    private InputRatesLoader inputRatesLoader;

    @Autowired
    private FundsFinder fundsFinder;

    @Autowired
    private RateCalculator rateCalculator;

    public Quote findRateForLoan(String[] args) throws IOException {

        if (args.length == 2) {
            requestedAmount = Double.valueOf(args[0]);
            lendersFile = args[1];
        }
        List<Lender> lenders = inputRatesLoader.loadLenderRates(lendersFile);
        List<Lender> collectedLenders = fundsFinder.findLendersWithEnoughMoney(lenders, requestedAmount);
        Double monthly = collectMonthlyRates(collectedLenders).stream().mapToDouble(Double::doubleValue).sum();
        Double averagePercentage = calculatePercentage(collectedLenders);

        return new Quote(requestedAmount, averagePercentage, monthly, periodOfTime * monthly);
    }

    private Double calculatePercentage(List<Lender> collectedLenders) {
        return collectedLenders.stream().mapToDouble(Lender::getRate).average().orElse(0.0);
    }

    private List<Double> collectMonthlyRates(List<Lender> collectedLenders) {

        List<Double> monthly = new ArrayList<>();
        for (Lender lender : collectedLenders) {
            monthly.add(rateCalculator.calculateRate(lender.getAvailable(), lender.getRate(),
                    RateMethod.ECONOMICS_BOOK.name()));
        }
        return monthly;
    }
}
