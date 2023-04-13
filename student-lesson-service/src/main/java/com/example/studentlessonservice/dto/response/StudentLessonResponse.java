package com.example.studentlessonservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentLessonResponse {

    private Long id;

    private String studentFullName;

    private String  lessonCode;
}
