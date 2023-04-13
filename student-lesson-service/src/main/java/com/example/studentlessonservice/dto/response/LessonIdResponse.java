package com.example.studentlessonservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonIdResponse {

    private Long id;

    private String name;

    private String code;

    private boolean active;
}
