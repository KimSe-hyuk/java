//package com.example.spring.catalogservice.domain;
//
//import java.util.Set;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class BookValidationTests {
//    private static Validator validator;
//
//    @BeforeAll
//    static void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @Test
//    void whenAllFieldCorrectThenValidationSucceeds() {
//        // 유효한 ISBN 값을 제공하여 유효성 검사를 합니다.
//        var book = Book.builder().isbn("1234567890").title("Title").author("Author").price(12.90).build();
//
//        Set<ConstraintViolation<Book>> violations = validator.validate(book);
//        assertThat(violations).isEmpty(); // 위반이 없어야 합니다.
//    }
//
//    @Test
//    void whenAllFieldIncorrectThenValidationFails() {
//        // 유효하지 않은 ISBN 값을 제공하여 유효성 검사를 합니다.
//        var book = Book.builder().isbn("1234567891").title("Title").author("Author").price(12.90).build();
//
//        Set<ConstraintViolation<Book>> violations = validator.validate(book);
//
//        // 검증 실패가 1건이어야 합니다.
//        assertThat(violations).hasSize(1);
//
//        // 검증 오류 메시지가 정확히 일치해야 합니다.
//        assertThat(violations.iterator().next().getMessage())
//                .isEqualTo("The ISBN format must be valid");  // 마침표 없이
//    }
//}
