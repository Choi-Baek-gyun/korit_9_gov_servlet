package com.korit.servlet_study.ch08;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
    private String title;
    private String content;
    private String writer;
}
