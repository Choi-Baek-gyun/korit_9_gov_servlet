package com.korit.servlet_study.ch09;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private String age;
    private String address;
    private String school;
}
