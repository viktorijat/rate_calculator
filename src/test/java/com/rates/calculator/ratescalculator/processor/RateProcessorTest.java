package com.rates.calculator.ratescalculator.processor;

import com.rates.calculator.ratescalculator.calculator.FundsFinder;
import com.rates.calculator.ratescalculator.calculator.RateCalculator;
import com.rates.calculator.ratescalculator.loader.InputRatesLoader;
import com.rates.calculator.ratescalculator.model.Lender;
import com.rates.calculator.ratescalculator.model.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateProcessorTest {

    @Mock
    private InputRatesLoader inputRatesLoader;

    @Mock
    private FundsFinder fundsFinder;

    @Mock
    private RateCalculator rateCalculator;

    @InjectMocks
    private RateProcessor rateProcessor;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(rateProcessor, "periodOfTime", 36);
        ReflectionTestUtils.setField(rateProcessor, "requestedAmount", 1000.0);
        ReflectionTestUtils.setField(rateProcessor, "lendersFile", "lenders.csv");
    }

    @Test
    public void findRateForLoanWithArguments() throws IOException {

        List<Lender> lenders = getLenders();
        when(inputRatesLoader.loadLenderRates(any())).thenReturn(lenders);
        when(rateCalculator.calculateRate(any(), any(), any())).thenReturn(30.0);
        when(fundsFinder.findLendersWithEnoughMoney(any(), any())).thenReturn(lenders);

        String[] sent = {"1000.0", "lenders.csv"};
        Quote received = rateProcessor.findRateForLoan(sent);
        assertThat(received.getRequestedAmount(), is(1000.0));
        assertThat(received.getRate(), is(0.066));
        assertThat(received.getMonthlyRepayment(), is(90.0));
        assertThat(received.getTotalRepayment(), is(3240.0));
    }

    @Test
    public void findRateForLoanWithoutArguments() throws IOException {

        List<Lender> lenders = getLenders();
        when(inputRatesLoader.loadLenderRates(any())).thenReturn(lenders);
        when(rateCalculator.calculateRate(any(), any(), any())).thenReturn(30.0);
        when(fundsFinder.findLendersWithEnoughMoney(any(), any())).thenReturn(lenders);

        String[] sent = {};
        Quote received = rateProcessor.findRateForLoan(sent);
        assertThat(received.getRequestedAmount(), is(1000.0));
        assertThat(received.getRate(), is(0.066));
        assertThat(received.getMonthlyRepayment(), is(90.0));
        assertThat(received.getTotalRepayment(), is(3240.0));
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