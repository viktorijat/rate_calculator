package com.rates.calculator.ratescalculator.controller;

import com.rates.calculator.ratescalculator.model.Quote;
import com.rates.calculator.ratescalculator.repository.QuoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteControllerTest {

    @Mock
    QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteController quoteController;

    @Test
    public void shouldGetQuotes() {

        Quote quote = new Quote(1.00, 0.02, 3.00, 4.00);
        when(quoteRepository.findAll()).thenReturn(Flux.just(quote));
        List<Quote> received = quoteController.quotes().collectList().block();

        assertThat(received.get(0).getRequestedAmount(), is(1.00));
        assertThat(received.get(0).getRate(), is(0.02));
        assertThat(received.get(0).getMonthlyRepayment(), is(3.00));
        assertThat(received.get(0).getTotalRepayment(), is(4.00));
    }
}