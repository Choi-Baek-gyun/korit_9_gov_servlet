package com.korit.servlet_study.ch05;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Filter {
    void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain);

    void doFilter(Request req, Response resp, FilterChain filterChain);
}
