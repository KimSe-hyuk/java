package com.example.spring.login_whether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LoginWhetherApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginWhetherApplication.class, args);
    }

}
