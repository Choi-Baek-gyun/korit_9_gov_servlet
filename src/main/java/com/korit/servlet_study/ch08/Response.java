package com.korit.servlet_study.ch08;

import lombok.Data;

@Data
public class Response {
    private String message;

    public Response(String message) {
        this.message = message;
    }
}
