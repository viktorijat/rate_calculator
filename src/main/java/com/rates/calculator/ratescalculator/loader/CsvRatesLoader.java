package com.rates.calculator.ratescalculator.loader;

import com.rates.calculator.ratescalculator.model.Lender;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvRatesLoader implements InputRatesLoader {

    private static final String SPLITTER = ",";

    @Override
    public List<Lender> loadLenderRates(String fileName) throws IOException {

        return new BufferedReader(new FileReader(fileName))
                .lines()
                .skip(1)
                .map(s -> {
                    String[] values = s.split(SPLITTER);
                    return new Lender(values[0], Double.valueOf(values[1]), Double.valueOf(values[2]));
                })
                .collect(Collectors.toList());
    }
}
