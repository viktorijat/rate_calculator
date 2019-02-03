package com.rates.calculator.ratescalculator.loader;

import com.rates.calculator.ratescalculator.model.Lender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvRatesLoaderTest {

    @Autowired
    private InputRatesLoader inputRatesLoader;

    @Test
    public void shouldLoadLenderRates() throws IOException {

        List<Lender> lenders = inputRatesLoader.loadLenderRates("lenders.csv");

        assertThat(lenders.get(0).getName().trim(), is("Bob"));
        assertThat(lenders.get(0).getRate(), is(0.075));
        assertThat(lenders.get(0).getAvailable(), is(640.0));

        assertThat(lenders.get(lenders.size() - 1).getName().trim(), is("Angela"));
        assertThat(lenders.get(lenders.size() - 1).getRate(), is(0.071));
        assertThat(lenders.get(lenders.size() - 1).getAvailable(), is(60.0));

        System.out.println(lenders);
    }

}