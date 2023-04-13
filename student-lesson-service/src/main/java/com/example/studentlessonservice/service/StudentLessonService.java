package com.example.studentlessonservice.service;

import com.example.studentlessonservice.dto.request.StudentLessonRequest;
import com.example.studentlessonservice.dto.response.StudentLessonResponse;

public interface StudentLessonService {

    StudentLessonResponse studentLessonMatch (StudentLessonRequest studentLessonRequest);
}
