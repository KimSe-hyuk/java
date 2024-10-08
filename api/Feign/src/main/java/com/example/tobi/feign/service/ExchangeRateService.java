package com.example.tobi.feign.service;

import com.example.tobi.feign.client.ExchangeRateClient;
import com.example.tobi.feign.dto.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    private final ExchangeRateClient exchangeRateClient;

    @Autowired
    public ExchangeRateService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public ExchangeRateResponse getExchangeRates(String baseCurrency, String targetCurrencies) {
        return exchangeRateClient.getLatestRates(baseCurrency, targetCurrencies);
    }
}
