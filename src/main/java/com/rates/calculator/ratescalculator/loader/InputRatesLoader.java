package com.rates.calculator.ratescalculator.loader;

import com.rates.calculator.ratescalculator.model.Lender;

import java.io.IOException;
import java.util.List;

public interface InputRatesLoader {

    List<Lender> loadLenderRates(String fileName) throws IOException;
}
