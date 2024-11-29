package com.example.hello.client;

import com.example.hello.dto.OrderDTO;
import com.example.hello.dto.OrderRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "exampleClient", url = "${feign-data.url}")
public interface OrderClient {

    //GET 요청 (데이터 조회)
    @GetMapping("/orders")
    List<OrderDTO> getOrders();

    //POST 데이터 요청 (데이터 생성)
    @PostMapping("/orders")
    List<OrderDTO> createOrders(@RequestBody OrderRequestDTO orderRequestDTO);

}
