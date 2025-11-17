package com.korit.servlet_study.ch11.dto;

import com.korit.servlet_study.ch11.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private String code;
    private String name;
    private int professor_id;
    private int credit;
    private int enrollment_capacity;
    private String classroom;

    public Course toEntity() {
        return Course.builder()
                .course_code(code)
                .course_name(name)
                .professor_id(professor_id)
                .credit(credit)
                .enrollment_capacity(enrollment_capacity)
                .classroom(classroom)
                .build();
    }
}
