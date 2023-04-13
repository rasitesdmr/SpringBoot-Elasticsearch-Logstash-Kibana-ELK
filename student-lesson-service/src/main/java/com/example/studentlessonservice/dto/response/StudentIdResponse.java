package com.example.studentlessonservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentIdResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String SchoolNumber;

    private String identityNumber;

    private boolean active;
}
