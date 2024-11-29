package com.example.hello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private String isbn;
    private String quantity;
}
