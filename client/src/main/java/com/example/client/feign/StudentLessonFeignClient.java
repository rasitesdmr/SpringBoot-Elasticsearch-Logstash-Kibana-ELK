package com.example.client.feign;

import com.example.client.dto.request.StudentLessonRequest;
import com.example.client.dto.response.StudentLessonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "student-lesson-service", url = "http://localhost:1003/studentLesson")
public interface StudentLessonFeignClient {

    @PostMapping("/studentLessonMatch")
    StudentLessonResponse studentLessonMatch(@RequestBody StudentLessonRequest studentLessonRequest);

}
