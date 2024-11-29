package com.example.hello.service;

import com.example.hello.client.OrderClient;
import com.example.hello.dto.OrderDTO;
import com.example.hello.dto.OrderRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderClient orderClient;
    public List<OrderDTO> getAllOrders() {
        return orderClient.getOrders();
    }
    public void insertOrder(OrderRequestDTO orderRequestDTO) {
        orderClient.createOrders(orderRequestDTO);
    }
}
