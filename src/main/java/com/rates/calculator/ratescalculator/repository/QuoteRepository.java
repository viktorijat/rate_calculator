package com.rates.calculator.ratescalculator.repository;

import com.rates.calculator.ratescalculator.model.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

    Flux<Quote> findAll();
}
