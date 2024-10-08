package com.example.tobi.apiget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    private static final String SERVICE_KEY = "ZBlszxTEy0U6WKv71JOKeq3oHQAVxfhdZReKkmDxhBCjlacpsraAnv%2BXmepw8%2Bspv0Y5ujDTsvq%2BGfoWv1h2fA%3D%3D";

    public WeatherService( ) {
        this.restTemplate = new RestTemplate();
    }

    public String getWeatherData() {
        try {

            String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst" +
                    "?serviceKey=" + SERVICE_KEY +
                    "&numOfRows=10&pageNo=1&base_date=20241007&base_time=0600&nx=55&ny=127";

            URI uri = new URI(url);

            System.out.println("Requesting URL: " + uri);

            return restTemplate.getForObject(uri, String.class);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "Error in URI: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data: " + e.getMessage();
        }
    }

}
