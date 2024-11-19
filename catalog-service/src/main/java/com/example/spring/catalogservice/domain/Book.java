package com.example.spring.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Builder
public record Book (

        @Id
        Long id,
        @NotBlank(message = "The book ISBN must be defined.")  // ISBN이 비어 있지 않도록 검사
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",  // 10자리 또는 13자리 숫자만 허용
                message = "The ISBN format must be valid"  // 올바른 ISBN 형식이어야 한다는 메시지
        )
        String isbn,  // ISBN 필드 추가

        @NotBlank(message = "The book title must be defined.")  // 제목이 비어 있지 않도록 검사
        String title,

        @NotBlank(message = "The book author must be defined.")  // 저자가 비어 있지 않도록 검사
        String author,

        @NotNull(message = "The book price must be defined")  // 가격이 null이 아니어야 한다
        @Positive(
                message = "The book price must be greater than zero"  // 가격이 0보다 커야 한다
        )
        Double price,

        @CreatedDate
        @Column("created_at")
        Instant createdAt,
        @LastModifiedDate
        @Column("last_modified_at")
        Instant lastModifiedAt,


        @Version
        int version
) {

}
