package com.korit.servlet_study.ch05;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, javax.servlet.FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터2 전처리");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("필터2 후처리");
    }
}