package com.rates.calculator.ratescalculator.loader;

import com.rates.calculator.ratescalculator.model.Lender;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvRatesLoader implements InputRatesLoader {


    @Override
    public List<Lender> loadLenderRates() throws IOException {

        List<Lender> xmlLines = new BufferedReader(new FileReader("markets.csv"))
                .lines()
                .skip(1) //Skips the first n lines, in this case 1
                .map(s -> {
                    String[] values = s.split(",");
                    return new Lender(values[0], Double.valueOf(values[1]), Integer.parseInt(values[2]));
                })
                .collect(Collectors.toList());
        return xmlLines;
    }
}
