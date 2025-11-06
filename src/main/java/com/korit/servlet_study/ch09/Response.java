package com.korit.servlet_study.ch09;

import lombok.Data;

@Data
public class Response {
    private String message;

    public Response(String message) {
        this.message = message;
    }
}
