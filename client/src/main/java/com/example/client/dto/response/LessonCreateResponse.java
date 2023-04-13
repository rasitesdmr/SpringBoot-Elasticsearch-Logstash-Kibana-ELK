package com.example.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonCreateResponse {

    private Long id;

    private String name;

    private String code;

    private boolean active;

}
