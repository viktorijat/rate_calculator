package com.rates.calculator.ratescalculator.controller;

import com.rates.calculator.ratescalculator.model.Quote;
import com.rates.calculator.ratescalculator.repository.QuoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping
    public Flux<Quote> quotes() {
        return quoteRepository.findAll();
    }
}
