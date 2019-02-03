package com.rates.calculator.ratescalculator.calculator;

import com.rates.calculator.ratescalculator.model.Lender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FundsFinderTest {

    @Autowired
    private FundsFinder fundsFinder;

    @Test
    public void shouldFindLendersWithEnoughMoney() {
        List<Lender> lenders = getLenders();
        List<Lender> availableLenders = fundsFinder.findLendersWithEnoughMoney(lenders, 1000.0);
        assertThat(availableLenders.get(0).getName(), is("Ana"));
        assertThat(availableLenders.get(1).getName(), is("Tom"));
    }

    private List<Lender> getLenders() {
        return new ArrayList<>(
                Arrays.asList(
                        new Lender("Bob", 0.075, 640.0),
                        new Lender("Ana", 0.061, 200.0),
                        new Lender("Tom", 0.062, 800.0)
                )
        );
    }
}