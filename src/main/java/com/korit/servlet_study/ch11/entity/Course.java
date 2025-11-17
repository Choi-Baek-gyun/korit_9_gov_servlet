package com.korit.servlet_study.ch11.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {
    private int course_id;
    private String course_code;
    private String course_name;
    private int professor_id;
    private int credit;
    private int enrollment_capacity;
    private String classroom;

}
