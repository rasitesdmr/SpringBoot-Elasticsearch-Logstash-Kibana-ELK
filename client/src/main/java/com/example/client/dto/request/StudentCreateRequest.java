package com.example.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentCreateRequest {

    private String firstName;

    private String lastName;

    private String SchoolNumber;

    private String identityNumber;
}
