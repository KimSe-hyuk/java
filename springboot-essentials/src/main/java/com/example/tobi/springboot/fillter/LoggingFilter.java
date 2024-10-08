package com.example.tobi.springboot.fillter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //생성자 같은 역할 필터 초기화 ( 필요시) 없어도 됨
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //필수 인증,인감(보안) html 과 컨트롤 사이에 사용 로그랑
        // ServletRequest 받아오는 역할 ServletResponse 보내주는 역할 FilterChain 다음 단계 로 보내주는 역할
        //http - 프로토컬 규약
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //요청 정보 로깅
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Request Method: " + request.getMethod());

        //필터 체인 계속해서 다음 필터 또는 서블릿으로 전달
        chain.doFilter(request, response);

        //응답 상토 코드 로깅 <--
        System.out.println("Response status: " + response.getStatus());

    }

    @Override
    public void destroy() {
        //finally 같은 존재 필터 종료시 처리 (필요시점에만 사용) 업어도 됨
    }
}
