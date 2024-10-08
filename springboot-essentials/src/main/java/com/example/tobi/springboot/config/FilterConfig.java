package com.example.tobi.springboot.config;

import com.example.tobi.springboot.fillter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoggingFilter> registration = new FilterRegistrationBean<>();

        registration.setFilter(new LoggingFilter());
        // "/api/ 아래에만 필터를 적용한다.
        registration.addUrlPatterns("/api/*");
        registration.setOrder(1);

        return registration;
    }

}
