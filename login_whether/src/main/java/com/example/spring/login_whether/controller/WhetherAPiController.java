package com.example.spring.login_whether.controller;

import com.example.spring.login_whether.dto.WeatherRequestDTO;
import com.example.spring.login_whether.dto.weather.WeatherResponse;
import com.example.spring.login_whether.dto.weather.WeatherResponseDTO;
import com.example.spring.login_whether.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WhetherAPiController {
    private final WeatherService weatherService;

    @PostMapping
    public WeatherResponseDTO whetherAPi(@RequestBody WeatherRequestDTO request) {
        return weatherService.getWeatherData(request.getNx(),request.getNy());
    }
}
