package com.example.studentlessonservice.feign;

import com.example.studentlessonservice.dto.response.LessonIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "lesson-service", url = "http://localhost:1002/lesson")
public interface LessonFeignClient {

    @GetMapping("/getByLessonId")
    LessonIdResponse getByLessonId (@RequestParam(name = "lessonId") long lessonId);



}
