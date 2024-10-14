package com.example.spring.login_whether.dto.weather;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherResponseDTO {
    private String temperature;
    private String humidity;
    private String PrecipitationType;
    private String windSpeed;
    private String oneHourPrecipitation;
    private String windDirection;
}
