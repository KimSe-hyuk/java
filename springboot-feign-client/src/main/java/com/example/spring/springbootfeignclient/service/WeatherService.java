package com.example.spring.springbootfeignclient.service;

import com.example.spring.springbootfeignclient.client.WeatherClient;
import com.example.spring.springbootfeignclient.dto.weather.Item;
import com.example.spring.springbootfeignclient.dto.weather.Items;
import com.example.spring.springbootfeignclient.dto.weather.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final ObjectMapper objectMapper;
    @Value("${weather.api.key}")
    private String serviceKey;

    public WeatherResponse getWeatherData(){
        int numOfRows=10;
        int pageNo =1;
        String dataType = "JSON";
        String baseDate = "20241011";
        String baseTime  = "1605";
        int nx = 60;
        int ny = 127;
        try {
        String weatherData = weatherClient.getWeatherData(
                serviceKey,
                numOfRows,
                pageNo,
                dataType,
                baseDate,
                baseTime,
                nx,
                ny
        );


            return  objectMapper.readValue(weatherData, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
