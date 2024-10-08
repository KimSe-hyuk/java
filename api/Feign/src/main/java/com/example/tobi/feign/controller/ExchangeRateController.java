package com.example.tobi.feign.controller;

import com.example.tobi.feign.dto.ExchangeRateResponse;
import com.example.tobi.feign.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/exchange-rates")
    public ExchangeRateResponse getExchangeRates(
            @RequestParam String base,
            @RequestParam String symbols) {
        return exchangeRateService.getExchangeRates(base, symbols);
    }
}
