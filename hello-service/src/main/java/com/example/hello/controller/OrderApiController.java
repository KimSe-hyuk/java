package com.example.hello.controller;

import com.example.hello.dto.OrderDTO;
import com.example.hello.dto.OrderRequestDTO;
import com.example.hello.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderService orderService;
    @GetMapping
    public List<OrderDTO> hello() {
        return orderService.getAllOrders();
    }
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO order) {

        try {
            orderService.insertOrder(order); // 주문 삽입
            return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
        } catch (Exception e) {
            // 예외 발생 시 400 Bad Request 상태와 함께 오류 메시지 반환
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating order");
        }
    }

}
