package com.example.orderesrevice;

import org.springframework.boot.SpringApplication;

public class TestOrdereSreviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
