package com.korit.servlet_study.ch05;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Filter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, javax.servlet.FilterChain filterChain) throws IOException, ServletException {

        System.out.println("필터3 전처리");
        filterChain.doFilter(request, response);
        System.out.println("필터3 후처리");
    }

}