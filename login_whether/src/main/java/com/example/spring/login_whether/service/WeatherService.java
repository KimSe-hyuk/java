package com.example.spring.login_whether.service;

import com.example.spring.login_whether.client.WeatherClient;
import com.example.spring.login_whether.dto.WeatherRequestDTO;
import com.example.spring.login_whether.dto.weather.Item;
import com.example.spring.login_whether.dto.weather.WeatherResponse;
import com.example.spring.login_whether.dto.weather.WeatherResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final ObjectMapper objectMapper;
    @Value("${weather.api.key}")
    private String serviceKey;

    public static String getCurrentDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.now().format(formatter);
    }
    public static String getCurrentTimeAsString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        return LocalDateTime.now().format(timeFormatter);
    }
    public WeatherResponseDTO getWeatherData(int Usernx,int Userny){
        int numOfRows=10;
        int pageNo =1;
        String dataType = "JSON";
        String baseDate = getCurrentDateAsString();
        String baseTime  = getCurrentTimeAsString();
        int nx = Usernx;
        int ny = Userny;;
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
                WeatherResponse weatherResponse = objectMapper.readValue(weatherData, WeatherResponse.class);

            if(weatherResponse.getResponse().getBody()==null){
                return WeatherResponseDTO.builder().build();
            }
            List<Item> items = weatherResponse.getResponse().getBody().getItems().getItem();
            Item ptyItem = items.get(0);
            Item rehItem = items.get(1);
            Item rn1Item = items.get(2);
            Item t1hItem = items.get(3);
            Item vecItem = items.get(5);
            Item wsdItem = items.get(7);
            var ptyValue = ptyItem.getObsrValue();
            var rn1Value = rn1Item.getObsrValue();
            var vecValue = vecItem.getObsrValue();
            var wsdValue = wsdItem.getObsrValue();
            //t1hItem.setObsrValue(t1hItem.getObsrValue() + "℃");
            //t1hItem.setObsrValue(getPrecipitationDescription(ptyValue));
            //rehItem.setObsrValue(rehItem.getObsrValue() + "%");
            //rn1Item.setObsrValue(getRn1Description(rn1Value));
            //vecItem.setObsrValue(getVecDescription(Integer.parseInt(vecValue)));
            //wsdItem.setObsrValue(getWsdDescription(Float.parseFloat(wsdValue)));
            return WeatherResponseDTO.builder()
                    .temperature(t1hItem.getObsrValue() + "℃")
                    .humidity(rehItem.getObsrValue() + "%")
                    .oneHourPrecipitation(getRn1Description(rn1Value))
                    .PrecipitationType(getPrecipitationDescription(ptyValue))
                    .windDirection(getVecDescription(Integer.parseInt(vecValue)))
                    .windSpeed(getWsdDescription(Float.parseFloat(wsdValue)))
                    .build();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getWsdDescription(float wsdValue) {
        if(wsdValue<4) {
            return "바람이 약하다";
        } else if (wsdValue<9) {
            return "바람이 약간 강하다";
        } else if (wsdValue<14) {
            return "바람이 강하다";
        }else{
            return "바람이 매우 강하다";
        }
    }
    private String getVecDescription(int vecValue){
        if (vecValue < 0 || vecValue > 360) {
            return "방향알수 없음";
        }

        if (vecValue <= 45) {
            return "N-NE";
        } else if (vecValue <= 90) {
            return "NE-E";
        } else if (vecValue <= 135) {
            return "E-SE";
        } else if (vecValue <= 180) {
            return "SE-S";
        } else if (vecValue <= 225) {
            return "S-SW";
        } else if (vecValue <= 270) {
            return "SW-W";
        } else if (vecValue <= 315) {
            return "SW-NW"; // 225 to 315
        } else {
            return "S"; // 315 to 360
        }
    }
    private String getRn1Description(String description){
        if(description==null || description.isEmpty() || description.equals("0")){
            return "0mm";
        }
        float f = Float.parseFloat(description);
        if(f < 1.0f) return "1.0mm미만 ";
        else if(f >= 1.0f && f < 30.0f) return "1.0~29.0mm";
        else if(f >= 30.0f && f < 50.0f) return "30.0~50.0mm";
        else return "50.0mm이상";
    }
    private String getPrecipitationDescription(String ptyValue) {
        switch (ptyValue) {
            case "0":
                return "강수 없음";
            case "1":
                return "비";
            case "2":
                return "비 or 눈";
            case "3":
                return "눈";
            case "5":
                return "빗방울";
            case "6":
                return "빗방울눈날림";
            case "7":
                return "눈날림";
            default:
                return "알 수 없는 상태";
        }
    }
}
