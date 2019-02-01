package com.rates.calculator.ratescalculator;

import com.rates.calculator.ratescalculator.calculator.RateCalculator;
import com.rates.calculator.ratescalculator.loader.CsvRatesLoader;
import com.rates.calculator.ratescalculator.loader.InputRatesLoader;
import com.rates.calculator.ratescalculator.model.Lender;
import java.io.IOException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatesCalculatorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RatesCalculatorApplication.class, args);


        InputRatesLoader inputRatesLoader = new CsvRatesLoader();
        List<Lender> lenders = inputRatesLoader.loadLenderRates();

        for (Lender l : lenders) {
            System.out.println(l);
        }

        System.out.println("---------");

        Integer requestedAmount = 1000;

        RateCalculator r = new RateCalculator();

        List<Lender> collectedLenders = r.findLendersWithEnoughMoney(lenders);

	}

}

