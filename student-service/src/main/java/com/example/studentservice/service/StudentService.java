package com.example.studentservice.service;

import com.example.studentservice.dto.request.StudentCreateRequest;
import com.example.studentservice.dto.response.StudentCreateResponse;
import com.example.studentservice.dto.response.StudentIdResponse;

public interface StudentService {

    StudentCreateResponse createStudent (StudentCreateRequest studentCreateRequest);

    StudentIdResponse getByStudentId(long studentId);
}
