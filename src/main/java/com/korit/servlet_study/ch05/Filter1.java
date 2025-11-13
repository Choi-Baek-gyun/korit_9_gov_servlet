package com.korit.servlet_study.ch05;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터1 전처리");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("필터1 후처리");
    }
}
