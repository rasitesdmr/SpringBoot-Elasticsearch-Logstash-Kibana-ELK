package com.example.studentlessonservice.controller;

import com.example.studentlessonservice.dto.request.StudentLessonRequest;
import com.example.studentlessonservice.dto.response.StudentIdResponse;
import com.example.studentlessonservice.dto.response.StudentLessonResponse;
import com.example.studentlessonservice.feign.StudentFeignClient;
import com.example.studentlessonservice.repository.StudentLessonRepository;
import com.example.studentlessonservice.service.StudentLessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentLesson")
@RequiredArgsConstructor
@Slf4j
public class StudentLessonController {

    private final StudentLessonService lessonService;

    @PostMapping("/studentLessonMatch")
   public ResponseEntity<StudentLessonResponse> studentLessonMatch(@RequestBody StudentLessonRequest studentLessonRequest){
       return new ResponseEntity<>(lessonService.studentLessonMatch(studentLessonRequest),HttpStatus.CREATED);
   }

}
