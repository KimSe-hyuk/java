package com.example.spring.springbootfeignclient.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherResponse {
    private Response response;
}
