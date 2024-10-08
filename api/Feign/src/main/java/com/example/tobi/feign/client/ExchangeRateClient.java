package com.example.tobi.feign.client;

import com.example.tobi.feign.dto.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRateClient", url = "https://api.exchangeratesapi.io")
public interface ExchangeRateClient {

    @GetMapping("/latest")
    ExchangeRateResponse getLatestRates(
            @RequestParam("base") String baseCurrency,
            @RequestParam("symbols") String targetCurrencies
    );
}
