package com.example.lessonservice.service;

import com.example.lessonservice.dto.request.LessonCreateRequest;
import com.example.lessonservice.dto.response.LessonCreateResponse;
import com.example.lessonservice.dto.response.LessonIdResponse;

public interface LessonService {
    LessonCreateResponse createLesson(LessonCreateRequest lessonCreateRequest);

    LessonIdResponse getByLessonId(long lessonId);
}
